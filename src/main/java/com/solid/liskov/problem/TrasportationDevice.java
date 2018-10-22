package com.solid.liskov.problem;

public class TrasportationDevice {
	String name;
	double speed;
	Engine engine;
		
	public TrasportationDevice(String name){
		this.name = name;
	}
	
	void startEngine(){	
		System.out.println("Start Engine");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}	
	
}
