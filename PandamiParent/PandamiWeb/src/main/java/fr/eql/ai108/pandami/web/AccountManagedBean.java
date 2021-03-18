package fr.eql.ai108.pandami.web;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Pattern;

import fr.eql.ai108.pandami.entity.City;
import fr.eql.ai108.pandami.entity.Gender;
import fr.eql.ai108.pandami.entity.User;
import fr.eql.ai108.pandami.entity.UserType;
import fr.eql.ai108.pandami.ibusiness.AccountIBusiness;


@ManagedBean(name = "mbConnect")
@SessionScoped
public class AccountManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private User user = new User();
	private String message;
	private String login;
	@Pattern (regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})", 
			message = "Le password soit comprendre un digit, une minuscule, une majuscule, "
					+ "un caractère spécial et sa taille doit être comprise entre et 20 caractères")
	private String password;
	private List<City> cities;
	private List<Gender> genders;
	private String verifPassword;
	private String newPassword;
	private String passwordMessage;


	private String nameKaradoc;
	private String surnameKaradoc;
	private Gender genderKaradoc;
	private String streetKaradoc;
	private City cityKaradoc ;
	private LocalDate birthDateKaradoc ;
	private String phoneNumberKaradoc;
	private String emailKaradoc ;
	private String emergencyContactNameKaradoc;
	private String emergencyContactSurnameKaradoc;
	private String emergencyContactPhoneNumberKaradoc;
	private String loginKaradoc;
	private String passwordKaradoc;
	private LocalDateTime inscriptionDateKaradoc;


	@EJB
	private AccountIBusiness proxyAccountBu;

	User sessionUser = new User();

	@PostConstruct
	public void init() {
		cities = proxyAccountBu.displayCities();
		genders = proxyAccountBu.displayGenders();
		
	}



	public String setDemoKaradoc() {
		nameKaradoc = "Karadoc";
		surnameKaradoc = "De Vannes";
		genderKaradoc = new Gender(2, "Femme");
		streetKaradoc = "34 rue de Vannes";
		cityKaradoc = new City(3, "Vincennes", "94300");
		birthDateKaradoc = LocalDate.of(438, 04, 10);
		phoneNumberKaradoc = "0297648315";
		emailKaradoc = "karadocDeVannes@Kaamelott.fr";
		emergencyContactNameKaradoc = "Mevanwi";
		emergencyContactSurnameKaradoc = "De Vannes";
		emergencyContactPhoneNumberKaradoc = "0264975836";
		loginKaradoc = "Karadoc";
		passwordKaradoc = "karadoc";
		System.out.println("coucou demo");

		user = new User(null, null, nameKaradoc, surnameKaradoc,  genderKaradoc, streetKaradoc, cityKaradoc, birthDateKaradoc, phoneNumberKaradoc, emailKaradoc, emergencyContactNameKaradoc, emergencyContactSurnameKaradoc, emergencyContactPhoneNumberKaradoc, loginKaradoc, passwordKaradoc, inscriptionDateKaradoc, null, null, null);
	  return "userInfo.xhtml?faces-redirect=true";
	}

	public String createAccount() {
		//ajout automatique date du jour et usertype=2 (utilisateur)
		user.setInscriptionDate(LocalDateTime.now());
		user.setUserType(new UserType(2));
		user = proxyAccountBu.createAccount(user);
		//verification que le user n'existe pas deja en base, basé sur login unique
		if(user == null) {

			message = "Ce login n'est pas disponible. Choisissez en un autre";
		} else if (user != null){
			message = "Merci " + user.getLogin() + ". Votre compte a bien été créé";
			user = new User();
		} else {

			message="tous les champs suivis de '*' doivent être renseignés";
		}

		return "/userInfo.xhtml?faces-redirect=true";

	}

	public String connection(){
		user = proxyAccountBu.connection(user.getLogin(), user.getPassword());
		String retour = "";
		if(user != null && user.getUserType().getId() == 2) {
			sessionUser = user;
			retour = "/connectedHome.xhtml?faces-redirect=true";
		} else if(user != null && user.getUserType().getId() == 1) {
			sessionUser = user;
			retour = "/adminHome.xhtml?faces-redirect=true";
		}else {
			user = new User();
			message = "Login/Password incorrectes";
			retour = "/connectionPage.xhtml?faces-redirect=true";
		}

		return retour;
	}

	public String disconnect() {
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		//Réinitialisation des champs:
		login = "";
		password = "";
		user = new User();

		return "/notConnectedHome.xhtml?faces-redirect=true";
	}

	public String modifyUserInfo() {
		proxyAccountBu.modifyUserInfo(sessionUser);
		message = "Vos informations ont bien été mises à jour";
		return "/modifUserInfo.xhtml?faces-redirect=true";
	}

	public String setNewPassword() {
		if(verifPassword.equals(sessionUser.getPassword())) {
			sessionUser.setPassword(newPassword);
			System.out.println(sessionUser.getPassword());
			passwordMessage = "Votre mot de passe a bien été modifié";
		}else {
			passwordMessage = "Veuillez réessayer";
		}
		return "/modifUserInfo.xhtml?faces-redirect=true";
	}





	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<Gender> getGenders() {
		return genders;
	}

	public void setGenders(List<Gender> genders) {
		this.genders = genders;
	}

	public User getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(User sessionUser) {
		this.sessionUser = sessionUser;
	}

	public String getVerifPassword() {
		return verifPassword;
	}

	public void setVerifPassword(String verifPassword) {
		this.verifPassword = verifPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getPasswordMessage() {
		return passwordMessage;
	}

	public void setPasswordMessage(String passwordMessage) {
		this.passwordMessage = passwordMessage;
	}


	public AccountIBusiness getProxyAccountBu() {
		return proxyAccountBu;
	}

	public void setProxyAccountBu(AccountIBusiness proxyAccountBu) {
		this.proxyAccountBu = proxyAccountBu;
	}
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