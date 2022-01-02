package cg.servicesJPA;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cg.boundaries.VehicleBoundary;
import cg.converters.CarConveter;
import cg.converters.MotorcycleConverter;
import cg.converters.TruckConverter;
import cg.converters.VehicleConveter;
import cg.dao.VehicleDao;
import cg.data.VehicleEnergySource;
import cg.data.VehicleType;
import cg.entites.Car;
import cg.entites.Motorcycle;
import cg.entites.Truck;
import cg.entites.VehicleEntity;
import cg.exceptions.BadRequestException;
import cg.services.VehicleService;

@Service
public class VehicleServiceJPA implements VehicleService {

	private VehicleDao vehicleDao;
	private VehicleConveter vehicleConveter;
	private CarConveter carConveter;
	private MotorcycleConverter motorcycleConverter;
	private TruckConverter truckConverter;
	
	
	@Autowired
	public VehicleServiceJPA(VehicleDao vehicleDao) {
		super();
		this.vehicleDao = vehicleDao;
	}
	

	@Autowired
	public void setEntityConverter(VehicleConveter vehicleConveter,CarConveter carConveter,MotorcycleConverter motorcycleConverter
								  ,TruckConverter truckConverter) {
		this.vehicleConveter = vehicleConveter;
		this.carConveter = carConveter;
		this.motorcycleConverter = motorcycleConverter;
		this.truckConverter = truckConverter;
	}


	
	@Override
	@Transactional
	public VehicleBoundary createVehicle(VehicleBoundary vehicle) {
		if(vehicle.getLicenseNumber() == 0L)
			throw new BadRequestException("Could not add vehicle without license number");
		
		Optional<VehicleEntity> optionalVehicle = this.vehicleDao.findById(vehicle.getLicenseNumber());
		if(optionalVehicle.isPresent())
			throw new BadRequestException("Vehicle with the requsted license number already exists");
	
		if((vehicle.getType()==VehicleType.REGULAR && vehicle.getEnergySource()==VehicleEnergySource.BATTERY) ||
				(vehicle.getType()==VehicleType.ELECTRIC && vehicle.getEnergySource()==VehicleEnergySource.FUEL))
			throw new BadRequestException("Please note: 1. Regular vehicle can have only FUEL as an energy source /n "
													 + "2. Electric vehicle can have only BATTERY as an energy source ");
		
		if(vehicle.getNumOfWheels() == 4){
			Car entity = this.carConveter.convertToEntity(vehicle);
			entity = this.vehicleDao.save(entity);
			return this.carConveter.convertToBoundary(entity);
		}
		
		if(vehicle.getNumOfWheels() == 2){
			Motorcycle entity = this.motorcycleConverter.convertToEntity(vehicle);
			entity = this.vehicleDao.save(entity);
			return this.motorcycleConverter.convertToBoundary(entity);
		}
		
		
		if(vehicle.getNumOfWheels() == 16){
			if(vehicle.getType()==VehicleType.ELECTRIC ) 
				throw new BadRequestException("Truck can't be ELECTRIC");
			Truck entity = this.truckConverter.convertToEntity(vehicle);
			entity = this.vehicleDao.save(entity);
			return this.truckConverter.convertToBoundary(entity);
		}
		
		return null;
	}

	
	@Override
	@Transactional(readOnly = true)
	public VehicleBoundary getVehicleByLicenseNumber(long licenseNumber) {
		
		Optional<VehicleEntity> optionalVehicle = this.vehicleDao.findById(licenseNumber);
		VehicleEntity vehicle;
		if(optionalVehicle.isPresent()) 
				vehicle = optionalVehicle.get();		
		else
			throw new BadRequestException("Can't find vehicle with license number : " + licenseNumber);
		
		return this.vehicleConveter.convertToBoundary(vehicle);
	}

	
	@Override
	@Transactional(readOnly = true)
	public List<VehicleBoundary> getAllVehicles() {

	return StreamSupport.stream(this.vehicleDao.findAll().spliterator(), false) 
						.map(this.vehicleConveter::convertToBoundary) 
						.collect(Collectors.toList());
			
	}

	
	@Override
	@Transactional
	public void inflateAllVehiclesToMaxPressure() {
		List<VehicleEntity> allVehicles = (List<VehicleEntity>) this.vehicleDao.findAll();
				
				
		for (int i = 0; i <allVehicles.size(); i++) {
			
			allVehicles.get(i).setAvailableTirePressure(200);
		}
	}

	
	@Override
	@Transactional
	public VehicleBoundary inflateVehicleToMaxPressure(long licenseNumber) {
		Optional<VehicleEntity> optionalVehicle = this.vehicleDao.findById(licenseNumber);
		VehicleEntity vehicle;
		if(optionalVehicle.isPresent()) 
				vehicle = optionalVehicle.get();		
		else
			throw new BadRequestException("Can't find vehicle with license number : " + licenseNumber);
		if(vehicle.getAvailableTirePressure() != 200)
			vehicle.setAvailableTirePressure(200);
		
		return this.vehicleConveter.convertToBoundary(vehicle);
	}

	
	@Override
	@Transactional
	public VehicleBoundary addEnergyToVehicleByLicenseNumber(long licenseNumber) {
		Optional<VehicleEntity> optionalVehicle = this.vehicleDao.findById(licenseNumber);
		VehicleEntity vehicle;
		if(optionalVehicle.isPresent()) 
				vehicle = optionalVehicle.get();		
		else
			throw new BadRequestException("Can't find vehicle with license number : " + licenseNumber);
		if(vehicle.getAvailableEnergy() != 100)
			vehicle.setAvailableEnergy(100);
		
		return this.vehicleConveter.convertToBoundary(vehicle);
	}


	

	


	

}
