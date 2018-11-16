package com.ram.unit3;

import java.util.Arrays;
import java.util.List;

import com.ram.unit1.Person;

public class StreamsExample1 {

	public static void main(String[] args) {

		List<Person> persons = Arrays.asList(
				new Person("CHARAN", "DODLA", 20),
				new Person("LOVELY", "CARROL", 25), 
				new Person("THOMAS", "CARLYLE", 30), 
				new Person("CHARLOTTE", "BRONTE", 35),
				new Person("MATHEW", "ARNOLD", 40));
		
		System.out.println("PERSONS FIRST NAME STARTS WITH 'C'");
		persons.stream().
		filter(p -> p.getFirstName().startsWith("C")).
		forEach(p -> System.out.println(p.getFirstName()));
		
		System.out.println("\nPERSONS FIRST NAME NOT STARTS WITH 'C'");
		persons.stream().
		filter(p -> !p.getFirstName().startsWith("C")).
		forEach(p -> System.out.println(p.getFirstName()));
		
		System.out.println("PERSONS COUNT FIRST NAME STARTS WITH 'C'");
		long count = persons.parallelStream().
		filter(p -> p.getFirstName().startsWith("C")).
		count();
		System.out.println(count);
	}

}
