package com.example.todolist.repo;

import com.example.todolist.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepo extends JpaRepository<Application, Long>{

}
