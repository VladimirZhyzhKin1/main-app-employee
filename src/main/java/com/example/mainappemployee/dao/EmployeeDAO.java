package com.example.mainappemployee.dao;

import com.example.mainappemployee.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

}
