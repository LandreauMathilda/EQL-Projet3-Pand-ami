package fr.eql.ai108.pandami.dao;


import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai108.pandami.entity.User;
import fr.eql.ai108.pandami.idao.UserIDao;

@Remote (UserIDao.class)
@Stateless
public class UserDao extends GenericDao<User> implements UserIDao {

	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public Boolean exist(User user) {
		Query query = em.createQuery("SELECT u FROM User u WHERE u.login = :paramLogin");
		query.setParameter("paramLogin", user.getLogin());
		List<User> users = query.getResultList();
		return users.size() > 0 ? true : false;
	}

	public Boolean exist(String login) {
		Query query = em.createQuery("SELECT u FROM User u WHERE u.login = :paramLogin");
		query.setParameter("paramLogin", login);
		List<User> users = query.getResultList();
		return users.size() > 0 ? true : false;
	}

}
