package fr.eql.ai108.pandami.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eql.ai108.pandami.entity.UserType;
import fr.eql.ai108.pandami.idao.UserTypeIDao;

@Remote(UserTypeIDao.class)
@Stateless
public class UserTypeDao extends GenericDao<UserType> implements UserTypeIDao {

	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;
}
