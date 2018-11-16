package com.ram.unit3;

import java.util.Arrays;
import java.util.List;

import com.ram.unit1.Person;

public class CollectionIterationExample {

	public static void main(String[] args) {

		List<Person> persons = Arrays.asList(
				new Person("CHARAN", "DODLA", 20),
				new Person("LOVELY", "CARROL", 25), 
				new Person("THOMAS", "CARLYLE", 30), 
				new Person("CHARLOTTE", "BRONTE", 35),
				new Person("MATHEW", "ARNOLD", 40));
		
		System.out.println("USING FOR IN LOOP");
		for(Person person: persons){
			System.out.println(person);
		}
		
		System.out.println("\nUSING FOR IN LOOP");
		persons.forEach(p->System.out.println(p));
		
		System.out.println("\nUSING FOR EACH AND METHOD REFERENCE");
		persons.forEach(System.out::print);
	}

}
