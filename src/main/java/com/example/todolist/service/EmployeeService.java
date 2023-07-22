package com.example.todolist.service;

import com.example.todolist.model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee getEmployee(Long id);
    void addEmployee(Employee employee);
    void deleteEmployee(Long id);
    void updateEmployee(Employee employee);
}
