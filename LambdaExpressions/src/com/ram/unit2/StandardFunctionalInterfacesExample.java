package com.ram.unit2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.ram.unit1.Person;

public class StandardFunctionalInterfacesExample {

	public static void main(String[] args) {

		List<Person> persons = Arrays.asList(
				new Person("CHARAN", "DODLA", 20),
				new Person("LOVELY", "CARROL", 25), 
				new Person("THOMAS", "CARLYLE", 30), 
				new Person("CHARLOTTE", "BRONTE", 35),
				new Person("MATHEW", "ARNOLD", 40));

		// Step1: Sort List By Last Name
		Collections.sort(persons, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		// Step2: Print all elements in the list
		System.out.println("ALL PERSONS IN THE LIST");
		performConditionally(persons, p -> true, p -> System.out.println(p));

		// Step3: print all people that have first name beginning with 'C'
		System.out.println("\nPERSONS FIRST NAME START WITH 'C'");
		performConditionally(persons, p -> p.getFirstName().startsWith("C"), p -> System.out.println(p));

		// Step4: print all people that have last name beginning with 'C'
		System.out.println("\nPERSONS LAST NAME START WITH 'C'");
		performConditionally(persons, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));
		
		// Step5: print all people that have last name beginning with 'C'
		System.out.println("\nPERSONS LAST NAME START WITH 'C'");
		performConditionally(persons, p -> p.getLastName().startsWith("C"), p -> System.out.println(p.getLastName()));
	}

	private static void performConditionally(List<Person> persons, Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person person : persons) {
			if (predicate.test(person))
				consumer.accept(person);
		}
	}
}