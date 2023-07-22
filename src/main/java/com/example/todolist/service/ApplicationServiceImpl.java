package com.example.todolist.service;

import com.example.todolist.model.Application;
import com.example.todolist.repo.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService{
    @Autowired
    ApplicationRepo applicationRepo;

    @Override
    public List<Application> getApplications() {
        return null;
    }

    @Override
    public void addApplication(Application application) {
        application.setApplication_id(null);
        application.setFilling_time(new Timestamp(System.currentTimeMillis()));
        applicationRepo.save(application);
    }

    @Override
    public void deleteApplication(Long id) {
        applicationRepo.deleteById(id);
    }

    @Override
    public List<Application> getApplications(String keyWord) {
        return null;
    }

    @Override
    public Application getApplication(Long id) {
        return applicationRepo.findById(id);
    }

    @Override
    public void updateApplication(Application application) {
        applicationRepo.save(application);
    }
}
