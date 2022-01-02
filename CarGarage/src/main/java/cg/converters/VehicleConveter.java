package cg.converters;

import org.springframework.stereotype.Component;

import cg.boundaries.VehicleBoundary;
import cg.data.VehicleEnergySource;
import cg.data.VehicleType;
import cg.entites.VehicleEntity;

@Component
public class VehicleConveter {

	public VehicleEntity convertToEntity(VehicleBoundary boundary) {
		VehicleEntity entity = new VehicleEntity();
		entity.setModelName("XXXX");
		entity.setLicenseNumber(11111111);
		entity.setNumOfWheels(2);
		entity.setEnergySource(VehicleEnergySource.FUEL);
		entity.setAvailableEnergy(0);
		entity.setAvailableTirePressure(0);
		entity.setMaxTirePressure(200);
		entity.setType(VehicleType.REGULAR);
		
		if(boundary.getModelName()!=null)
			entity.setModelName(boundary.getModelName());
		
		if(boundary.getLicenseNumber() != 0L)
			entity.setLicenseNumber(boundary.getLicenseNumber());
		
		if(boundary.getNumOfWheels() != 0)
			entity.setNumOfWheels(boundary.getNumOfWheels());
		
		if(boundary.getEnergySource() != null)
			entity.setEnergySource(boundary.getEnergySource());
		
		if(boundary.getAvailableEnergy() != 0)
			entity.setAvailableEnergy(boundary.getAvailableEnergy());
		
		if(boundary.getAvailableTirePressure() != 0)
			entity.setAvailableTirePressure(boundary.getAvailableTirePressure());
		
		if(boundary.getMaxTirePressure() != 0)
			entity.setMaxTirePressure(boundary.getMaxTirePressure());
		
		if(boundary.getType() != null)
			entity.setType(boundary.getType());
		
		return entity;
		}
	
	
	public VehicleBoundary convertToBoundary(VehicleEntity entity) {
		VehicleBoundary boundary = new VehicleBoundary();
		boundary.setModelName(entity.getModelName());
		boundary.setLicenseNumber(entity.getLicenseNumber());
		boundary.setNumOfWheels(entity.getNumOfWheels());
		boundary.setEnergySource(entity.getEnergySource());
		boundary.setAvailableEnergy(entity.getAvailableEnergy());
		boundary.setAvailableTirePressure(entity.getAvailableTirePressure());
		boundary.setMaxTirePressure(entity.getMaxTirePressure());
		boundary.setType(entity.getType());
		
		return boundary;
		
	}
}
