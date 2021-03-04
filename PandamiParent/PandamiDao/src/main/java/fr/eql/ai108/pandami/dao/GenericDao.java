package fr.eql.ai108.pandami.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eql.ai108.pandami.idao.GenericIDao;

public abstract class GenericDao<T> implements GenericIDao<T> {

	@PersistenceContext (unitName = "PandamiPU")
	private EntityManager em;

	@Override
	public T add(T t) {
		try {
			em.persist(t);
		} catch (Exception e) {
			t = null;
			e.printStackTrace();
		}
		return t;
	}

}
