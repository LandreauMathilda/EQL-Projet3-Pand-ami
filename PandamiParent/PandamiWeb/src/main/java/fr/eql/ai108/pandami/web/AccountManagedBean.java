package fr.eql.ai108.pandami.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai108.pandami.entity.City;
import fr.eql.ai108.pandami.entity.User;
import fr.eql.ai108.pandami.ibusiness.AccountIBusiness;


@ManagedBean(name = "mbConnect")
@SessionScoped
public class AccountManagedBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private User user = new User();
    private String message;
    private List<City> cities;

    @EJB
    private AccountIBusiness proxyAccountBu;
    
    @PostConstruct
    public void init() {
    	cities = proxyAccountBu.displayCities();
    }

    public String createAccount() {

        user = proxyAccountBu.createAccount(user);

        if(user == null) {
            message = "Ce login n'est pas disponible. Choisissez en un autre";
        } else {
            message = "Merci " + user.getLogin() + ". Votre compte a bien été créé";
        }
        user = new User();
        return "/index.xhtml?faces-redirect=true";
    }
    
    public void printSelectedCity() {
    	System.out.println(user.getCity().toString());
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

}
