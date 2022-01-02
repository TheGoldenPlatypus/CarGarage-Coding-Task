package cg.dao;

import org.springframework.data.repository.CrudRepository;

import cg.entites.VehicleEntity;

public interface VehicleDao extends CrudRepository<VehicleEntity,Long>  {

}
