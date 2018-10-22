package com.refactor.replaceConditionalwithPoly.solution;

public class Employee {

	private EmployeeType type;
	private int monthlysalary;
	private int comission = 0;
	private int bonus = 0;
	
	public int getType() {
		return type.getTypeCode();
	}
	
	int payAmount(){
		return type.payAmount(this);
	}

	public Employee(EmployeeType type) {
		this.type = type;
	}
	
	public int getMonthlysalary() {
		return monthlysalary;
	}

	public void setMonthlysalary(int monthlysalary) {
		this.monthlysalary = monthlysalary;
	}

	public int getComission() {
		return comission;
	}

	public void setComission(int comission) {
		this.comission = comission;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "Employee [type=" + type + ", monthlysalary=" + monthlysalary
				+ ", comission=" + comission + ", bonus=" + bonus + "]";
	}

}
