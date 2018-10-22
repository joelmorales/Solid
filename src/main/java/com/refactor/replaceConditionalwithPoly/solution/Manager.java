package com.refactor.replaceConditionalwithPoly.solution;

public class Manager extends EmployeeType{
	
	public int payAmount(Employee emp){
		return emp.getMonthlysalary() +  emp.getBonus();
	}
	
	@Override
	int getTypeCode() {
		return EmployeeType.MANAGER;
	}
}
