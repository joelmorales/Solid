package com.testing;

public class CheckClosing {

	public static void main(String[] args) {
		String test = "TED#$(WSERD";
		System.out.println("result: "+isNegative(test));
		System.out.println("result: "+isNegativeFixed(test));
	}

	public static boolean isNegative(String field) {
		try {
			boolean bracketsFound = false;
			for (int ii = 0; ii < field.length(); ii++) {
				if (field.charAt(ii) == '(') {
					bracketsFound = true;
				} else if (field.charAt(ii) == '(') {
					bracketsFound = true;
				}
			}
			if (bracketsFound)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isNegativeFixed(String field) {
		try {
			for (int ii = 0; ii < field.length(); ii++) {
				if (IsBracketFounded(field.charAt(ii)))
					return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	private static boolean IsBracketFounded(char c) {
		if (c == '(')
			return true;
		return false;
	}

}
