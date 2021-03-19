package fr.eql.ai108.pandami.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai108.pandami.entity.City;
import fr.eql.ai108.pandami.entity.User;
import fr.eql.ai108.pandami.idao.CityIDao;

@Remote(CityIDao.class)
@Stateless
public class CityDao extends GenericDao<City> implements CityIDao {

	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public City getCity(City city) {
		Query query = em.createQuery("SELECT c FROM City c WHERE c.name = :paramName AND c.zipCode = :paramZipCode");
		query.setParameter("paramName", city.getName());
		query.setParameter("paramZipCode", city.getZipCode());
		List<City> cities = query.getResultList();
		return cities.size() > 0 ? cities.get(0) : null;
	}
}
