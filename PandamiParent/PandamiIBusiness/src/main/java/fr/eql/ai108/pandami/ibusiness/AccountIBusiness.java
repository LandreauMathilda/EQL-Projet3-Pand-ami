package fr.eql.ai108.pandami.ibusiness;

import java.util.List;

import fr.eql.ai108.pandami.entity.City;
import fr.eql.ai108.pandami.entity.Gender;
import fr.eql.ai108.pandami.entity.User;

public interface AccountIBusiness {

	User createAccount (User user);
	List<City> displayCities();
	List<Gender> displayGenders();
	User connection(String login, String password);
	List<User> displayAllUsers();
	//a retirer quand yaura la session
	User getUserById();
	User modifyUserInfo(User user);
	City createCity(City city);
}