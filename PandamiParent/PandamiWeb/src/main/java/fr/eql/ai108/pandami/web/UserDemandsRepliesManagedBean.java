package fr.eql.ai108.pandami.web;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
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
	
    private List<Demand> usersDemands;
    private List<Reply> usersReplies;
    private List<Reply> rejectedReplies;
    
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
    	usersDemands = proxyDemandBu.displayFilteredByRepliesOwnedDemands(sessionUser.getId());
    	usersReplies = proxyReplyBu.displayOwnedReplies(sessionUser.getId());
    }
    
	//TODO floriane : implémenter le bouton d'annulation
    public String cancelDemand(Demand demand) {
        demand.setCancelDate(LocalDateTime.now());
        //demand.setCancelReason(cancelReason);
        proxyDemandBu.upDateDemand(demand);
        usersDemands = proxyDemandBu.displayFilteredByRepliesOwnedDemands(sessionUser.getId());
        return "/userDemandsAndReplies.xhtml?faces-redirect=true";
    }
   
    public String chooseVolunteer (Reply reply) { 
    	reply.setSelectionDate(LocalDateTime.now());
    	proxyReplyBu.updateReply(reply); //ecris en bdd dateDuJour ds reply choisie
    	rejectedReplies = proxyReplyBu.getNotSelectedRepliesByDemandId(reply.getDemand().getId()); //récupérer les autres replies
    	for (Reply rejectedReply : rejectedReplies) {
    		System.out.println("rejetée " + rejectedReply);
    		rejectedReply.setRejectDate(LocalDateTime.now());
    		proxyReplyBu.updateReply(rejectedReply); //update avec dateDuJour dans rejectedDate
		}
    	//reinitialiser les listes de demandes du User, filtrée :
    	usersDemands = proxyDemandBu.displayFilteredByRepliesOwnedDemands(sessionUser.getId());
    	return "/userDemandsAndReplies.xhtml?faces-redirect=true";
    }
    //TODO Floriane : 
    //pour l'onglet "mon bénévolat" : afficher pour chaque réponse l'action, le nom du bénéficiaire, la date de l'action, la date du post, la date ou on a postulé.
    //statut : choisi / en attente (rejeté ?)
    //bouton pour annuler dans un second temps : reply.desistDate = date.now()
    
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

	public List<Reply> getRejectedReplies() {
		return rejectedReplies;
	}

	public void setRejectedReplies(List<Reply> rejectedReplies) {
		this.rejectedReplies = rejectedReplies;
	}
	
}
