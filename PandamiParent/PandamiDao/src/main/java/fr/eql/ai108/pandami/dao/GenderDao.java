package fr.eql.ai108.pandami.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eql.ai108.pandami.entity.Gender;
import fr.eql.ai108.pandami.idao.GenderIDao;

@Remote(GenderIDao.class)
@Stateless
public class GenderDao extends GenericDao<Gender> implements GenderIDao {

	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;
}
