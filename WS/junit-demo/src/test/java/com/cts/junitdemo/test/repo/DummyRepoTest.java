package com.cts.junitdemo.test.repo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cts.junitdemo.repo.DummyRepo;

@DisplayName("DummyRepo")
public class DummyRepoTest {

	private DummyRepo repo;
	
	@BeforeEach
	void init() {
		repo=new DummyRepo();
	}
	
	@AfterEach
	void clean() {
		repo=null;
	}
	
	@Test
	@DisplayName("#getGreetings")
	void testGetGreetings() {
		String[] expected = new String[] {
				"Hai","Hello","Good Morning","Good Evening","Good Noon"
		};
		
		String[] actual = repo.getGreetings();
		
		assertArrayEquals(expected, actual);
	}

	@Test
	@DisplayName("#getGreetingsList")
	void testGetGreetingsList() {
		List<String> expected = Arrays.asList(new String[] {
				"Hai","Hello","Good Morning","Good Evening","Good Noon"
		});
		
		List<String> actual = repo.getGreetingsList();
		
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("#getGreetingsListIgnoreOrder")
	void testGetGreetingsListIgnoreOrder() {
		List<String> expected = Arrays.asList(new String[] {
				"Hai","Hello","Good Evening","Good Noon","Good Morning"
		});
		
		List<String> actual = repo.getGreetingsList();
		
		assertTrue(expected.size()==actual.size() && actual.containsAll(expected));
	}
	
	@Test
	@DisplayName("#getGreetingsSet")
	void testGetGreetingsSet() {
		Set<String> expected = new HashSet<>(Arrays.asList(new String[] {
				"Hai","Hello","Good Morning","Good Evening","Good Noon"
		}));
		
		Set<String> actual = repo.getGreetingsSet();
		
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("#getGreetingsSetOfDiffertentTypes")
	void testGetGreetingsSetOfDiffertentTypes() {
		Set<String> expected = new TreeSet<>(Arrays.asList(new String[] {
				"Hai","Hello","Good Morning","Good Evening","Good Noon"
		}));
		
		Set<String> actual = repo.getGreetingsSet();
		
		assertEquals(expected, actual);
	}

}
