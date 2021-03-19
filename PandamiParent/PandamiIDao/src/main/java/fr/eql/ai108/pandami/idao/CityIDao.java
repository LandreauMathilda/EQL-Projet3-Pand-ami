package fr.eql.ai108.pandami.idao;

import java.util.List;

import fr.eql.ai108.pandami.entity.City;

public interface CityIDao extends GenericIDao<City> {

	City getCity(City city);
	
	List<City> findAll();

}
