package fr.eql.ai108.pandami.idao;

import java.util.List;

import fr.eql.ai108.pandami.entity.Demand;

public interface DemandIDao extends GenericIDao<Demand>{

	List<Demand> getAllNotOwnedById(Integer id);
	List<Demand> getAllByUser(Integer id);
	List<Demand> getAllPastDemandsByUser(Integer id);

}
