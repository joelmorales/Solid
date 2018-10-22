package com.refactor.typecodewithstatestrategy.solution;

public class MainTest {

	public static void main(String[] args) throws IllegalAccessException {
		
		Employee employee = new Employee(new Engineer());
		//Employee employee2 = new Employee(EmployeeType.newType(EmployeeType.ENGINEER));
		
		employee.setMonthlysalary(2000);
		System.out.println("Employee:"+employee);
		System.out.println("Employee payAmount:"+employee.payAmount());
		
	}

}
