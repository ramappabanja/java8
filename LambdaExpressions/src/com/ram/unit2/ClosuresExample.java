package com.ram.unit2;

public class ClosuresExample {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		System.out.println("-------");
		doProcess(a, i -> System.out.println(i+b));
		System.out.println("========");
	}

	public static void doProcess(int i, Process p){
		System.out.println(">>>>>>>>>>>");
		p.process(i);
	}
}

interface Process{
	void process(int i);
}
