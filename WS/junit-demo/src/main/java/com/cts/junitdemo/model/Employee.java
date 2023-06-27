package com.cts.junitdemo.model;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {

	private long empId;
	private String fullName;
	private double salary;
	private LocalDate joinDate;
	
	public Employee(){}

	public Employee(long empId, String fullName, double salary, LocalDate joinDate) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.salary = salary;
		this.joinDate = joinDate;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, fullName, joinDate, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empId == other.empId && Objects.equals(fullName, other.fullName)
				&& Objects.equals(joinDate, other.joinDate)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}

	
	
}
