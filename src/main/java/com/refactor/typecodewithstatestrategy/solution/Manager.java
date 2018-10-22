package com.refactor.typecodewithstatestrategy.solution;

public class Manager extends EmployeeType{
	@Override
	int getTypeCode() {
		return EmployeeType.MANAGER;
	}
}
