package com.refactor.typecodewithsubclasses.problem;

public class Employee {

	static final int ENGINEER = 0;
	static final int SALESMAN = 1;
	static final int MANAGER = 2;
	
	private int type;
	
	public Employee(int type){
		this.type = type;
	}
	
	public int getType(){
		return type;
	}

	@Override
	public String toString() {
		return "Employee [type=" + type + "]";
	}
	
	
}
