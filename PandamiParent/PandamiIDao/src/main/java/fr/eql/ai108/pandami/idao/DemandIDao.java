package fr.eql.ai108.pandami.idao;

import fr.eql.ai108.pandami.entity.Demand;

public interface DemandIDao extends GenericIDao<Demand>{

	 Demand createDemand(Demand demand);
}
