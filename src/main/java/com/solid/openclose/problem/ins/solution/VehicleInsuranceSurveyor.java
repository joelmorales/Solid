package com.solid.openclose.problem.ins.solution;

public class VehicleInsuranceSurveyor implements InsuranceSurveyor {

	@Override
	public boolean isValidClaim() {
		System.out.println("VehicleInsuranceSurveyor: Validating vehicle insurance claim...");
        /*Logic to validate health insurance claims*/
		return true;
	}

}
