package com.cts.junitdemo.repo;

import java.time.LocalDate;

import com.cts.junitdemo.model.Gender;
import com.cts.junitdemo.model.Visitor;

public class VisitorRepo {
	
	public Visitor[] getVisitors() {
		return new Visitor[] {
				new Visitor("Mr.", "Vamsy", LocalDate.now(), 0, Gender.GENT),
				new Visitor("Ms.", "Sravani", LocalDate.now(), 0, Gender.LADY),
				new Visitor("Mr.", "Vinay", LocalDate.now(), 0, Gender.GENT),
				new Visitor("Mrs.", "Latha", LocalDate.now(), 0, Gender.LADY)
		};
	}

}
