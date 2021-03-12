package fr.eql.ai108.pandami.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eql.ai108.pandami.entity.Activity;
import fr.eql.ai108.pandami.idao.ActivityIDao;

@Remote(ActivityIDao.class)
@Stateless
public class ActivityDao extends GenericDao<Activity> implements ActivityIDao {
	
	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;
	
	@Override
	public Activity add(Activity t) {
		// TODO Auto-generated method stub
		return null;
	}

}
