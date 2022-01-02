package cg.data;

import java.util.Random;

public enum VehicleModelName {
	BMW,AUDI,WOLKSWAGEN,CADILAC,FIAT,FERARI,FORD,HONDA,KIA,HYUNDAI,MAZDA,MITSUBISHI,OPEL,PEUGEOT,PORSCHE,SKODA,RENAULT,SUBARU;
	
	public static VehicleModelName getRandomModelName() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
