package cg.entites;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import cg.data.VehicleEnergySource;
import cg.data.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/* 
 * 
 * VEHICLES table:
 * VEHICLE_LICENSE_NUMBER   |	VEHICLE_MODEL_NAME	| VEHICLE_NUMBER_OF_WHEELS |  VEHICLE_ENERGY_SOURCE 	| 	VEHICLE_AVAILBALE_ENERGY  |	VEHICLE_MAX_TIRE_PRESSURE	|  VEHICLE_TYPE			|  VEHICLE_TIRE_PRESSURE	|
 * BIGINT <PK>  		 	|	VARCHAR(255) 		| INT					   |  VARCHAR(255)				|	INT		  				  |	INT							|  VARCHAR(255)			|	INT						|
 * 
 * 
 */
@Entity
@Table(name = "VEHICLES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public  class VehicleEntity {
	
	
	@Id
	@Column(name="VEHICLE_LICENSE_NUMBER")
	private long licenseNumber;

	@Column(name="VEHICLE_MODEL_NAME")
	private String modelName;
	
	@Column(name="VEHICLE_NUMBER_OF_WHEELS")
	private int numOfWheels;
	
	@Column(name="VEHICLE_ENERGY_SOURCE")
	@Enumerated(EnumType.STRING) 
	private VehicleEnergySource energySource;
	
	@Column(name="VEHICLE_AVAILBALE_ENERGY")
	private int availableEnergy;
	
	@Column(name="VEHICLE_TIRE_PRESSURE")
	private int availableTirePressure;
	
	@Column(name="VEHICLE_MAX_TIRE_PRESSURE")
	private int maxTirePressure;
	
	@Column(name="VEHICLE_TYPE")
	@Enumerated(EnumType.STRING)
	private VehicleType type;

	
}
