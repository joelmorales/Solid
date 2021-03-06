package com.refactor.typecodewithstatestrategy.solution;

public abstract class EmployeeType {

	static final int ENGINEER = 0;
	static final int SALESMAN = 1;
	static final int MANAGER = 2;
	
	/*static EmployeeType newType(int code) throws IllegalAccessException {
		switch (code) {
		case ENGINEER:
			return new Engineer();			
		case SALESMAN:
			return new Salesman();			
		case MANAGER:
			return new Manager();			
		default:
			throw new IllegalAccessException("Incorrect Employee");
		}
	}
	*/
	abstract int getTypeCode();	
	
}
