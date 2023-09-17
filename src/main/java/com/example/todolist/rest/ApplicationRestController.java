package com.example.todolist.rest;

import com.example.todolist.model.Application;
import com.example.todolist.model.Task;
import com.example.todolist.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(value = "Applications",produces = MediaType.APPLICATION_JSON_VALUE)
public class ApplicationRestController {
    @Autowired
    ApplicationService applicationService;

    @GetMapping()
    ResponseEntity<List<Application>> getAllApplications() {
        List<Application> result = this.applicationService.getApplications();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{id}")
    ResponseEntity<Application> getApplicatoin(@RequestParam("id") Application application)
    {
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<Application> addApplication(@RequestBody Application application)
    {
        application.setFilling_time(new Timestamp(System.currentTimeMillis()));
        application.setApplication_id(null);
        this.applicationService.addApplication(application);
        return new ResponseEntity<>(application, HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"id"})
    ResponseEntity<String> deleteApplication(@RequestParam("id") Long id)
    {
        this.applicationService.deleteApplication(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PutMapping("{id}")
    ResponseEntity<Application> updateApplication(@RequestBody Application application,
                                           @RequestParam("id") Application application_old )
    {
        this.applicationService.updateApplication(application_old,application);
        return new ResponseEntity<>(application, HttpStatus.OK);
    }
}
