package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.CustombuildsBO;
import lk.ijse.computershop.dao.DAOFactory;
import lk.ijse.computershop.dao.custom.*;
import lk.ijse.computershop.db.DBConnection;
import lk.ijse.computershop.dto.CustombuildsDTO;
import lk.ijse.computershop.dto.CustomerDTO;
import lk.ijse.computershop.dto.EmployeeDTO;
import lk.ijse.computershop.dto.ItemDTO;
import lk.ijse.computershop.entity.Custombuilds;
import lk.ijse.computershop.entity.Customer;
import lk.ijse.computershop.entity.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class CustombuildsBOImpl implements CustombuildsBO {

    private CustomerDAO customerDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private EmployeeDAO employeeDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    private ItemDAO itemDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    private CustombuildsDAO custombuildsDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMBUILDS);
    private BuildDetailsDAO buildDetailsDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.BUILDDETAILS);

    /*Transaction*/
    @Override
    public boolean makeBuild(String buildCode, String customerId, String employeeId, List<CustombuildsDTO> buildList) throws SQLException {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            Integer isSaved = custombuildsDAO.save(new Custombuilds(buildCode, customerId, employeeId));     //orders
            if (isSaved>0) {
                boolean isBuild = buildDetailsDAO.saveBuild(buildCode, buildList, LocalDate.now());      //order_details
                if (isBuild) {
                    boolean isUpdated = itemDAO.updateBuildQty(buildList);     //items update
                    if (isUpdated) {
                        connection.commit();
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public String getNextId() throws SQLException {
        return custombuildsDAO.getNextId();
    }

    @Override
    public List<String> loadCustomerIds() throws SQLException {
        return customerDAO.loadIds();
    }

    @Override
    public List<String> loadEmployeeIds() throws SQLException {
        return employeeDAO.loadEmployeeIds();
    }

    @Override
    public List<String> loadItemCodes() throws SQLException {
        return itemDAO.loadCodes();
    }

    @Override
    public CustomerDTO searchByCustomerId(String customerId) throws SQLException {
        Customer customer = customerDAO.searchById(customerId);
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getNic(), customer.getEmail(), customer.getContact(), customer.getAddress());
    }

    @Override
    public EmployeeDTO searchByEmployeeId(String employeeId) throws SQLException {
        Employee e=employeeDAO.searchById(employeeId);
        return new EmployeeDTO(e.getId(),e.getName(),e.getContact(),e.getJobRole(),e.getUsername(),e.getPassword());
    }

    @Override
    public ItemDTO searchByItemCodes(String itemCode) throws SQLException {
        return itemDAO.searchById(itemCode);
    }
}
