package fr.eql.ai108.pandami.ibusiness;

import java.util.List;

import fr.eql.ai108.pandami.entity.City;
import fr.eql.ai108.pandami.entity.Gender;
import fr.eql.ai108.pandami.entity.User;

public interface AccountIBusiness {

	User createAccount (User user);
	List<City> displayCities();
	List<Gender> displayGenders();
}