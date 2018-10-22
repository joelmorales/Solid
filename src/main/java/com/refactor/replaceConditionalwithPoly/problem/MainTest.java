package com.refactor.replaceConditionalwithPoly.problem;

public class MainTest {

	public static void main(String[] args) {
		
		Employee employee = new Employee(new Engineer());
		
		employee.setMonthlysalary(2000);
		System.out.println("Employee:"+employee);
		System.out.println("Employee payAmount:"+employee.payAmount());
		
	}

}
