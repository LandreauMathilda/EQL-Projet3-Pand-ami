package fr.eql.ai108.pandami.web;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
    private List<City> cities;
    private List<Gender> genders;

    @EJB
    private AccountIBusiness proxyAccountBu;
    
    @PostConstruct
    public void init() {
    	cities = proxyAccountBu.displayCities();
    	genders = proxyAccountBu.displayGenders();
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
	
	

}