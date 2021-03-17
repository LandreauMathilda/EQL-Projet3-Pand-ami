package fr.eql.ai108.pandami.web;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import fr.eql.ai108.pandami.entity.Activity;
import fr.eql.ai108.pandami.entity.ActivityCategory;
import fr.eql.ai108.pandami.entity.City;
import fr.eql.ai108.pandami.entity.Demand;
import fr.eql.ai108.pandami.entity.EquipmentType;
import fr.eql.ai108.pandami.entity.Reply;
import fr.eql.ai108.pandami.entity.Research;
import fr.eql.ai108.pandami.entity.User;
import fr.eql.ai108.pandami.ibusiness.DemandIBusiness;
import fr.eql.ai108.pandami.ibusiness.ReplyIBusiness;

@ManagedBean (name="mbSearch")
@SessionScoped
public class SearchManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty (value="#{mbConnect.sessionUser}")
	private User sessionUser;

	@EJB
	private DemandIBusiness proxyDemandBu;
	@EJB
	private ReplyIBusiness proxyReplyBU;

	private List<Activity> activities;
	private List<ActivityCategory> categories;
	private List<EquipmentType> equipments;
	private List<City> cities;
	private List<Demand> demands = new ArrayList<>();
	private List<SelectItem> cBoxCategories = new ArrayList<>();
	private Reply reply;
	private Research research;

	/*
	 * 	Initialisation standard dans le cas où aucun critère de recherche n'est définis
	 */
	@PostConstruct
	public void init() {
		if(research == null) {
			standardInit();
		}
	}

	/*
	 * 	Méthode permettant de lancer une initialisation standard des champs de recherches et des demandes sans critères définis
	 */
	private void standardInit() {
		demands = proxyDemandBu.getNotOwnedDemands(sessionUser.getId());
		equipments = proxyDemandBu.displayEquipments();
		cities = proxyDemandBu.displayCities();
		research = new Research();
		createActivitiesSelectCBox();
	}

	public String getDemandStatus(Demand demand) {
		return proxyDemandBu.displayDemandStatus(demand, sessionUser.getId());
	}
	
	/*
	 * 	Méthode permettant de créer l'arborescence de la SelectCheckBox des activités
	 */
	private void createActivitiesSelectCBox() {

		activities = proxyDemandBu.displayActivities();
		categories = proxyDemandBu.displayCategories();

		for(ActivityCategory cat : categories){

			SelectItemGroup selectItemGroup = new SelectItemGroup(cat.getLabel());
			SelectItem[] selectItems = null;
			List<SelectItem> tempList = new ArrayList<SelectItem>();

			for (Activity act : activities) {
				if(act.getActivityCategory().getId() == cat.getId()) { //Regroupage par catégorie : Si la catégorie d'activité d'une activité est egale à la categorie en cours alors on rajoute cette activité au menu déroulant 
					tempList.add(new SelectItem(act, act.getLabel()));
				}
			}

			selectItems = new SelectItem[tempList.size()];  //Transférer les données de la liste temporaire à notre tableau d'objet (contrainte de la taille fixe du tableau)

			for (int i = 0; i < tempList.size(); i++) {
				selectItems[i] = tempList.get(i);
			}

			selectItemGroup.setSelectItems(selectItems);
			cBoxCategories.add(selectItemGroup);
		}
	}

	public void replyDemand(Demand demand) {
		reply = new Reply(null, LocalDateTime.now(), null, null, null, sessionUser, demand);
		reply = proxyReplyBU.createReply(reply);
		reply = new Reply();
	}

	/*
	 * 	Méthode actualisant la liste de demande en fonction des critères de recherches et l'affichant ensuite à l'utilisateur
	 */
	public void sendResearch() {
		demands = proxyDemandBu.getDemandsByResearch(research, demands);
	}

	/*
	 * 	Méthode annulant l'ensemble des critères de recherche et actualisant la liste de demandes à l'écran
	 */
	public void cancelResearch(){
		research = new Research();
		updateResearchFields();
		demands = proxyDemandBu.getNotOwnedDemands(sessionUser.getId());
	}

	/*
	 * 	Mets à jour la barre de recherche de manière asynchrone
	 */
	@SuppressWarnings("serial")
	private void updateResearchFields() {
		PartialViewContext partialViewContext = FacesContext.getCurrentInstance().getPartialViewContext();
		partialViewContext.getRenderIds().addAll(new ArrayList<String>() {{
			add("researchForm:equipResearchCBox");
			add("researchForm:citiesResearchCBox");
			add("researchForm:dateResearchPicker");
			add("researchForm:startTimeResearchPicker");
			add("researchForm:endTimeResearchPicker");
			add("researchForm:activityResearchCBox");
			add("researchForm:equipResearchCBox");
		}});
	}

	//getter setters
	public List<SelectItem> getcBoxCategories() {
		return cBoxCategories;
	}

	public void setcBoxCategories(List<SelectItem> cBoxCategories) {
		this.cBoxCategories = cBoxCategories;
	}

	public List<Demand> getDemands() {
		return demands;
	}

	public void setDemands(List<Demand> demands) {
		this.demands = demands;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public List<EquipmentType> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<EquipmentType> equipments) {
		this.equipments = equipments;
	}

	public List<ActivityCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<ActivityCategory> categories) {
		this.categories = categories;
	}

	public List<City> getCities() {
		return cities;
	}

	public User getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(User sessionUser) {
		this.sessionUser = sessionUser;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public Research getResearch() {
		return research;
	}

	public void setResearch(Research research) {
		this.research = research;
	}
}
