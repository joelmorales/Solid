package com.solid.dependencyinversion.example.solution;

public class RunElectricPowerSwitch {

	public static void main(String[] args) {
		
		Switchable lightBulb = new LightBulb();
		Switch powerswitch = new ElectricPowerSwitch(lightBulb);
		
		powerswitch.press();		
		powerswitch.press();
		
		Switchable fan = new Fan();
		powerswitch = new ElectricPowerSwitch(fan);
		powerswitch.press();		
		powerswitch.press();
		
	}
	
}
