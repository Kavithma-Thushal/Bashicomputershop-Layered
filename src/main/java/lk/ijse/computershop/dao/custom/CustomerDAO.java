package lk.ijse.computershop.dao.custom;

import lk.ijse.computershop.dao.CrudDAO;
import lk.ijse.computershop.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO extends CrudDAO<Customer> {

    List<String> loadCustomerIds() throws SQLException;

    Customer searchByCustomerId(String customerId) throws SQLException;
}
