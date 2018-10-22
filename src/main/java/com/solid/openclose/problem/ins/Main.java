package com.solid.openclose.problem.ins;

public class Main {

	public static void main(String[] args) {
		ClaimApprovalManager approval = new ClaimApprovalManager();
		
		HealthInsuranceSurveyor healthSurveyor = new HealthInsuranceSurveyor();
		approval.processHealthClaim(healthSurveyor);
		
		VehicleInsuranceSurveyor vehicleSurveyor=new VehicleInsuranceSurveyor();
		approval.processVehicleClaim(vehicleSurveyor);
		
		HouseInsuranceSurveyor houseSurveyor = new HouseInsuranceSurveyor();
		approval.processHouseClaim(houseSurveyor);
	}

}
