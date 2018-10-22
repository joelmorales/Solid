package com.refactor.typecodewithclass.solution;

import com.refactor.typecodewithclass.solution.Person;

public class MainTest {

public static void main(String[] args) {
		
		Person person = new Person(1);
		System.out.println("Person:"+person.toString());
		
		RefactorPerson rPerson = new RefactorPerson(BloodGroup.AB);
		System.out.println("Refactor Person:"+rPerson.toString());
		
		rPerson.setBloodGroup(BloodGroup.A);
	}

	
}
