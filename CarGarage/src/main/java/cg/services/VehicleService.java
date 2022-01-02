package cg.services;

import java.util.List;

import cg.boundaries.VehicleBoundary;

public interface VehicleService {
	
	// Add a new vehicle to the vehicles collection 
	public VehicleBoundary createVehicle(VehicleBoundary vehicle);
		
	//Retrieve a single vehicle by license numberE
	public VehicleBoundary getVehicleByLicenseNumber(long licenseNumber);
	
	//Retrieve all of the available vehicles
	public List<VehicleBoundary> getAllVehicles();

	
	// Inflate  all vehicles tires to maximum pressure 
	public void inflateAllVehiclesToMaxPressure();
	
	// Inflate a single vehicle  tires to maximum pressure 
	public VehicleBoundary inflateVehicleToMaxPressure(long licenseNumber);

	// Add energy (Refuel a vehicle or recharges) by license number
	public VehicleBoundary addEnergyToVehicleByLicenseNumber(long licenseNumber);

}
