package com.refactor.typecodewithsubclasses.solution;

public class MainTest {

	public static void main(String[] args) {
		Employee employee = Employee.create(Employee.ENGINEER);
		System.out.println(employee);
		
		Employee employee2 = Employee.create(Employee.SALESMAN);
		System.out.println(employee2);		
		
	}

}
