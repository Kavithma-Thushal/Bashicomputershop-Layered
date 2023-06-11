package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.OrdersBO;
import lk.ijse.computershop.dao.DAOFactory;
import lk.ijse.computershop.dao.custom.CustomerDAO;
import lk.ijse.computershop.dao.custom.impl.ItemDAOImpl;
import lk.ijse.computershop.dao.custom.impl.OrderDetailsDAOImpl;
import lk.ijse.computershop.dao.custom.impl.OrdersDAOImpl;
import lk.ijse.computershop.db.DBConnection;
import lk.ijse.computershop.dto.CustomerDTO;
import lk.ijse.computershop.dto.ItemDTO;
import lk.ijse.computershop.dto.OrderDTO;
import lk.ijse.computershop.entity.Customer;
import lk.ijse.computershop.entity.Orders;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class OrdersBOImpl implements OrdersBO {

    private CustomerDAO customerDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private ItemDAOImpl itemDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    private OrdersDAOImpl ordersDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDERS);
    private OrderDetailsDAOImpl orderDetailsDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);

    /*Transaction*/
    @Override
    public boolean placeOrder(String orderId, String customerId, List<OrderDTO> orderDTOList) throws SQLException {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            Integer isSaved = ordersDAO.save(new Orders(orderId, customerId));     //orders
            if (isSaved>0) {
                boolean isOrdered = orderDetailsDAO.placeOrder(orderId, orderDTOList, LocalDate.now());      //order_details
                if (isOrdered) {
                    boolean isUpdated = itemDAO.updateOrderQty(orderDTOList);     //items update
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
    public List<String> loadOrderIds() throws SQLException {
        return ordersDAO.loadOrderIds();
    }

    @Override
    public String generateNextOrderId() throws SQLException {
        return ordersDAO.generateNextId();
    }

    @Override
    public List<String> loadCustomerIds() throws SQLException {
        return customerDAO.loadCustomerIds();
    }

    @Override
    public CustomerDTO searchByCustomerId(String customerId) throws SQLException {
        Customer customer = customerDAO.searchByCustomerId(customerId);
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getNic(), customer.getEmail(), customer.getContact(), customer.getAddress());
    }

    @Override
    public List<String> loadItemCodes() throws SQLException {
        return itemDAO.loadItemCodes();
    }

    @Override
    public ItemDTO searchByOrderId(String itemCode) throws SQLException {
        return itemDAO.searchByItemCode(itemCode);
    }
}
