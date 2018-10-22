package com.refactor.typecodewithclass.solution;

public class BloodGroup {

	public static final BloodGroup O = new BloodGroup(0);
	public static final BloodGroup A = new BloodGroup(1);
	public static final BloodGroup B = new BloodGroup(2);	
	public static final BloodGroup AB = new BloodGroup(3);
	//public static final BloodGroup[] values = { O, A, B, AB };

	private final int code;

	private BloodGroup(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	/*public static BloodGroup code(int arg) {
		return values[arg];
	}*/

}
