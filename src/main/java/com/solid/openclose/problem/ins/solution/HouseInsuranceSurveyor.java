package com.solid.openclose.problem.ins.solution;

public class HouseInsuranceSurveyor implements InsuranceSurveyor{

	@Override
	public boolean isValidClaim(){
        System.out.println("HouseInsuranceSurveyor: Validating house insurance claim...");
        /*Logic to validate health insurance claims*/
        return true;
    }
}
