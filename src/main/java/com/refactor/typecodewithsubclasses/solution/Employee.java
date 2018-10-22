package com.refactor.typecodewithsubclasses.solution;


public abstract class Employee {

	static final int ENGINEER = 0;
	static final int SALESMAN = 1;
	static final int MANAGER = 2;
	
	public Employee(){		
	}
	
	public static Employee create(int type){	
		switch(type){
		case ENGINEER:
			return new Engineer();
		case SALESMAN:
			return  new Salesman();
		case MANAGER:
			return new Manager();
		default:
			throw new IllegalArgumentException();
		}		
	}	

	abstract int getType();

	@Override
	public String toString() {
		return "Employee [getType()=" + getType() + "]";
	}
	
}
