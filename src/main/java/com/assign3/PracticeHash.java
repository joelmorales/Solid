package com.assign3;

import java.util.Stack;

public class PracticeHash {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		stack.add("primero");
		stack.add("Segundo");
		stack.add("Tercero");
		
		//System.out.println(stack.pop());
		Object[] toPrint = stack.toArray();
		for(int i=stack.size()-1; i>= 0; i--){
			System.out.println(toPrint[i]);
		}
	}

}
