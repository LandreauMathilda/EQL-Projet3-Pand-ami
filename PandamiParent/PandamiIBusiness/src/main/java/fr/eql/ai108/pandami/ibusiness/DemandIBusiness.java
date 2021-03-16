package fr.eql.ai108.pandami.ibusiness;

import java.util.List;

import fr.eql.ai108.pandami.entity.Activity;
import fr.eql.ai108.pandami.entity.ActivityCategory;
import fr.eql.ai108.pandami.entity.City;
import fr.eql.ai108.pandami.entity.Demand;
import fr.eql.ai108.pandami.entity.EquipmentType;
import fr.eql.ai108.pandami.entity.Research;

public interface DemandIBusiness {
	
	Demand createDemand(Demand demand);
	
	Demand upDateDemand(Demand demand);
	
	List<Demand> displayAllDemands();
	
	List<City> displayCities();

	List<Demand> getNotOwnedDemands(Integer id);
	
	List<Activity> displayActivities();
	
	List<EquipmentType> displayEquipments();
	
	List<ActivityCategory> displayCategories();
	
	List<Demand> displayOwnedDemands(Integer id);

	String displayDemandStatus(Integer demandId, Integer userId);
	
	List<Demand> getDemandsByResearch(Research research, List<Demand> demands);
	
}
