package fr.eql.ai108.pandami.web;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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
	private String password;
    private List<City> cities;
    private List<Gender> genders;

    @EJB
    private AccountIBusiness proxyAccountBu;
    
    //todo a modifier : avec le vrai user en session //
    private User sessionUser;
    
    @PostConstruct
    public void init() {
    	cities = proxyAccountBu.displayCities();
    	genders = proxyAccountBu.displayGenders();
    	sessionUser = proxyAccountBu.getUserById();
    }

    public String createAccount() {
    	//ajout automatique date du jour et usertype=2 (utilisateur)
		user.setInscriptionDate(LocalDateTime.now());
		user.setUserType(new UserType(2));
        user = proxyAccountBu.createAccount(user);

        //verification que le user n'existe pas deja en base, basé sur login unique
        if(user == null) {
            message = "Ce login n'est pas disponible. Choisissez en un autre";
        } else {
            message = "Merci " + user.getLogin() + ". Votre compte a bien été créé";
        }
        user = new User();
        return "/userInfo.xhtml?faces-redirect=true";
    }
    
    public String connection(){
		user = proxyAccountBu.connection(user.getLogin(), user.getPassword());
		String retour = "";
		if(user != null) {
			retour = "/connectedHome.xhtml?faces-redirect=true";
		} else {
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
		
		return "/connectionPage.xhtml?faces-redirect=true";
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
}