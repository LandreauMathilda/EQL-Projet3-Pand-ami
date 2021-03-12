package fr.eql.ai108.pandami.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai108.pandami.entity.User;
import fr.eql.ai108.pandami.ibusiness.AccountIBusiness;


@ManagedBean(name = "mbConnect")
@SessionScoped
public class AccountManagedBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private User user = new User();
    private String message;

    @EJB
    private AccountIBusiness proxyAccountBu;

    public String createAccount() {

        user = proxyAccountBu.createAccount(user);

        if(user == null) {
            message = "Ce login n'est pas disponible. Choisissez en un autre";
        }else {
            message = "Merci " + user.getLogin() + ". Votre compte a bien été créé";
        }

        user = new User();

        return "/index.xhtml?faces-redirect=true";
    }
    
	public String connection(){
		user = proxyAccountBu.connection(user.getLogin(), user.getPassword());
		String retour = "";
		if(user != null) {
			retour = "/connectedPage.xhtml?faces-redirect=true";
			message = "user connected";
		} else {
			user = new User();
			message = "Login/Password incorrectes";
			retour = "/connectionPage.xhtml?faces-redirect=true";
			System.out.println("fail");
		}
		
		return retour;
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


}
