package fr.eql.ai108.pandami.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eql.ai108.pandami.entity.Availability;
import fr.eql.ai108.pandami.idao.AvailabilityIDao;

@Remote(AvailabilityIDao.class)
@Stateless
public class AvailabilityDao extends GenericDao<Availability> implements AvailabilityIDao {

	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;
}
