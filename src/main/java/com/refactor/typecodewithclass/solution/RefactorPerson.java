package com.refactor.typecodewithclass.solution;

public class RefactorPerson {

	/*public static final int O = BloodGroup.O.getCode();
	public static final int A = BloodGroup.A.getCode();
	public static final int B = BloodGroup.B.getCode();
	public static final int BC = BloodGroup.AB.getCode();*/

	private BloodGroup bloodGroup;

	public RefactorPerson(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	@Override
	public String toString() {
		return "RefactorPerson [bloodGroup=" + bloodGroup.getCode() + "]";
	}

	
	
}
