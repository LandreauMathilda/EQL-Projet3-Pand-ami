package fr.eql.ai108.pandami.ibusiness;

import java.util.List;
import fr.eql.ai108.pandami.entity.City;
import fr.eql.ai108.pandami.entity.Demand;

public interface DemandIBusiness {
	
	Demand createDemand(Demand demand);
	
	List<City> displayCities();

	List<Demand> getNotOwnedDemands(Integer id);
}
