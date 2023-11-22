package com.java.spring;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.java.spring.entity.Employee;

@Service
public interface EmpServices extends JpaRepository<Employee, Integer> {
	
}
