package com.solid.openclose.example;

public class Report {
		
	public String generate(Type type){
		switch (type){
		case ORDERS_PER_DAY:
			return "Orders per Day";
		case CONVERSION_RATES:
			return "Conversion Rates";
		default:
			return "Default report";			
		}
	}
		
	
}
