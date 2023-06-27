package com.cts.junitdemo.service;

import java.time.LocalDate;
import java.time.Period;

import com.cts.junitdemo.exception.InvalidVisitorException;
import com.cts.junitdemo.model.Gender;
import com.cts.junitdemo.model.Visitor;

public class VisitorService {

	public boolean isValidTitle(String title) {
		// title can not be null and title must be any of
		// 'Master.',"Baby.","Mr.","Mrs.","Ms.","Miss."
		return title != null && title.matches("Master.|Baby.|Mr.|Mrs.|Ms.|Miss.");
	}

	public boolean isValidFullName(String fullName) {
		// must not be null and must be of atleast 5 chars to atmax of 50 chars in
		// length
		// can not start with a number or space
		// no special chars except space, numbers and alphas are allowed
		return fullName != null && fullName.matches("[A-Za-z][A-Za-z0-9\\s]{4,49}");
	}

	public boolean isValidGender(Gender gender) {
		// can't be null
		return (gender != null);
	}

	public boolean isValidDateOfBirth(LocalDate dateOfBirth) {
		// can not be a future date or null
		return (dateOfBirth != null && dateOfBirth.compareTo(LocalDate.now()) <= 0);
	}

	public Visitor createVisitor(String title, String fullName, Gender gender, LocalDate dateOfBirth) throws InvalidVisitorException {
		StringBuffer sb = new StringBuffer();
		if (isValidTitle(title) == false)
			sb.append("\n\tInvalid Title");
		if (isValidFullName(fullName) == false)
			sb.append("\n\tInvalid FullName");
		if (isValidGender(gender) == false)
			sb.append("\n\tInvalid Gender");
		if (isValidDateOfBirth(dateOfBirth) == false)
			sb.append("\n\tInvalid DateOfBirth");

		if(sb.length()>0)
			throw new InvalidVisitorException(sb.toString());
		
		int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
		return new Visitor(title, fullName, dateOfBirth, age, gender);
	}
}
