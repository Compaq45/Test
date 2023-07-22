package com.example.todolist.service;

import com.example.todolist.model.Employee;
import com.example.todolist.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepo.findById(id).get();
    }

    @Override
    public void addEmployee(Employee employee) {
        employee.setAdded_timestamp(new Timestamp(System.currentTimeMillis()));
        employee.setEmployee_id(null);
        employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepo.save(employee);
    }
}
