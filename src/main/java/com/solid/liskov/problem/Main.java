package com.solid.liskov.problem;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<TrasportationDevice> transportations = new ArrayList<TrasportationDevice>();
		transportations.add(new Car("Car"));
		transportations.add(new Bicycle("Bicycle"));
		startEngines(transportations);
	}

	static void startEngines(List<TrasportationDevice> transportations){
		for(TrasportationDevice t : transportations ){			
			System.out.println(t.getName());
			t.startEngine();
		}
	}
	
	
}
