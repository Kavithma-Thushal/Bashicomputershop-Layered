package lk.ijse.computershop.dao.custom;

import lk.ijse.computershop.dao.CrudDAO;
import lk.ijse.computershop.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO extends CrudDAO<Employee> {

    List<String> loadEmployeeIds() throws SQLException;

    //List<String> loadEmployeeIdsToRepair() throws SQLException;
}
