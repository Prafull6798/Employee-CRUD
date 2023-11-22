package com.java.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "EMP_SPRING_BOOT")
@Entity
public class Employee {
	
	@Id
	private Integer empId;
	private String empName;
	private String empEmail;
	private String empRole;
	private double empSalary;
	private int empAge;
	private String empAddress;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer empId, String empName, String empEmail, String empRole, double empSalary, int empAge,
			String empAddress) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empRole = empRole;
		this.empSalary = empSalary;
		this.empAge = empAge;
		this.empAddress = empAddress;
	}
	@Override
	public String toString() {
		return "\n Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empRole=" + empRole
				+ ", empSalary=" + empSalary + ", empAge=" + empAge + ", empAddress=" + empAddress + "]";
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpRole() {
		return empRole;
	}
	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
}
