package fr.eql.ai108.pandami.idao;

import java.util.List;

public interface GenericIDao<T> {

	T add(T t);

	boolean delete(T t);

	T update(T t);

	T findById(Integer id);

	List<T> findAll();
	
	List<T> genericQueryById(String jpqlQuery, Integer id, String paramId);
	
}
