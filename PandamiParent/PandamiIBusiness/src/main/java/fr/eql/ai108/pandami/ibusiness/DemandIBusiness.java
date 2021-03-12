package fr.eql.ai108.pandami.ibusiness;

import java.util.List;

import fr.eql.ai108.pandami.entity.Demand;

public interface DemandIBusiness {
	
	Demand createDemand();

	List<Demand> getNotOwnedDemands(Integer id);
}
