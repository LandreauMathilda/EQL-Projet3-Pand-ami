package fr.eql.ai108.pandami.web;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.eql.ai108.pandami.entity.User;

@ManagedBean(name="mbRedirect")
@SessionScoped
public class RedirectManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManagedProperty (value="#{mbConnect.sessionUser}")
	private User sessionUser;
	private String message;
	
	public String redirectConnect() {
	return "connectionPage.xhtml?faces-redirect=true";
	}
	
	public String redirectCreateAccount() {
		return "/userInfo.xhtml?faces-redirect=true";
	}
	
	public String redirectNotConnectedHome() {
		return "/notConnectedHome.xhtml?faces-redirect=true";
	}

	public String redirectConnectedHome() {
		return "/connectedHome.xhtml?faces-redirect=true";
	}
	
	public String redirectProfil() {
		return "/modifUserInfo.xhtml?faces-redirect=true";
	}
	
	public String redirectSearchDemand() {
		return "/searchingDemand.xhtml?faces-redirect=true";
	}
	
	public String redirectDemandDeposit() {
		return "/demandDeposit.xhtml?faces-redirect=true";
	}
	
	public String redirectAdminRef() {
		return "/adminRef.xhtml?faces-redirect=true";
	}
	
	public String redirectAdminDemands() {
		return "/adminDemands.xhtml?faces-redirect=true";
	}
	
	public String redirectAdminUsers() {
		return "/adminUsers.xhtml?faces-redirect=true";
	}
	
	public String redirectAdminHome() {
		return "/adminHome.xhtml?faces-redirect=true";
	}
	
	public String redirectDemandsAndReplies() {
		return "userDemandsAndReplies.xhtml?faces-redirect=true";
	}

	public User getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(User sessionUser) {
		this.sessionUser = sessionUser;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
