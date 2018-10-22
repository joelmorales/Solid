package com.solid.openclose.example;

public class Runner {

	public static void main(String[] args) {
		Report report = new Report();		
		
		System.out.println(report.generate(Type.CONVERSION_RATES));
		
		System.out.println(report.generate(Type.ORDERS_PER_DAY));
		
		//Add another behavior
		
	}

}
