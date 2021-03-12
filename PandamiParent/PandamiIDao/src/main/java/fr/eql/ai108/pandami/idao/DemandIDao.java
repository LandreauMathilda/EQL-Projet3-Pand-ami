package fr.eql.ai108.pandami.idao;

import java.util.List;

import fr.eql.ai108.pandami.entity.Demand;

public interface DemandIDao extends GenericIDao<Demand>{

	Demand createDemand();

	List<Demand> getAllNotOwnedById(Integer id);
}
