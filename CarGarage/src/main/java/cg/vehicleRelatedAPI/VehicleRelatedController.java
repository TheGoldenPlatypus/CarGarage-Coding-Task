package cg.vehicleRelatedAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cg.boundaries.VehicleBoundary;
import cg.services.VehicleService;

@RestController
public class VehicleRelatedController {
	
	private VehicleService vehicleService;

	@Autowired
	public VehicleRelatedController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}
	
	
	@RequestMapping(path = "/iob/vehicles",
					method = RequestMethod.POST, 
					produces = MediaType.APPLICATION_JSON_VALUE, 
					consumes = MediaType.APPLICATION_JSON_VALUE)
	public VehicleBoundary createNewVehicle(@RequestBody VehicleBoundary vehicle) {
		return vehicleService.createVehicle(vehicle);
	}
	
	

	
	@RequestMapping(path = "/iob/vehicles/{licenseNumber}", 
					method = RequestMethod.GET, 
					produces = MediaType.APPLICATION_JSON_VALUE)
	public VehicleBoundary retrieveVehicleByLicenseNumber(@PathVariable("licenseNumber") long licenseNumber) {
		return vehicleService.getVehicleByLicenseNumber(licenseNumber);
	}
	
	@RequestMapping(path = "/iob/vehicles", 
					method = RequestMethod.GET, 
					produces = MediaType.APPLICATION_JSON_VALUE)
	public VehicleBoundary[] retrieveAllVehicles() {
		return vehicleService.getAllVehicles().toArray(new VehicleBoundary[0]);
	
	
	}
	
	@RequestMapping(path = "/iob/vehicles/inflateTires",
        			method = RequestMethod.PUT,
        			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void inflateAllVehicleToMaxPressure() {
			vehicleService.inflateAllVehiclesToMaxPressure();
	}
	
	
	@RequestMapping(path = "/iob/vehicles/{licenseNumber}/inflateTires",
					method = RequestMethod.PUT,
					consumes = MediaType.APPLICATION_JSON_VALUE)
	public void inflateVehicleToMaxPressure(@PathVariable("licenseNumber") long licenseNumber) {
		vehicleService.inflateVehicleToMaxPressure(licenseNumber);
}
	
	
	@RequestMapping(path = "/iob/vehicles/{licenseNumber}/addEnergy",
					method = RequestMethod.PUT,
					consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addEnergyToVehicle(@PathVariable("licenseNumber") long licenseNumber) {
			vehicleService.addEnergyToVehicleByLicenseNumber(licenseNumber);
	}


}
