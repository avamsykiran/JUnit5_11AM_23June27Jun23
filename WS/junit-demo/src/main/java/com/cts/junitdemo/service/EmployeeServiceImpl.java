package com.cts.junitdemo.service;

import java.util.List;

import com.cts.junitdemo.exception.DataOperationFailedException;
import com.cts.junitdemo.exception.InvalidEmployeeException;
import com.cts.junitdemo.model.Employee;
import com.cts.junitdemo.repo.EmployeeRepo;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepo empRepo;
	
	public EmployeeServiceImpl(EmployeeRepo empRepo) {
		this.empRepo=empRepo;
	}
	
	private String isValidEmployee(Employee emp) {
		StringBuffer sb = new StringBuffer();
		/*we will write code to validate the employee...*/
		return sb.length()==0?null:sb.toString();
	}
	
	@Override
	public Employee add(Employee emp) throws DataOperationFailedException, InvalidEmployeeException {
		if(emp!=null) {
			String errors = isValidEmployee(emp);
			if(errors==null) {
				emp = empRepo.add(emp);
			}else {
				throw new InvalidEmployeeException(errors);	
			}
		}else {
			throw new InvalidEmployeeException("No Employee Deatils ");
		}
		return emp;
	}

	@Override
	public Employee modify(Employee emp) throws DataOperationFailedException, InvalidEmployeeException {
		if(emp!=null) {
			String errors = isValidEmployee(emp);
			if(errors==null) {
				emp = empRepo.modify(emp);
			}else {
				throw new InvalidEmployeeException(errors);	
			}
		}else {
			throw new InvalidEmployeeException("No Employee Deatils ");
		}
		return emp;
	}

	@Override
	public Employee getById(long empId) throws DataOperationFailedException {
		return empRepo.getById(empId);
	}

	@Override
	public List<Employee> getAll() throws DataOperationFailedException {
		return empRepo.getAll();
	}

	@Override
	public void deleteById(long empId) throws DataOperationFailedException {
		empRepo.deleteById(empId);
	}

}
