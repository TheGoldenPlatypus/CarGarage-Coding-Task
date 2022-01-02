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
	        	VehicleEntity c1 = new Car();
	        	VehicleEntity c2 = new Car();
	        	VehicleEntity c3 = new Car();
	        	VehicleEntity c4 = new Car();
	        	VehicleEntity m1 = new Motorcycle();
	        	VehicleEntity m2 = new Motorcycle();
	        	VehicleEntity m3 = new Motorcycle();
	        	VehicleEntity m4 = new Motorcycle();
	        	VehicleEntity t1 = new Truck();
	        	VehicleEntity t2 = new Truck();
	        	VehicleEntity t3 = new Truck();
	        
	        	dl.loadData(c1);
	        	dl.loadData(c2);
	        	dl.loadData(c3);
	        	dl.loadData(c4);
	        	dl.loadData(m1);
	        	dl.loadData(m2);
	        	dl.loadData(m3);
	        	dl.loadData(m4);
	        	dl.loadData(t1);
	        	dl.loadData(t2);
	        	dl.loadData(t3);
	        	
	        	vd.save(c1);
	        	vd.save(c2);
	        	vd.save(c3);
	        	vd.save(c4);
	        	vd.save(m1);
	        	vd.save(m2);
	        	vd.save(m3);
	        	vd.save(m4);
	        	vd.save(t1);
	        	vd.save(t2);
	        	vd.save(t3);
	        	

	        };
	    }
	  

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
