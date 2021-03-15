package fr.eql.ai108.pandami.web;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai108.pandami.entity.CancelReason;
import fr.eql.ai108.pandami.entity.Demand;
import fr.eql.ai108.pandami.entity.Reply;
import fr.eql.ai108.pandami.entity.User;
import fr.eql.ai108.pandami.ibusiness.AccountIBusiness;
import fr.eql.ai108.pandami.ibusiness.DemandIBusiness;
import fr.eql.ai108.pandami.ibusiness.ReplyIBusiness;


@ManagedBean(name="mbUserDemRep")
@SessionScoped
public class UserDemandsRepliesManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private List<Demand> usersDemands;
    private List<Reply> usersReplies;
    private Reply selectedReply;
    
	@EJB
	private DemandIBusiness proxyDemandBu;
	@EJB
	private AccountIBusiness proxyAccountBu;
	@EJB
	private ReplyIBusiness proxyReplyBu;
	
	private User sessionUser; //modif, là méthode en dur
	
    @PostConstruct
    public void init() {
    	sessionUser = proxyAccountBu.getUserById();
    	usersDemands = proxyDemandBu.displayOwnedDemands(sessionUser.getId());
    	usersReplies = proxyReplyBu.displayOwnedReplies(sessionUser.getId());
    	for (Demand demand : usersDemands) {
			System.out.println(demand.toString());
			System.out.println("nombre réponses : " + demand.getReplies().size());
		}
    	selectedReply = new Reply();
    }
    
    public String cancelDemand(Demand demand) {
        demand.setCancelDate(LocalDateTime.now());
        //demand.setCancelReason(cancelReason);
        proxyDemandBu.upDateDemand(demand);
        usersDemands = proxyDemandBu.displayOwnedDemands(sessionUser.getId());
        return "/userDemandsAndReplies.xhtml?faces-redirect=true";
    }
    

    public String chooseVolunteer(Reply reply) {
    	System.out.println(reply.toString());
    	//selectedReply.setSelectionDate(LocalDateTime.now());
    	//proxyReplyBu.updateReply(selectedReply);
    	//usersDemands = proxyDemandBu.displayOwnedDemands(sessionUser.getId());
    	return "/userDemandsAndReplies.xhtml?faces-redirect=true";
    }


	public List<Demand> getUsersDemands() {
		return usersDemands;
	}


	public void setUsersDemands(List<Demand> usersDemands) {
		this.usersDemands = usersDemands;
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

	public Reply getSelectedReply() {
		return selectedReply;
	}

	public void setSelectedReply(Reply selectedReply) {
		this.selectedReply = selectedReply;
	}
    
	
}
