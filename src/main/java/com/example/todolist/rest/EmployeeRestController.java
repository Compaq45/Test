package com.example.todolist.rest;

import com.example.todolist.model.Employee;
import com.example.todolist.model.Task;
import com.example.todolist.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeRestController {
    @Autowired
    EmployeeService employeeService;

    @PutMapping(value = "/Employee/")
    ResponseEntity<String> addTask(@RequestBody Employee employee)
    {
        employee.setAdded_timestamp(new Timestamp(System.currentTimeMillis()));
        employee.setEmployee_id(null);
        this.employeeService.addEmployee(employee);
        return new ResponseEntity<>("Added",HttpStatus.ACCEPTED);
    }

    @DeleteMapping( value = "/Employee/", params = {"id"})
    ResponseEntity<String> delete(@RequestParam("id") Long employeeId) {
        if(this.employeeService.getEmployee(employeeId)!=null)
            this.employeeService.deleteEmployee(employeeId);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>("Success",HttpStatus.ACCEPTED);
    }

    @GetMapping( "/Employees")
    ResponseEntity<List<Employee>> getAllTasks() {
        List<Employee> result = this.employeeService.getEmployees();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/Employee/", params = "id")
    ResponseEntity<Employee> getTask(@RequestParam("id") Long employeeId) {
        Employee result = this.employeeService.getEmployee(employeeId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping(value = "/Employee/")
    ResponseEntity<String> updateTask(@RequestBody @Validated Employee employee)
    {
        Employee target=this.employeeService.getEmployee(employee.getEmployee_id());
        if(target!=null) {
            this.employeeService.updateEmployee(employee);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
