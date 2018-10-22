package com.refactor.replaceConditionalwithPoly.solution;

public class Engineer extends EmployeeType {	
	@Override
	public int payAmount(Employee emp){
		return emp.getMonthlysalary();
	}
	
	@Override
	int getTypeCode() {		
		return EmployeeType.ENGINEER;
	}
}
