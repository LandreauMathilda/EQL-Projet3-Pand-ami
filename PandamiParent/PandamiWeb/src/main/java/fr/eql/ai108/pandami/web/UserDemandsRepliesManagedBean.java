package fr.eql.ai108.pandami.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.eql.ai108.pandami.entity.Demand;
import fr.eql.ai108.pandami.entity.Reply;
import fr.eql.ai108.pandami.entity.User;
import fr.eql.ai108.pandami.ibusiness.AccountIBusiness;
import fr.eql.ai108.pandami.ibusiness.DemandIBusiness;
import fr.eql.ai108.pandami.ibusiness.ReplyIBusiness;


@ManagedBean(name="mbUserDemRep")
@ViewScoped
public class UserDemandsRepliesManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private List<Demand> usersPastDemands;
    private List<Reply> usersReplies;
    private List<Reply> rejectedReplies;
    private List<Reply> usersPastReplies;
    private String selectionMessage;
    private List<Demand> usersValidatedDemands;
    private List<Demand> usersPendingValidationDemands;
    private Integer activeIndex;
    
	@EJB
	private DemandIBusiness proxyDemandBu;
	@EJB
	private AccountIBusiness proxyAccountBu;
	@EJB
	private ReplyIBusiness proxyReplyBu;
	
	@ManagedProperty (value="#{mbConnect.sessionUser}")
	private User sessionUser;
	
	@PostConstruct
    public void init() {
    	usersValidatedDemands = proxyDemandBu.displayOwnedValidatedByUser(sessionUser.getId());
    	usersPendingValidationDemands = proxyDemandBu.displayOwnedPendingValidationByUser(sessionUser.getId());
    	System.out.println(sessionUser.getId());
    	usersReplies = proxyReplyBu.displayOwnedReplies(sessionUser.getId());
    	usersPastDemands = proxyDemandBu.displayAllPastOwnedDemandsByUser(sessionUser.getId());
    	usersPastReplies = proxyReplyBu.displayPastOwnedReplies(sessionUser.getId());
    }
    
    public String cancelDemand(Demand demand) {
    	demand = proxyDemandBu.cancelDemand(demand);
        return refresh();
    }
   
    
    public String chooseVolunteer (Reply reply) { 
    	//update la demand en base : 
    	Demand replysDemand = reply.getDemand();
    	replysDemand = proxyDemandBu.updateDemandWhenReplyIsSelected(replysDemand);
    	
    	//update la selectedReply et les rejectedReplies en base:
    	reply = proxyReplyBu.updateSelectedReply(reply);
    	rejectedReplies = proxyReplyBu.getNotSelectedRepliesByDemandId(reply.getDemand().getId()); 
    	rejectedReplies = proxyReplyBu.updateRejectedReplies(rejectedReplies);
    	activeIndex = 1;
    	return refresh();
    }
    
    private String refresh() {
    	//reinitialiser les listes de demandes du User, filtrée :
    	usersValidatedDemands = proxyDemandBu.displayOwnedValidatedByUser(sessionUser.getId());
    	usersPendingValidationDemands = proxyDemandBu.displayOwnedPendingValidationByUser(sessionUser.getId());
    	return "/userDemandsAndReplies.xhtml?faces-redirect=true";	
    }
    
    public String getStatusByReply(Reply reply) {
    	return proxyReplyBu.displayStatusByReply(reply);
    }
    
    public String getStatusByDemand(Demand demand) {
    	return proxyDemandBu.displayDemandStatusForUser(demand);
    }

	public User getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(User sessionUser) {
		this.sessionUser = sessionUser;
	}

	public List<Reply> getUsersReplies() {
		return usersReplies;
	}

	public void setUsersReplies(List<Reply> usersReplies) {
		this.usersReplies = usersReplies;
	}

	public List<Reply> getRejectedReplies() {
		return rejectedReplies;
	}

	public void setRejectedReplies(List<Reply> rejectedReplies) {
		this.rejectedReplies = rejectedReplies;
	}

	public List<Demand> getUsersPastDemands() {
		return usersPastDemands;
	}

	public void setUsersPastDemands(List<Demand> usersPastDemands) {
		this.usersPastDemands = usersPastDemands;
	}

	public List<Reply> getUsersPastReplies() {
		return usersPastReplies;
	}

	public void setUsersPastReplies(List<Reply> usersPastReplies) {
		this.usersPastReplies = usersPastReplies;
	}

	public String getSelectionMessage() {
		return selectionMessage;
	}

	public void setSelectionMessage(String selectionMessage) {
		this.selectionMessage = selectionMessage;
	}

	public List<Demand> getUsersValidatedDemands() {
		return usersValidatedDemands;
	}

	public void setUsersValidatedDemands(List<Demand> usersValidatedDemands) {
		this.usersValidatedDemands = usersValidatedDemands;
	}

	public List<Demand> getUsersPendingValidationDemands() {
		return usersPendingValidationDemands;
	}

	public void setUsersPendingValidationDemands(List<Demand> usersPendingValidationDemands) {
		this.usersPendingValidationDemands = usersPendingValidationDemands;
	}

	public Integer getActiveIndex() {
		return activeIndex;
	}
	public void setActiveIndex(Integer activeIndex) {
		this.activeIndex = activeIndex;
	}
}
