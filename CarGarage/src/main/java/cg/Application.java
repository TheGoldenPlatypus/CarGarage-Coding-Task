package cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import cg.dao.VehicleDao;
import cg.data.MyDataLoader;
import cg.entites.Car;
import cg.entites.Motorcycle;
import cg.entites.Truck;
import cg.entites.VehicleEntity;


@SpringBootApplication
public class Application {
	MyDataLoader dl = new MyDataLoader(); 
	  @Bean
	    CommandLineRunner dataLoader(VehicleDao vd) {
	        return args -> {
	        	VehicleEntity vehicleEntity;
	        	for (int i = 0; i < 12; i++) {
	        		int type = i/4;
	        		if (type == 0) {
	        			vehicleEntity = new Car();
	        		}else if(type == 1) {
	        			vehicleEntity = new Motorcycle();
	        		}else {
	        			vehicleEntity = new Truck();
	        		}
	        		dl.loadData(vehicleEntity);
	        		vd.save(vehicleEntity);
				}
	        };
	    }
	  

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
