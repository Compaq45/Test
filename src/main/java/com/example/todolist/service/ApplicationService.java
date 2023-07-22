package com.example.todolist.service;

import com.example.todolist.model.Application;

import java.util.List;

public interface ApplicationService {

    List<Application> getApplications(); //All Applications return
    void addApplication(Application application); // add a new Application to DB
    void deleteApplication(Long id); // removes Application from DB by ID
    List<Application> getApplications(String keyWord); // Search Applications by keyword
    Application getApplication(Long id); // get Application by ID
    void updateApplication(Application application); //update Application
}
