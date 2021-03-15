package fr.eql.ai108.pandami.web;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import fr.eql.ai108.pandami.entity.Activity;
import fr.eql.ai108.pandami.entity.ActivityCategory;
import fr.eql.ai108.pandami.entity.City;
import fr.eql.ai108.pandami.entity.Demand;
import fr.eql.ai108.pandami.entity.EquipmentType;
import fr.eql.ai108.pandami.entity.User;
import fr.eql.ai108.pandami.ibusiness.AccountIBusiness;
import fr.eql.ai108.pandami.ibusiness.DemandIBusiness;

@ManagedBean(name="mbDemand")
@SessionScoped
public class DemandManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;	
	private Demand demand = new Demand();
    private List<City> cities;
    private List<Activity> activities;
    private List<ActivityCategory> activityCategories;
    private List<EquipmentType> equipments;
    private List<EquipmentType> equipmentTypes;
	private List<ActivityCategory> categories;
	private List<SelectItem> cBoxCategories = new ArrayList<>();
	private String selectedActivity;
	private EquipmentType selectedEquipment;
    private String message;
    
	@EJB
	private DemandIBusiness proxyDemandBu;
	
	@EJB
	private AccountIBusiness proxyAccountBu;
	
	private User sessionUser;
	
    @PostConstruct
    public void init() {
    	cities = proxyDemandBu.displayCities();
    	equipments = proxyDemandBu.displayEquipments();
    	sessionUser = proxyAccountBu.getUserById();
    	activities = proxyDemandBu.displayActivities();
    	categories = proxyDemandBu.displayCategories();
    	createActivitiesSelectCBox();
    }
    
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
    

	
    public String createDemand() {
    	demand.setPublishDate(LocalDateTime.now());
    	demand.setUser(sessionUser);
        demand = proxyDemandBu.createDemand(demand);
        demand = new Demand();
        message = "Votre demande a bien été prise en compte";
        return "/demandDeposit.xhtml?faces-redirect=true";
    }

    
    public String upDateDemand(Demand demand) {
    demand = proxyDemandBu.upDateDemand(demand);
    
    	return "/modifDemand.xhtml?faces-redirect=true";
    }


	public EquipmentType getSelectedEquipment() {
		return selectedEquipment;
	}

	public void setSelectedEquipment(EquipmentType selectedEquipment) {
		this.selectedEquipment = selectedEquipment;
	}

	public String getSelectedActivity() {
		return selectedActivity;
	}

	public void setSelectedActivity(String selectedActivity) {
		this.selectedActivity = selectedActivity;
	}

	public List<SelectItem> getcBoxCategories() {
		return cBoxCategories;
	}

	public void setcBoxCategories(List<SelectItem> cBoxCategories) {
		this.cBoxCategories = cBoxCategories;
	}

	public List<ActivityCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<ActivityCategory> categories) {
		this.categories = categories;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(User sessionUser) {
		this.sessionUser = sessionUser;
	}

	public Demand getDemand() {
		return demand;
	}

	public void setDemand(Demand demand) {
		this.demand = demand;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}


	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public List<ActivityCategory> getActivityCategories() {
		return activityCategories;
	}

	public void setActivityCategories(List<ActivityCategory> activityCategories) {
		this.activityCategories = activityCategories;
	}

	public List<EquipmentType> getEquipmentTypes() {
		return equipmentTypes;
	}

	public void setEquipmentTypes(List<EquipmentType> equipmentTypes) {
		this.equipmentTypes = equipmentTypes;
	}
    
	public List<EquipmentType> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<EquipmentType> equipments) {
		this.equipments = equipments;
	}
}
