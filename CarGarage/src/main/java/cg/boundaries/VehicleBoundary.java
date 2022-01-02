package cg.boundaries;

import cg.data.VehicleEnergySource;
import cg.data.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehicleBoundary {
	private String modelName;
	private long licenseNumber;
	private int numOfWheels;
	private VehicleEnergySource energySource;
	private int availableEnergy;
	private int maxTirePressure;
	private VehicleType type;
	private int availableTirePressure;
	
	

}
