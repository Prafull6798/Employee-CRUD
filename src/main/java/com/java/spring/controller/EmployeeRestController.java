package com.java.spring.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.spring.EmpServices;
import com.java.spring.entity.Employee;



@RestController
@RequestMapping("/employee/api")
public class EmployeeRestController { // http://localhost:8082/bootapi/employee/api

	@Autowired
	private EmpServices service;

	// Add employee
	@PostMapping("/")
	public Employee addEmployee(@RequestBody Employee emp) {
		service.save(emp);
		return emp;
	}

	// Delete employee // @RequestParam to get a parameter from query parameters-->extract the encoded value
	@DeleteMapping("/{empId}")
	public String deleteEmp(@RequestParam("empId") int empId) {
		Employee emp = service.getById(empId);
		if (emp != null) {
			service.delete(emp);
			return "Employee Successfully deleted";
		}
		return "Employee Not Found";
	}

	// List employee
	@GetMapping("/list")
	public List<Employee> getAllEmps() {
		return service.findAll();
	}

	// Edit/Update employee // @PathVariable to get the value from the URI-->extract the exactly value from URI

	@PutMapping(value = "/edit/{empId}")
	public ResponseEntity<?> updateEmployee(@PathVariable("empId") int id, @RequestBody Employee empBean) {

		Employee employee = service.getById(id);
		employee.setEmpName(empBean.getEmpName());
		employee.setEmpAddress(empBean.getEmpAddress());
		employee.setEmpAge(empBean.getEmpAge());
		employee.setEmpEmail(empBean.getEmpEmail());
		employee.setEmpRole(empBean.getEmpRole());
		employee.setEmpSalary(empBean.getEmpSalary());
		
		return new ResponseEntity<>(employee, HttpStatus.EXPECTATION_FAILED);
	}

	@GetMapping("/{eid}")
	public ResponseEntity<?> searchById(@PathVariable("eid") int empId) {
		Optional<Employee> empRecord = service.findById(empId);
		if (empRecord.isPresent()) {
			Employee emp = empRecord.get();
			return new ResponseEntity<>(emp, HttpStatus.OK);
		}
		System.out.println("Employee Record with given Id not found");
		return new ResponseEntity<>("Employee not Found", HttpStatus.EXPECTATION_FAILED);
	}

}
