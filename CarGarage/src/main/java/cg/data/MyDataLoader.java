package cg.data;

import java.util.Random;

import cg.entites.Motorcycle;
import cg.entites.Truck;
import cg.entites.VehicleEntity;

public class MyDataLoader {
	
	private static long LICENSE_NR= 1111111;
	private final int MAX_TIRE_PRESSURE= 200;
	
	
	public void loadData(VehicleEntity v) {
		v.setLicenseNumber(LICENSE_NR);
		v.setModelName(getRandomModelName());
    	v.setAvailableEnergy(getRandomAvailableEnergyOrTirePressure(true));
    	v.setAvailableTirePressure(getRandomAvailableEnergyOrTirePressure(false));
    	v.setMaxTirePressure(MAX_TIRE_PRESSURE);
    	if(v instanceof Truck) {
    		v.setEnergySource(VehicleEnergySource.FUEL);
    		v.setType(VehicleType.REGULAR);
    	}
    	else {
    		v.setType(getRandomType());
    		if(v.getType()==VehicleType.REGULAR)
    			v.setEnergySource(VehicleEnergySource.FUEL);
    		else {
    			v.setEnergySource(VehicleEnergySource.BATTERY);
    		}
    	}
    	v.setNumOfWheels(getCorrectNumOfWheels(v));
    		
    	LICENSE_NR++;
		
	}
	
	public String getRandomModelName() {
		 return VehicleModelName.getRandomModelName().name();
	}
	
	public int getRandomAvailableEnergyOrTirePressure(boolean flag) {
		Random r = new Random();
		int low = 0;
		int high;
		if(flag == true)
			high = 100;
		else
			high = 200;
		return r.nextInt(high-low) + low;
	}
	
	public VehicleType getRandomType() {
		 return VehicleType.getRandomType();
	}
	
	public int getCorrectNumOfWheels(VehicleEntity v) {
		if(v instanceof Truck)
			return 16;
		if(v instanceof Motorcycle)
			return 2;
		
		return 4;
	}
}
