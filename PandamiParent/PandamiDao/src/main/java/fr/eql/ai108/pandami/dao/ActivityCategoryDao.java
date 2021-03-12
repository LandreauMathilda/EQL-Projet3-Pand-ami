package fr.eql.ai108.pandami.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eql.ai108.pandami.entity.ActivityCategory;
import fr.eql.ai108.pandami.idao.ActivityCategoryIDao;

@Remote(ActivityCategoryIDao.class)
@Stateless
public class ActivityCategoryDao extends GenericDao<ActivityCategory> implements ActivityCategoryIDao {
	
	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;
	
}
