package com.ram.unit3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.ram.unit1.Person;

public class MethodReferenceExample2 {

	public static void main(String[] args) {

		List<Person> persons = Arrays.asList(
				new Person("CHARAN", "DODLA", 20),
				new Person("LOVELY", "CARROL", 25), 
				new Person("THOMAS", "CARLYLE", 30), 
				new Person("CHARLOTTE", "BRONTE", 35),
				new Person("MATHEW", "ARNOLD", 40));

		System.out.println("ALL PERSONS IN THE LIST");
		performConditionally(persons, p -> true, System.out::println);//p -> method()

	}

	private static void performConditionally(List<Person> persons, Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person person : persons) {
			if (predicate.test(person))
				consumer.accept(person);
		}
	}
}