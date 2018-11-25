package com.ram.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Unit1ExerciseSolutionJava8 {

	public static void main(String[] args) {

		List<Person> persons = Arrays.asList(
				new Person("CHARAN", "DODLA", 50),
				new Person("LOVELY", "CARROL", 18), 
				new Person("THOMAS", "CARLYLE", 30), 
				new Person("CHARLOTTE", "BRONTE", 35),
				new Person("MATHEW", "ARNOLD", 20));

		// Step1: Sort List By Last Name
		Collections.sort(persons, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		// Step2: Print all elements in the list
		System.out.println("ALL PERSONS IN THE LIST");
		printConditionally(persons, p -> true);

		// Step3: print all people that have first name beginning with 'C'
		System.out.println("\nPERSONS FIRST NAME START WITH 'C'");
		printConditionally(persons, p -> p.getFirstName().startsWith("C"));

		// Step4: print all people that have last name beginning with 'C'
		System.out.println("\nPERSONS LAST NAME START WITH 'C'");
		printConditionally(persons, p -> p.getLastName().startsWith("C"));
		
		// Step5: print all people in age sorting order
		persons.sort((p1,p2)->p1.getAge().compareTo(p2.getAge()));
		System.out.println("PERSONS NAMES WITH AGE SORTING");
		persons.forEach(System.out::println);
	}

	private static void printConditionally(List<Person> persons, Condition condition) {
		for (Person person : persons) {
			if (condition.test(person))
				System.out.println(person);
		}
	}
}