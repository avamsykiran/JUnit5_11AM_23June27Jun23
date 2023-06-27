package com.cts.junitdemo.test.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.cts.junitdemo.exception.InvalidUserNameException;
import com.cts.junitdemo.service.GreetingService;

@DisplayName("Test GreetService")
public class GreetingServiceTest {
	
	GreetingService greetingService;
	
	@BeforeEach
	void init() {
		greetingService = new GreetingService();
	}
	
	@AfterEach
	void clean() {
		greetingService = null;
	}

	@Test
	@DisplayName("#greet should return 'Hello Vamsy' given 'Vamsy'")
	@Tag("bussinessLogic")
	void testGreet1() throws InvalidUserNameException {
		String userName = "Vamsy";
		String expected = "Hello Vamsy!";
		String actual = greetingService.greet(userName);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("#greet should throw InvalidUserNameException given null")
	@Tag("bussinessLogic")
	void testGreet2() {
		String userName = null;
		assertThrows(InvalidUserNameException.class, () -> {
			greetingService.greet(userName);
		});
	}

	@Test
	@DisplayName("#greetAsPerTime should return time based greeting given a user name or should throw InvalidUserNameException")
	@Tag("bussinessLogic")
	void testGreetAsPerTime() throws InvalidUserNameException {
		assertAll(() -> {
			String userName = "Vamsy";

			int hour = LocalDateTime.now().getHour();
			String greeting = "";

			if (hour >= 3 && hour <= 11)
				greeting = "Good Morning";
			else if (hour >= 12 && hour <= 17)
				greeting = "Good Noon";
			else
				greeting = "Good Evening";

			String expected = greeting + " " + userName + "!";
			String actual = greetingService.greetAsPerTime(userName);

			assertEquals(expected, actual);
		}, () -> {
			assertThrows(InvalidUserNameException.class, () -> {
				greetingService.greetAsPerTime(null);
			});
		});

	}
}
