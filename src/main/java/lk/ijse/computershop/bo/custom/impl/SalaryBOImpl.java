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

    private SalaryDAO salaryDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.SALARY);
    private EmployeeDAO employeeDAO=DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public int saveSalary(SalaryDTO s) throws SQLException{
        return salaryDAO.save(new Salary(s.getCode(),s.getEmployeeId(),s.getAmount(),s.getDate()));
    }

    @Override
    public List<SalaryDTO> loadAllSalary() throws SQLException {
        List<SalaryDTO> salaryDTOList = new ArrayList<>();
        List<Salary> salaryList = salaryDAO.loadAll();
        for (Salary s : salaryList) {
            salaryDTOList.add(new SalaryDTO(s.getCode(), s.getEmployeeId(), s.getAmount(), s.getDate()));
        }
        return salaryDTOList;
    }

    @Override
    public String generateNextSalaryCode() throws SQLException {
        return salaryDAO.generateNextId();
    }

    @Override
    public List<String> loadEmployeeIds() throws SQLException {
        return employeeDAO.loadEmployeeIds();
    }

    @Override
    public EmployeeDTO searchByEmployeeId(String id) throws SQLException {
        Employee e=employeeDAO.search(id);
        return new EmployeeDTO(e.getId(),e.getName(),e.getContact(),e.getJobRole(),e.getUsername(),e.getPassword());
    }
}
