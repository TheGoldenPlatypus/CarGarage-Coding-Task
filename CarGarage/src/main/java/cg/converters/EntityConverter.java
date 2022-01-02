package cg.converters;

import java.util.Map;

import cg.boundaries.VehicleBoundary;
import cg.entites.VehicleEntity;

public interface EntityConverter {
	
	public VehicleBoundary toBoundary(VehicleEntity entity);

	public VehicleEntity fromBoundary(VehicleBoundary boundary);
	
    public String fromMapToJson (Map<String, Object> value); // marshalling: Java->JSON
	
	public Map<String, Object> fromJsonToMap (String json); // unmarshalling: JSON->Java

}
