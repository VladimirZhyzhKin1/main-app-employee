package com.example.mainappemployee.rest;

import com.example.mainappemployee.dto.Employee;
import com.example.mainappemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String createEmployeeForm(Employee employee) {
        return "employee-create";
    }

    @PostMapping("/employee-create")//http post
    public String createEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employee-delete/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        employeeService.deleteById(employeeId);
        return "redirect:/employees";
    }

    @GetMapping("/employee-update/{employeeId}")
    public String updateEmployeeForm(@PathVariable("employeeId") Long employeeId, Model model) {
        Employee employee = employeeService.findById(employeeId);
        model.addAttribute("employee", employee);
        return "/employee-update";
    }

    @PostMapping("/employee-update")//http post
    public String updateEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

}
