package com.example.mainappemployee.service;

import com.example.mainappemployee.dao.EmployeeDAO;
import com.example.mainappemployee.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public Employee findById(Long id) {
        return employeeDAO.findById(id).orElse(null);
    }

    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeDAO.save(employee);
    }

    public void deleteById(Long id) {
        employeeDAO.deleteById(id);
    }
}
