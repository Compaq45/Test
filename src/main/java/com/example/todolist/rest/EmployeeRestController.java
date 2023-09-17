package com.example.todolist.rest;

import com.example.todolist.model.Comment;
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
@RequestMapping(value ="/Employee",produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeRestController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping()
    ResponseEntity<String> addEmployee(@RequestBody Employee employee)
    {
        employee.setAdded_timestamp(new Timestamp(System.currentTimeMillis()));
        employee.setEmployee_id(null);
        this.employeeService.addEmployee(employee);
        return new ResponseEntity<>("Added",HttpStatus.ACCEPTED);
    }

    @DeleteMapping(params = {"id"})
    ResponseEntity<String> deleteEmployee(@RequestParam("id") Long employeeId) {
        if(this.employeeService.getEmployee(employeeId)!=null)
            this.employeeService.deleteEmployee(employeeId);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>("Deleted",HttpStatus.ACCEPTED);
    }

    @GetMapping( )
    ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> result = this.employeeService.getEmployees();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(params = "{id}")
    ResponseEntity<Employee> getEmployee(@RequestParam("id") Long employeeId) {
        Employee result = this.employeeService.getEmployee(employeeId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("{id}")
    ResponseEntity<Employee> updateTask(@RequestBody Employee employee,
                                       @RequestParam("id") Employee employee_old )
    {
        employeeService.updateEmployee(employee_old, employee);
        return new ResponseEntity<>(employee_old, HttpStatus.OK);
    }
}
