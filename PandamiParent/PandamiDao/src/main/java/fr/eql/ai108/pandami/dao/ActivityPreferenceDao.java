package fr.eql.ai108.pandami.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eql.ai108.pandami.entity.ActivityPreference;
import fr.eql.ai108.pandami.idao.ActivityPreferenceIDao;

@Remote(ActivityPreferenceIDao.class)
@Stateless
public class ActivityPreferenceDao extends GenericDao<ActivityPreference> implements ActivityPreferenceIDao {

	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;
}
