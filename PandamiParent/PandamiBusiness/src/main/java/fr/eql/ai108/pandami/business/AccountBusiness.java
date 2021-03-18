package fr.eql.ai108.pandami.business;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
	
	private String nameKaradoc = "Karadoc";
	private String surnameKaradoc = "De Vannes";
	private Gender genderKaradoc = new Gender(2, "Femme");
	private String streetKaradoc = "34 rue de Vannes";
	private City cityKaradoc = new City(3, "Vincennes", "94300");
	private LocalDate birthDateKaradoc = LocalDate.of(438, 04, 10);
	private String phoneNumberKaradoc = "0297648315";
	private String emailKaradoc = "karadocDeVannes@Kaamelott.fr";
	private String emergencyContactNameKaradoc = "Mevanwi";
	private String emergencyContactSurnameKaradoc = "De Vannes";
	private String emergencyContactPhoneNumberKaradoc = "0264975836";
	private String loginKaradoc = "Karadoc";
	private String passwordKaradoc = "karadoc";
	private LocalDateTime inscriptionDateKaradoc;

	@Override
	public User createAccount(User user) {
		User returnedUser = null;
		if (!proxyUser.exist(user)) {
			returnedUser = proxyUser.add(user); //si le user n'existe pas deja en bdd, je le crée
		}
		return returnedUser;
	}

	@Override
	public List<User> displayAllUsers() {
		return proxyUser.findAll();
	}
	
	@Override
	public List<City> displayCities() {
		return proxyCity.findAll();
	}

	@Override
	public List<Gender> displayGenders() {
		return proxyGender.findAll();
	}
	
	@Override
	public User connection(String login, String password) {
		
		return proxyUser.authenticate(login, password);
	}
	
	//a retirer quand yaura la session :
	@Override
	public User getUserById() {
		return proxyUser.findById(1);
	}

	@Override
	public User modifyUserInfo(User user) {
		return proxyUser.update(user);
	}

	//@Override
	//public User demoUser() {
		//User karadoc = new User(null, null, nameKaradoc, surnameKaradoc,  genderKaradoc, streetKaradoc, cityKaradoc, birthDateKaradoc, phoneNumberKaradoc, emailKaradoc, emergencyContactNameKaradoc, emergencyContactSurnameKaradoc, emergencyContactPhoneNumberKaradoc, loginKaradoc, passwordKaradoc, inscriptionDateKaradoc, null, null, null);
		
		//return karadoc;
	//}

	public String getNameKaradoc() {
		return nameKaradoc;
	}

	public void setNameKaradoc(String nameKaradoc) {
		this.nameKaradoc = nameKaradoc;
	}

	public String getSurnameKaradoc() {
		return surnameKaradoc;
	}

	public void setSurnameKaradoc(String surnameKaradoc) {
		this.surnameKaradoc = surnameKaradoc;
	}

	public Gender getGenderKaradoc() {
		return genderKaradoc;
	}

	public void setGenderKaradoc(Gender genderKaradoc) {
		this.genderKaradoc = genderKaradoc;
	}

	public String getStreetKaradoc() {
		return streetKaradoc;
	}

	public void setStreetKaradoc(String streetKaradoc) {
		this.streetKaradoc = streetKaradoc;
	}

	public City getCityKaradoc() {
		return cityKaradoc;
	}

	public void setCityKaradoc(City cityKaradoc) {
		this.cityKaradoc = cityKaradoc;
	}

	public LocalDate getBirthDateKaradoc() {
		return birthDateKaradoc;
	}

	public void setBirthDateKaradoc(LocalDate birthDateKaradoc) {
		this.birthDateKaradoc = birthDateKaradoc;
	}

	public String getPhoneNumberKaradoc() {
		return phoneNumberKaradoc;
	}

	public void setPhoneNumberKaradoc(String phoneNumberKaradoc) {
		this.phoneNumberKaradoc = phoneNumberKaradoc;
	}

	public String getEmailKaradoc() {
		return emailKaradoc;
	}

	public void setEmailKaradoc(String emailKaradoc) {
		this.emailKaradoc = emailKaradoc;
	}

	public String getEmergencyContactNameKaradoc() {
		return emergencyContactNameKaradoc;
	}

	public void setEmergencyContactNameKaradoc(String emergencyContactNameKaradoc) {
		this.emergencyContactNameKaradoc = emergencyContactNameKaradoc;
	}

	public String getEmergencyContactSurnameKaradoc() {
		return emergencyContactSurnameKaradoc;
	}

	public void setEmergencyContactSurnameKaradoc(String emergencyContactSurnameKaradoc) {
		this.emergencyContactSurnameKaradoc = emergencyContactSurnameKaradoc;
	}

	public String getEmergencyContactPhoneNumberKaradoc() {
		return emergencyContactPhoneNumberKaradoc;
	}

	public void setEmergencyContactPhoneNumberKaradoc(String emergencyContactPhoneNumberKaradoc) {
		this.emergencyContactPhoneNumberKaradoc = emergencyContactPhoneNumberKaradoc;
	}

	public String getLoginKaradoc() {
		return loginKaradoc;
	}

	public void setLoginKaradoc(String loginKaradoc) {
		this.loginKaradoc = loginKaradoc;
	}

	public String getPasswordKaradoc() {
		return passwordKaradoc;
	}

	public void setPasswordKaradoc(String passwordKaradoc) {
		this.passwordKaradoc = passwordKaradoc;
	}

	public LocalDateTime getInscriptionDateKaradoc() {
		return inscriptionDateKaradoc;
	}

	public void setInscriptionDateKaradoc(LocalDateTime inscriptionDateKaradoc) {
		this.inscriptionDateKaradoc = inscriptionDateKaradoc;
	}
	
	

}
