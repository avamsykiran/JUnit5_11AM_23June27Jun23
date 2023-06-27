package com.cts.junitdemo.test.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.junitdemo.exception.DataOperationFailedException;
import com.cts.junitdemo.model.Employee;
import com.cts.junitdemo.repo.EmployeeRepo;
import com.cts.junitdemo.service.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
@DisplayName("EmployeeServiceImpl")
public class EmployeeServiceImplTest {

	@Mock
	EmployeeRepo empRepo;

	EmployeeServiceImpl empServiceImpl;

	@BeforeEach
	void init() {
		empServiceImpl = new EmployeeServiceImpl(empRepo);
	}

	@AfterEach
	void clean() {
		empServiceImpl = null;
	}

	@Test
	@DisplayName("#deleteById should delete a record given existing record")
	void testDeleteByIdPositiveCase() throws DataOperationFailedException{
		Mockito.doNothing().when(empRepo).deleteById(101);		
		assertDoesNotThrow(() -> {empServiceImpl.deleteById(101);});
	}
	
	@Test
	@DisplayName("#deleteById should throw DataOperationFailedException given repo throws")
	void testDeleteByIdNegativeCase() throws DataOperationFailedException{
		Mockito.doThrow(new DataOperationFailedException("")).when(empRepo).deleteById(101);	
		assertThrows(DataOperationFailedException.class,() -> {empServiceImpl.deleteById(101);});
	}
	
	@Test
	@DisplayName("#getById should return a record given existing id")
	void testGetByIdPositiveCase() throws DataOperationFailedException{
		long testData = 101;
		Employee expected = new Employee(101, "Vamsy", 56789, LocalDate.now());
		Mockito.when(empRepo.getById(testData)).thenReturn(expected);
		Employee actual = empServiceImpl.getById(testData);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("#getById should return a null given a non-existing id")
	void testGetByIdNegativeCase() throws DataOperationFailedException{
		long testData = 101;
		Mockito.when(empRepo.getById(testData)).thenReturn(null);
		assertNull(empServiceImpl.getById(testData));
	}
}
