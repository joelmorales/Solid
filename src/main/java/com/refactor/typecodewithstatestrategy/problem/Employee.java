package com.refactor.typecodewithstatestrategy.problem;

public class Employee {

	static final int ENGINEER = 0;
	static final int SALESMAN = 1;
	static final int MANAGER = 2;
	
	private int type;
	private int monthlysalary;
	private int comission=0;
	private int bonus=0;
	
	public Employee(int type){
		this.type = type;
	}
	
	public int payAmount(){
		switch(type){
		case ENGINEER:
			return monthlysalary;
		case SALESMAN:	
			return monthlysalary + comission;
		case MANAGER:
			return monthlysalary + bonus;
		default:
			throw new RuntimeException("Incorrect Employee");
		}	
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

	public int getType(){
		return type;
	}

	@Override
	public String toString() {
		return "Employee [type=" + type + ", monthlysalary=" + monthlysalary
				+ ", comission=" + comission + ", bonus=" + bonus + "]";
	}

	
}
