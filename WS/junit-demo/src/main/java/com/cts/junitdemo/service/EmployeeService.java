package com.cts.junitdemo.service;

import java.util.List;

import com.cts.junitdemo.exception.DataOperationFailedException;
import com.cts.junitdemo.exception.InvalidEmployeeException;
import com.cts.junitdemo.model.Employee;

public interface EmployeeService {
	Employee add(Employee emp) throws DataOperationFailedException,InvalidEmployeeException;
	Employee modify(Employee emp) throws DataOperationFailedException,InvalidEmployeeException;
	Employee getById(long empId) throws DataOperationFailedException;
	List<Employee> getAll() throws DataOperationFailedException;
	void deleteById(long empId) throws DataOperationFailedException;
}
