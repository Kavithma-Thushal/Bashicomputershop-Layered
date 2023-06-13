package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.DeliveryBO;
import lk.ijse.computershop.dao.DAOFactory;
import lk.ijse.computershop.dao.custom.DeliveryDAO;
import lk.ijse.computershop.dto.CustomerDTO;
import lk.ijse.computershop.dto.DeliveryDTO;
import lk.ijse.computershop.dto.EmployeeDTO;
import lk.ijse.computershop.entity.Delivery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryBOImpl implements DeliveryBO {

    private DeliveryDAO deliveryDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.DELIVERY);

    @Override
    public List<DeliveryDTO> loadAllDelivers() throws SQLException {
        List<DeliveryDTO> deliveryDTOList=new ArrayList<>();
        List<Delivery> deliveryList=deliveryDAO.loadAll();
        for (Delivery d:deliveryList) {
            deliveryDTOList.add(new DeliveryDTO(d.getCode(),d.getCustomerId(),d.getEmployeeId(),d.getOrderId(),d.getLocation(),d.getDate()));
        }
        return deliveryDTOList;
    }

    @Override
    public int saveDelivers(DeliveryDTO d) throws SQLException {
        return deliveryDAO.save(new Delivery(d.getCode(),d.getCustomerId(),d.getEmployeeId(),d.getOrderId(),d.getLocation(),d.getDate()));
    }

    @Override
    public String generateNextDeliverCode() throws SQLException {
        return deliveryDAO.generateNextId();
    }

    @Override
    public List<String> loadCustomerIds() throws SQLException {
        return null;
    }

    @Override
    public CustomerDTO searchByCustomerId(String customerId) throws SQLException {
        return null;
    }

    @Override
    public List<String> loadEmployeeIds() throws SQLException {
        return null;
    }

    @Override
    public EmployeeDTO searchByEmployeeId(String employeeId) throws SQLException {
        return null;
    }

    @Override
    public List<String> loadOrderIds() throws SQLException {
        return null;
    }
}
