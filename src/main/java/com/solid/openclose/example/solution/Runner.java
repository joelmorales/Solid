package com.solid.openclose.example.solution;

public class Runner {

	public static void main(String[] args) {
		
		Report report = new ConversionRatesReport();		
		System.out.println(report.generate());
		
		report = new OrderPerDayReport();
		System.out.println(report.generate());
	}

}
