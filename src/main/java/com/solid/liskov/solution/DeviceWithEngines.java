package com.solid.liskov.solution;

import com.solid.liskov.problem.Engine;

public class DeviceWithEngines extends TrasportationDevice {

	Engine engine;
	
	void startEngine(){		
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
}
