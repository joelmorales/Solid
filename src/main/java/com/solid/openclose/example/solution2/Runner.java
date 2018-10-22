package com.solid.openclose.example.solution2;


public class Runner {

	public static void main(String[] args) {
		
		BuildReport report = new BuildReport(new ConversionRatesReport());		
		
		System.out.println(report.generate());	
		report = new BuildReport(new OrderPerDayReport());	
		System.out.println(report.generate());
		
	}

}
