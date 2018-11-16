package com.ram.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExerciseSolutionJava7 {

	public static void main(String[] args) {

		List<Person> persons = Arrays.asList(
				new Person("CHARAN", "DODLA", 20),
				new Person("LOVELY", "CARROL", 25), 
				new Person("THOMAS", "CARLYLE", 30), 
				new Person("CHARLOTTE", "BRONTE", 35),
				new Person("MATHEW", "ARNOLD", 40));

		// Step1: Sort List By Last Name
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});

		// Step2: Print all elements in the list
		System.out.println("ALL PERSONS IN THE LIST");
		printAll(persons);

		// Step3: print all people that have first name beginning with 'C'
		System.out.println("\nPERSONS FIRST NAME START WITH 'C'");
		printConditionally(persons, new Condition() {
			@Override
			public boolean test(Person person) {
				return person.getFirstName().startsWith("C");
			}
		});

		// Step4: print all people that have last name beginning with 'C'
		System.out.println("\nPERSONS LAST NAME START WITH 'C'");
		printConditionally(persons, new Condition() {
			@Override
			public boolean test(Person person) {
				return person.getLastName().startsWith("C");
			}
		});

	}

	private static void printConditionally(List<Person> persons,
			Condition condition) {
		for (Person person : persons) {
			if (condition.test(person))
				System.out.println(person);
		}
	}

	private static void printAll(List<Person> persons) {
		for (Person person : persons) {
			System.out.println(person);
		}
	}
}

interface Condition {
	boolean test(Person person);
}