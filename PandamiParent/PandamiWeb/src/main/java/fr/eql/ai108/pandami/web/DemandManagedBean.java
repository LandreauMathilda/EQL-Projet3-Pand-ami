package fr.eql.ai108.pandami.web;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
    }
    
    public String createDemand() {
    	demand.setPublishDate(LocalDateTime.now());
    	demand.setUser(sessionUser);
        demand = proxyDemandBu.createDemand(demand);
        demand = new Demand();
        message = "Votre demande a bien été prise en compte";
        return "/demandDeposit.xhtml?faces-redirect=true";
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
