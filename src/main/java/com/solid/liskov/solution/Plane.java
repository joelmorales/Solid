package com.solid.liskov.solution;

public class Plane extends DeviceWithEngines {

	@Override
	void startEngine(){
		System.out.println("Start Plane Engine");
	}
	
}
