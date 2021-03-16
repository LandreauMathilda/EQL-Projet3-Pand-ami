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
    
    private Demand selectedDemand;
    
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
    }
    
    public String cancelDemand(Demand demand) {
        demand.setCancelDate(LocalDateTime.now());
        //demand.setCancelReason(cancelReason);
        proxyDemandBu.upDateDemand(demand);
        usersDemands = proxyDemandBu.displayOwnedDemands(sessionUser.getId());
        return "/userDemandsAndReplies.xhtml?faces-redirect=true";
    }

    //TODO : set une rejectDate pour les autres réponses. et changer ce qui s'affiche dans la tabView.
    //1- méthode (business/dao) qui récupérère la liste de replies depuis la demand. si liste.size >0 
    	// --> on recupere toutes les replies qui ont une selectDate à null, et on modifie leur rejectDate avec date.now();
    // 2- changer le bouton pour afficher un label une fois selectionné.
   
    public String chooseVolunteer (Reply reply) { //méthode avec la reply recupérée en fetch.eager demand.replies, directement :
    	reply.setSelectionDate(LocalDateTime.now());
    	proxyReplyBu.updateReply(reply);
    	usersDemands = proxyDemandBu.displayOwnedDemands(sessionUser.getId());
    	return "/userDemandsAndReplies.xhtml?faces-redirect=true";
    }
    //pour l'onglet "mon bénévolat" : afficher pour chaque réponse l'action, le nom du bénéficiaire, la date de l'action, la date du post, la date ou on a postulé.
    //statut : choisi / en attente (rejeté ?)
    	//bouton pour annuler : reply.desistDate = date.now()
    
    /*
    //autre technique sans passer par le fetch.Eager
    public String displayReplies(Demand demand) {
    	demandsReplies = proxyReplyBu.displayRepliesByDemandId(demand.getId());
    	return "/userDemandsAndReplies.xhtml?faces-redirect=true";
    }
    */
    
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

	public Demand getSelectedDemand() {
		return selectedDemand;
	}

	public void setSelectedDemand(Demand selectedDemand) {
		this.selectedDemand = selectedDemand;
	}
    
	
	
}
