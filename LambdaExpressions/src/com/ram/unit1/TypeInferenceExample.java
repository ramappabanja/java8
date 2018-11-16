package com.ram.unit1;


public class TypeInferenceExample {

	public static void main(String[] args) {

		StringLengthLambda myLambda = s -> s.length();
		System.out.println("LENGTH OF THE GIVEN STRING : "+myLambda.getLength("Hello Lambda"));
		//OR We can still simplify this
		printLambda(s->s.length());
	}
	
	static void printLambda(StringLengthLambda l){
		System.out.println("LENGTH OF THE GIVEN STRING : "+l.getLength("Hello Lambda"));
	}
	@FunctionalInterface
	interface StringLengthLambda{
		int getLength(String s);
	}

}
