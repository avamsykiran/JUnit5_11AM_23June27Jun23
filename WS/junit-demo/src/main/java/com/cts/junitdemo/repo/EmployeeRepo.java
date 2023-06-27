package com.cts.junitdemo.repo;

import java.util.List;

import com.cts.junitdemo.exception.DataOperationFailedException;
import com.cts.junitdemo.model.Employee;

public interface EmployeeRepo {
	Employee add(Employee emp) throws DataOperationFailedException;
	Employee modify(Employee emp) throws DataOperationFailedException;
	Employee getById(long empId) throws DataOperationFailedException;
	List<Employee> getAll() throws DataOperationFailedException;
	void deleteById(long empId) throws DataOperationFailedException;
}
