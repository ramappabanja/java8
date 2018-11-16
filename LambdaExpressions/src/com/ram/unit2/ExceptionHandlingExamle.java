package com.ram.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingExamle {

	public static void main(String[] args) {

		int[] someNumbers = {1,2,3,4};
		int key = 0;
		process(someNumbers, key, wrapperLambda((i, k)-> System.out.println(i/k)));
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		for(int i: someNumbers){
			consumer.accept(i, key);
		}
	}
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer){
		return (i, k) -> {
			try {
				consumer.accept(i, k);
			} catch (ArithmeticException e) {
				System.out.println("Exception Caught in the wrapperLambda");
			}
		};
	}

}
