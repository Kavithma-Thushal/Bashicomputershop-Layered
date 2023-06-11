package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.EmployeeBO;
import lk.ijse.computershop.dao.DAOFactory;
import lk.ijse.computershop.dao.custom.EmployeeDAO;
import lk.ijse.computershop.dto.EmployeeDTO;
import lk.ijse.computershop.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    private EmployeeDAO employeeDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public int save(EmployeeDTO employeeDTO) throws SQLException {
        return employeeDAO.save(new Employee(
                        employeeDTO.getId(),
                        employeeDTO.getName(),
                        employeeDTO.getContact(),
                        employeeDTO.getJobRole(),
                        employeeDTO.getUsername(),
                        employeeDTO.getPassword()
                )
        );

    }

    @Override
    public EmployeeDTO search(String id) throws SQLException {
        Employee employee=employeeDAO.search(id);
        return new EmployeeDTO(employee.getId(),employee.getName(),employee.getContact(),employee.getJobRole(),employee.getUsername(),employee.getPassword());
    }

    @Override
    public int update(EmployeeDTO employeeDTO) throws SQLException {
        return employeeDAO.update(new Employee(
                        employeeDTO.getId(),
                        employeeDTO.getName(),
                        employeeDTO.getContact(),
                        employeeDTO.getJobRole(),
                        employeeDTO.getUsername(),
                        employeeDTO.getPassword()
                )
        );
    }

    @Override
    public int delete(String id) throws SQLException {
        return employeeDAO.delete(id);
    }

    @Override
    public List<EmployeeDTO> getAll() throws SQLException {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        List<Employee> employees = employeeDAO.getAll();
        for (Employee e : employees) {
            employeeDTOList.add(new EmployeeDTO(e.getId(),e.getName(),e.getContact(),e.getJobRole(),e.getUsername(),e.getPassword()));
        }
        return employeeDTOList;
    }

    @Override
    public String getNextId() throws SQLException {
        return employeeDAO.getNextId();
    }

    @Override
    public List<String> loadEmployeeIds() throws SQLException {
        return employeeDAO.loadEmployeeIds();
    }

    @Override
    public EmployeeDTO searchById(String employeeId) throws SQLException {
        Employee e=employeeDAO.searchById(employeeId);
        return new EmployeeDTO(e.getId(),e.getName(),e.getContact(),e.getJobRole(),e.getUsername(),e.getPassword());
    }
}
