package com.solid.liskov.solution;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<DeviceWithEngines> transportations = new ArrayList<DeviceWithEngines>();
		transportations.add(new Car());
		transportations.add(new Plane());
		startEngines(transportations);
	}

	static void startEngines(List<DeviceWithEngines> transportations){
		for(DeviceWithEngines t : transportations ){
			t.startEngine();			
		}
	}
	
	
}
