package com.solid.openclose.problem.ins;

public class ClaimApprovalManager {

	public void processHealthClaim(HealthInsuranceSurveyor surveyor) {
		if (surveyor.isValidClaim()) {
			System.out
					.println("ClaimApprovalManager: Valid claim. Currently processing claim for approval....");
		}
	}

	public void processVehicleClaim(VehicleInsuranceSurveyor surveyor) {
		if (surveyor.isValidClaim()) {
			System.out
					.println("ClaimApprovalManager: Valid claim. Currently processing claim for approval....");
		}
	}

	public void processHouseClaim(HouseInsuranceSurveyor surveyor) {
		if (surveyor.isValidClaim()) {
			System.out
					.println("ClaimApprovalManager: Valid claim. Currently processing claim for approval....");
		}
	}

}
