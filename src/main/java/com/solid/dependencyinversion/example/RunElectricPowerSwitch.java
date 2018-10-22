package com.solid.dependencyinversion.example;

public class RunElectricPowerSwitch {

	public static void main(String[] args) {
		
		LightBulb lightBulb = new LightBulb();
		ElectricPowerSwitch powerswitch = new ElectricPowerSwitch(lightBulb);
		
		powerswitch.press();
		//System.out.println("is On:"+powerswitch.isOn());
		powerswitch.press();
		//System.out.println("is On:"+powerswitch.isOn());
		
	}
	
}
