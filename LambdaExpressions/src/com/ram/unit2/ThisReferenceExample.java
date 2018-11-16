package com.ram.unit2;

public class ThisReferenceExample {

	public static void main(String[] args) {
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		thisReferenceExample.doProcess(10, i -> {
			System.out.println("VALUE IS : "+i);
//			System.out.println(this); This will not work
		});
		thisReferenceExample.execute();
	}

	public void doProcess(int i, Process p){
		p.process(i);
	}
	
	public void execute(){
		doProcess(20, i->{
			System.out.println("VALUE IS : "+i);
			System.out.println(this);
		});
	}
}
