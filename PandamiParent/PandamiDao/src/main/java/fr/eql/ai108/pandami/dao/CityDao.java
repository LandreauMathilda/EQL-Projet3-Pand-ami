package fr.eql.ai108.pandami.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eql.ai108.pandami.entity.City;
import fr.eql.ai108.pandami.idao.CityIDao;

@Remote(CityIDao.class)
@Stateless
public class CityDao extends GenericDao<City> implements CityIDao {

	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;
}
