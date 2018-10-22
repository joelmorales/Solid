package com.refactor.typecodewithstatestrategy.solution;

public class Engineer extends EmployeeType {
	@Override
	int getTypeCode() {		
		return EmployeeType.ENGINEER;
	}
}
