package fr.eql.ai108.pandami.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

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
	
	@Override
	public boolean delete(T t) {

		Boolean removed;

		try {

			t = em.merge(t); //Objet t est renvoyé de la session - il doit etre persistant pour pouvoir etre supprimé
			em.remove(t);
			removed = true;

		} catch (Exception e) {
			e.printStackTrace();

			removed = false;
		}

		return removed;
	}

	@Override
	public T update(T t) {

		try {

			em.merge(t);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Integer id) {

		T t = null;
		
		try {
			
			String className = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
			Class<?> clazz;
			clazz = Class.forName(className);
			t = (T) em.find(clazz, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getListById(Integer id) {

		List<T> t = null;
		
		try {
			
			String className = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
			Class<?> clazz;
			clazz = Class.forName(className);
			t = (List<T>) em.find(clazz, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return t;
	}

}
