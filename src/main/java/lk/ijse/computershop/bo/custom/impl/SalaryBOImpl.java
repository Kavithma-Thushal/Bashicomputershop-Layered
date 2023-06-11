package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.SalaryBO;
import lk.ijse.computershop.dao.DAOFactory;
import lk.ijse.computershop.dao.custom.EmployeeDAO;
import lk.ijse.computershop.dao.custom.SalaryDAO;
import lk.ijse.computershop.dto.EmployeeDTO;
import lk.ijse.computershop.dto.SalaryDTO;
import lk.ijse.computershop.entity.Employee;
import lk.ijse.computershop.entity.Salary;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryBOImpl implements SalaryBO {

    private EmployeeDAO employeeDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    private SalaryDAO salaryDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.SALARY);

    @Override
    public List<SalaryDTO> getAll() throws SQLException {
        List<SalaryDTO> salaryDTOS = new ArrayList<>();
        List<Salary> salaries = salaryDAO.getAll();
        for (Salary s : salaries) {
            salaryDTOS.add(new SalaryDTO(s.getCode(),s.getEmployeeId(),s.getAmount(),s.getDate()));
        }
        return salaryDTOS;
    }

    @Override
    public String getNextId() throws SQLException {
        return salaryDAO.getNextId();
    }

    @Override
    public List<String> loadEmployeeIds() throws SQLException {
        return employeeDAO.loadEmployeeIds();
    }

    @Override
    public EmployeeDTO searchByEmployeeId(String employeeId) throws SQLException {
        Employee e=employeeDAO.searchById(employeeId);
        return new EmployeeDTO(e.getId(),e.getName(),e.getContact(),e.getJobRole(),e.getUsername(),e.getPassword());
    }
}
