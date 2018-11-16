package com.ram.unit1;


public class RunnableClass {

	public static void main(String[] args) {

		Thread myThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("PRINTED INSIDE RUNNABLE");
			}
		});
		myThread.run();
		
		Thread lambdaThread = new Thread(()->System.out.println("PRINTED INSIDE LAMBDA RUNNABLE"));
		lambdaThread.run();
	}

}
