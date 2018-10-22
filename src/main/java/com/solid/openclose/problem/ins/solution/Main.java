package com.solid.openclose.problem.ins.solution;

public class Main {

	public static void main(String[] args) {
		ClaimApprovalManager approval = new ClaimApprovalManager();
		
		InsuranceSurveyor healthSurveyor = new HealthInsuranceSurveyor();
		approval.processClaim(healthSurveyor);
		
		InsuranceSurveyor vehicleSurveyor=new VehicleInsuranceSurveyor();
		approval.processClaim(vehicleSurveyor);
		
		InsuranceSurveyor houseSurveyor = new HouseInsuranceSurveyor();
		approval.processClaim(houseSurveyor);
	}

}
