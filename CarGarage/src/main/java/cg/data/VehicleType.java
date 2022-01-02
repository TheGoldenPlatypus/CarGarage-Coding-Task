package cg.data;

import java.util.Random;

public enum VehicleType {
	REGULAR,ELECTRIC;
	
	public static VehicleType getRandomType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
