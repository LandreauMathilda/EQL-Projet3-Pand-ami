package fr.eql.ai108.pandami.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eql.ai108.pandami.entity.EndedType;
import fr.eql.ai108.pandami.idao.EndedTypeIDao;

@Remote(EndedTypeIDao.class)
@Stateless
public class EndedTypeDao extends GenericDao<EndedType> implements EndedTypeIDao {

	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;
}
