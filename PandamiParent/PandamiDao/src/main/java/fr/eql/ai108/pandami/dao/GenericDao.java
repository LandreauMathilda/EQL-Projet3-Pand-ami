package fr.eql.ai108.pandami.dao;

import java.lang.reflect.ParameterizedType;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	public List<T> findAll() {
		
		List<T> objects = null;
		
		try {
			String className= ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
			Class<?> clazz;
			clazz = Class.forName(className);
			Query query = em.createQuery("FROM " + clazz.getName());
			objects = query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return objects;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> genericQueryById (String jpqlQuery, Integer id, String paramId) {
		LocalDate today = LocalDate.now();
		Query query = em.createQuery(jpqlQuery); 
		query.setParameter(paramId, id); 
		query.setParameter("paramTodayDate", today);
		List<T> results = query.getResultList();
		return !results.isEmpty() ? results : null;
	}

}
