package fr.eql.ai108.pandami.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eql.ai108.pandami.entity.Demand;
import fr.eql.ai108.pandami.idao.DemandIDao;

@Remote(DemandIDao.class)
@Stateless
public class DemandDao extends GenericDao<Demand> implements DemandIDao{
	
	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;

	@Override
	public Demand createDemand() {
		// TODO Auto-generated method stub
		return null;
	}



}
