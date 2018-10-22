package com.refactor.replaceConditionalwithPoly.solution;

public class Salesman extends EmployeeType  {
	
	public int payAmount(Employee emp){
		return emp.getMonthlysalary() + emp.getComission();
	}
	
	@Override
	int getTypeCode() {
		return EmployeeType.SALESMAN;
	}
}
