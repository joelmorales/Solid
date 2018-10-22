package com.solid.liskov.problem;

public class Car extends TrasportationDevice {

	public Car(String name) {
		super(name);
	}

	@Override
	void startEngine(){		
		System.out.println("Start Car Engine");
	}
	
}
