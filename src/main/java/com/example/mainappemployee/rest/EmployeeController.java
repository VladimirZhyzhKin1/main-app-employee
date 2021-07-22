package com.example.mainappemployee.rest;

import com.example.mainappemployee.dto.Employee;
import com.example.mainappemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String findAll(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping("/employee-create")
    public String createEmployeeForm(Employee employee){
        return "employee-create";
    }

    @PostMapping("/user-create") //http post
    public String createEmployee(Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }
}
