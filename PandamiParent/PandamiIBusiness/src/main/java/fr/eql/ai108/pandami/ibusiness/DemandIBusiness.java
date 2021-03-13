package fr.eql.ai108.pandami.ibusiness;

import java.util.List;

import fr.eql.ai108.pandami.entity.Activity;
import fr.eql.ai108.pandami.entity.ActivityCategory;
import fr.eql.ai108.pandami.entity.City;
import fr.eql.ai108.pandami.entity.Demand;
import fr.eql.ai108.pandami.entity.EquipmentType;

public interface DemandIBusiness {
	
	Demand createDemand(Demand demand);
	
	List<City> displayCities();

	List<Demand> getNotOwnedDemands(Integer id);
	
	List<Activity> displayActivities();
	
	List<EquipmentType> displayEquipments();
	
	List<ActivityCategory> displayCategories();
	
}
