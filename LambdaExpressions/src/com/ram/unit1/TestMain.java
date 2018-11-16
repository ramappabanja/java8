package com.ram.unit1;


public class TestMain {

public static void main(String[] args) {
		
		MyGreeting greetingFunction  = () -> System.out.println("Hello World");
		greetingFunction.wish();
		
		DoubleNumeric doubleNumericFunction = b -> b*2;
		System.out.println("DOUBLE OF 5 is : "+doubleNumericFunction.doubleNum(5));
		
		AddTwoNums addFunction = (a,b) -> a+b;
		System.out.println("ADDITION OF 5 and 4 is : "+addFunction.addNums(5, 4));
		
		SafeDevide safeDevideFunction = (a, b) -> b==0?0:a/b;
		System.out.println("SAFE DEVIDE OF 5/3 is : "+safeDevideFunction.safeDevideFunction(5, 3));
	}
}

interface MyGreeting{
	void wish();
}

interface DoubleNumeric{
	int doubleNum(int a);
}

interface AddTwoNums{
	int addNums(int a, int b);
}

interface SafeDevide{
	int safeDevideFunction(int a, int b);
}
