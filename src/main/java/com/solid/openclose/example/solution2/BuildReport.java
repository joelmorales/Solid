package com.solid.openclose.example.solution2;

public class BuildReport {

	private Report report;
	
	BuildReport ( Report report){
		this.report = report;
	}
	
	public String generate() {
		return report.generate();
	}

}
