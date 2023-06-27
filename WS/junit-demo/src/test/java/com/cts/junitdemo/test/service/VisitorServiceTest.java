package com.cts.junitdemo.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.cts.junitdemo.exception.InvalidVisitorException;
import com.cts.junitdemo.model.Gender;
import com.cts.junitdemo.model.Visitor;
import com.cts.junitdemo.service.VisitorService;

@DisplayName("VisitorService")
public class VisitorServiceTest {

	VisitorService visitorService;

	@BeforeEach
	void beforeStatringEachTestCase() {
		this.visitorService = new VisitorService();
	}

	@AfterEach
	void afterExecutingEachTestCase() {
		this.visitorService = null;
	}

	@ParameterizedTest
	@DisplayName("#isValidTitle should return true given valid values")
	@ValueSource(strings = { "Master.", "Baby.", "Mr.", "Mrs.", "Ms.", "Miss." })
	@Tag("validationLogic")
	void testIsValidTitlePositiveCase(String validTitle) {
		assertTrue(visitorService.isValidTitle(validTitle));
	}

	@ParameterizedTest
	@DisplayName("#isValidTitle should return false given invalid values")
	@ValueSource(strings = { "xyz" })
	@Tag("validationLogic")
	void testIsValidTitleNegativeCase(String inValidTitle) {
		assertFalse(visitorService.isValidTitle(inValidTitle));
	}
	
	@ParameterizedTest
	@DisplayName("#isValidFullName")
	@CsvSource({"A Vamsy Kiran,true","A@Vamsy,false","123Vamsy,false","A.Vamsy,false"})
	@Tag("validationLogic")
	void testIsValidFullName(String fullName, boolean expectedResult) {
		assertEquals(expectedResult, visitorService.isValidFullName(fullName));
	}
	
	@ParameterizedTest
	@DisplayName("#isValidGender should return true given valid gender")
	@EnumSource(Gender.class)
	@Tag("validationLogic")
	void testIsValidGenderPositiveCase(Gender gender) {
		assertTrue(visitorService.isValidGender(gender));
	}
	
	@ParameterizedTest
	@DisplayName("#isValidGender should return false given null")
	@NullSource
	@Tag("validationLogic")
	void testIsValidGenderNegativeCase(Gender gender) {
		assertFalse(visitorService.isValidGender(gender));
	}
	
	@ParameterizedTest
	@DisplayName("#isValidDateOfBirth")
	@MethodSource("supplyTestDataForIsValidDateOfBirth")
	@Tag("validationLogic")
	void testIsValidDateOfBirth(LocalDate date,boolean expected) {
		assertEquals(expected, visitorService.isValidDateOfBirth(date));
	}
	
	@ParameterizedTest
	@DisplayName("#createVisitor should throw InvalidVisitorException given invalid values")
	@MethodSource("supplyTestDataForCreateVisitorNegativeCase")
	@Tag("bussinessLogic")
	void testCreateVisitorNegativeCase(String title,String fullName,Gender gender,LocalDate dob) throws InvalidVisitorException {
		assertThrows(InvalidVisitorException.class, ()->{
			visitorService.createVisitor(title,fullName,gender,dob);
		});
	}
	
	@Test
	@DisplayName("#createVisitor should return Visitor object given all valid values")
	@Tag("bussinessLogic")
	void testCreateVisitorPositiveCase() throws InvalidVisitorException {
		// Test Data
		String title = "Mr.";
		String fullName = "Vamsy";
		Gender gender = Gender.GENT;
		LocalDate dateOfBirth = LocalDate.now().minusYears(20);
		// Expected
		Visitor expected = new Visitor(title, fullName, dateOfBirth, 20, gender);
		// Actual
		Visitor actual = visitorService.createVisitor(title, fullName, gender, dateOfBirth);
		assertEquals(expected, actual);
	}
	
	static Stream<Arguments> supplyTestDataForCreateVisitorNegativeCase(){
		return Stream.of(
				Arguments.of(null,null,null,null),
				Arguments.of("Mr.","A Vamsy",null,LocalDate.now()),
				Arguments.of("Mr.","A Vamsy",Gender.GENT,LocalDate.now().plusDays(1)),
				Arguments.of("Mr.","A.Vamsy",Gender.GENT,LocalDate.now()),
				Arguments.of("Mr","A Vamsy",Gender.GENT,LocalDate.now())
				);
	}
	
	static Stream<Arguments> supplyTestDataForIsValidDateOfBirth(){
		return Stream.of(
				Arguments.of(LocalDate.now().minusDays(1),true),
				Arguments.of(LocalDate.now(),true),
				Arguments.of(LocalDate.now().plusDays(1),false)
				);
	}
		
}
