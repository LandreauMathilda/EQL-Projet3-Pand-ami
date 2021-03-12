package fr.eql.ai108.pandami.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai108.pandami.entity.City;
import fr.eql.ai108.pandami.entity.Gender;
import fr.eql.ai108.pandami.entity.User;
import fr.eql.ai108.pandami.ibusiness.AccountIBusiness;
import fr.eql.ai108.pandami.idao.CityIDao;
import fr.eql.ai108.pandami.idao.GenderIDao;
import fr.eql.ai108.pandami.idao.UserIDao;

@Remote (AccountIBusiness.class)
@Stateless
public class AccountBusiness implements AccountIBusiness{

	@EJB
	private UserIDao proxyUser;
	@EJB
	private CityIDao proxyCity;
	@EJB
	private GenderIDao proxyGender;

	@Override
	public User createAccount(User user) {
		User returnedUser = null;
		if (!proxyUser.exist(user)) {
			returnedUser = proxyUser.add(user); //si le user n'existe pas deja en bdd, je le crée
		}
		return returnedUser;
	}

	@Override
	public List<City> displayCities() {
		return proxyCity.findAll();
	}

	@Override
	public List<Gender> displayGenders() {
		return proxyGender.findAll();
	}

}
