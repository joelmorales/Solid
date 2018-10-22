package com.solid.dependencyinversion.example.solution;

public class ElectricPowerSwitch implements Switch {
	public Switchable lightBulb;
	private boolean on;

	public ElectricPowerSwitch(Switchable lightBulb) {
		this.lightBulb = lightBulb;
		this.on = false;
	}

	@Override
	public boolean isOn() {
		return this.on;
	}
	
	@Override
	public void press() {
		boolean checkOn = isOn();
		if (checkOn) {
			lightBulb.turnOff();
			this.on = false;
		} else {
			lightBulb.turnOn();
			this.on = true;
		}
	}

}
