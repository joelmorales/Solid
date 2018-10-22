package com.solid.liskov.solution;

public class Car extends DeviceWithEngines {

	@Override
	void startEngine(){
		System.out.println("Start Car Engine");
	}
}
