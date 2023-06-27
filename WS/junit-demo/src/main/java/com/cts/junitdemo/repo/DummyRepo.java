package com.cts.junitdemo.repo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DummyRepo {

	public String[] getGreetings() {
		return new String[] {
				"Hai","Hello","Good Morning","Good Evening","Good Noon"
		};
	}
	
	public List<String> getGreetingsList() {
		return Arrays.asList(getGreetings());
	}
	
	public Set<String> getGreetingsSet() {
		return new HashSet<>(getGreetingsList());
	}
}
