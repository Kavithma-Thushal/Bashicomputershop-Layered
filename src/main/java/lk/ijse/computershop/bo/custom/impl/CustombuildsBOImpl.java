package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.CustombuildsBO;
import lk.ijse.computershop.dao.DAOFactory;
import lk.ijse.computershop.dao.custom.*;
import lk.ijse.computershop.db.DBConnection;
import lk.ijse.computershop.dto.*;
import lk.ijse.computershop.entity.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustombuildsBOImpl implements CustombuildsBO {

    private CustombuildsDAO custombuildsDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.BUILD);
    private BuildDetailsDAO buildDetailsDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.BUILDDETAILS);
    private CustomerDAO customerDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private EmployeeDAO employeeDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    private ItemDAO itemDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public String generateNextBuildCode() throws SQLException {
        return custombuildsDAO.generateNextId();
    }

    @Override
    public List<String> loadCustomerIds() throws SQLException {
        return customerDAO.loadCustomerIds();
    }

    @Override
    public CustomerDTO searchByCustomerId(String id) throws SQLException {
        Customer c = customerDAO.search(id);
        return new CustomerDTO(c.getId(), c.getName(), c.getNic(), c.getEmail(), c.getContact(), c.getAddress());
    }

    @Override
    public List<String> loadEmployeeIds() throws SQLException {
        return employeeDAO.loadEmployeeIds();
    }

    @Override
    public EmployeeDTO searchByEmployeeId(String id) throws SQLException {
        Employee e = employeeDAO.search(id);
        return new EmployeeDTO(e.getId(), e.getName(), e.getContact(), e.getJobRole(), e.getUsername(), e.getPassword());
    }

    @Override
    public List<String> loadItemCodes() throws SQLException {
        return itemDAO.loadItemCodes();
    }

    @Override
    public ItemDTO searchByItemCodes(String code) throws SQLException {
        Item i = itemDAO.search(code);
        return new ItemDTO(i.getCode(), i.getDescription(), i.getUnitPrice(), i.getQtyOnHand());
    }

    @Override
    public boolean makeBuild(custombuildsDTO dto) throws SQLException {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            connection.setAutoCommit(false);

            int build_Save = custombuildsDAO.save(new Custombuilds(dto.getCode(), dto.getCustomerId(), dto.getEmployeeId()));
            if (build_Save > 0) {
                boolean success = true;

                for (Build_DetailsDTO detailsDTO : dto.getBuildDetailsDTOList()) {

                    int makeBuildItem_Update = itemDAO.updateCustombuildQty(new Build_Details(detailsDTO.getBuildCode(), detailsDTO.getItemCode(), detailsDTO.getQty(), detailsDTO.getTotal(), detailsDTO.getDate()));
                    if (makeBuildItem_Update <= 0) {
                        success = false;
                        break;
                    }

                    int buildDetails_Save = buildDetailsDAO.save(new Build_Details(detailsDTO.getBuildCode(), detailsDTO.getItemCode(), detailsDTO.getQty(), detailsDTO.getTotal(), detailsDTO.getDate()));
                    if (buildDetails_Save <= 0) {
                        success = false;
                        break;
                    }
                }

                if (success) {
                    connection.commit();
                    connection.setAutoCommit(true);
                    return true;
                }
            }

            connection.rollback();
            connection.setAutoCommit(true);
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
