package fr.eql.ai108.pandami.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai108.pandami.entity.Activity;
import fr.eql.ai108.pandami.entity.ActivityCategory;
import fr.eql.ai108.pandami.entity.CancelReason;
import fr.eql.ai108.pandami.entity.City;
import fr.eql.ai108.pandami.entity.Demand;
import fr.eql.ai108.pandami.entity.DesistReason;
import fr.eql.ai108.pandami.entity.EndedType;
import fr.eql.ai108.pandami.entity.EquipmentType;
import fr.eql.ai108.pandami.entity.Gender;
import fr.eql.ai108.pandami.entity.ReportIssue;
import fr.eql.ai108.pandami.entity.User;
import fr.eql.ai108.pandami.entity.UserType;
import fr.eql.ai108.pandami.ibusiness.AdminIBusiness;
import fr.eql.ai108.pandami.ibusiness.DemandIBusiness;

@ManagedBean (name="mbAdmin")
@SessionScoped
public class AdminManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private User user = new User();
	
	private Activity activity;
	private List<Activity> activities;
	private Activity selectedActivity;
	private Activity newActivity = new Activity();
	
	private ActivityCategory activityCategory;
	private List<ActivityCategory> categories;
	private ActivityCategory selectedCategory;
	private ActivityCategory newCategory = new ActivityCategory();
	
	private City selectedCity;
	private List<City> cities;
	private City newCity = new City();
	
	private EquipmentType equipmentType; 
	private List<EquipmentType> equipmentTypes;
	private EquipmentType selectedEquipment;
	private EquipmentType newEquipment = new EquipmentType();
	
	private String activityLabel;
	private ActivityCategory categoryForActivity;
	private EquipmentType equipmentForActivity;
	
	private String message;
	
	@EJB
	private AdminIBusiness proxyAdminBu;
	
	
	@PostConstruct
    public void init() {
		activities = proxyAdminBu.displayActivities();
		categories = proxyAdminBu.displayCategories();
    	cities = proxyAdminBu.displayCities();
    	equipmentTypes = proxyAdminBu.displayEquipmentTypes();
    	
    }

	public String upDateCities() {
		proxyAdminBu.upDateCity(selectedCity);
		cities = proxyAdminBu.displayCities();
		return "/adminRef.xhtml?faces-redirect=true";
	}
	public String addCity() {
		proxyAdminBu.addCity(newCity);
		newCity = new City();
		cities = proxyAdminBu.displayCities();
		return "/adminRef.xhtml?faces-redirect=true";
	}
	
	public String upDateActivity() {
		proxyAdminBu.upDateActivity(selectedActivity);
		activities = proxyAdminBu.displayActivities();
		return "/adminRef.xhtml?faces-redirect=true";
	}
	
	public String addActivity() {
		newActivity = new Activity(null, activityLabel, categoryForActivity, equipmentForActivity);
		
		proxyAdminBu.addActivity(newActivity);
		newActivity = new Activity();
		activities = proxyAdminBu.displayActivities();
		return "/adminRef.xhtml?faces-redirect=true";
	}
	
	public String upDateCategory() {
		proxyAdminBu.upDateCategory(selectedCategory);
		System.out.println(selectedCategory.toString());
		categories = proxyAdminBu.displayCategories();
		return null;
	}

	public String addCategory() {
		proxyAdminBu.addCategory(newCategory);
		newCategory = new ActivityCategory();
		categories = proxyAdminBu.displayCategories();
		return null;
	}

	public String upDateEquipment() {
		proxyAdminBu.upDateEquipment(selectedEquipment);
		equipmentTypes = proxyAdminBu.displayEquipmentTypes();
		return "/adminRef.xhtml?faces-redirect=true";
	}
	public String addEquipment() {
		proxyAdminBu.addEquipment(newEquipment);
		newEquipment = new EquipmentType();
		equipmentTypes = proxyAdminBu.displayEquipmentTypes();
		return "/adminRef.xhtml?faces-redirect=true";
	}

	


	public String getActivityLabel() {
		return activityLabel;
	}

	public void setActivityLabel(String activityLabel) {
		this.activityLabel = activityLabel;
	}

	public ActivityCategory getCategoryForActivity() {
		return categoryForActivity;
	}

	public void setCategoryForActivity(ActivityCategory categoryForActivity) {
		this.categoryForActivity = categoryForActivity;
	}

	public EquipmentType getEquipmentForActivity() {
		return equipmentForActivity;
	}

	public void setEquipmentForActivity(EquipmentType equipmentForActivity) {
		this.equipmentForActivity = equipmentForActivity;
	}

	public Activity getNewActivity() {
		return newActivity;
	}

	public void setNewActivity(Activity newActivity) {
		this.newActivity = newActivity;
	}

	public AdminIBusiness getProxyAdminBu() {
		return proxyAdminBu;
	}

	public void setProxyAdminBu(AdminIBusiness proxyAdminBu) {
		this.proxyAdminBu = proxyAdminBu;
	}

	public Activity getSelectedActivity() {
		return selectedActivity;
	}

	public void setSelectedActivity(Activity selectedActivity) {
		this.selectedActivity = selectedActivity;
	}


	public ActivityCategory getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(ActivityCategory selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public ActivityCategory getNewCategory() {
		return newCategory;
	}

	public void setNewCategory(ActivityCategory newCategory) {
		this.newCategory = newCategory;
	}

	public EquipmentType getSelectedEquipment() {
		return selectedEquipment;
	}

	public void setSelectedEquipment(EquipmentType selectedEquipment) {
		this.selectedEquipment = selectedEquipment;
	}

	public EquipmentType getNewEquipment() {
		return newEquipment;
	}

	public void setNewEquipment(EquipmentType newEquipment) {
		this.newEquipment = newEquipment;
	}

	public City getNewCity() {
		return newCity;
	}

	public void setNewCity(City newCity) {
		this.newCity = newCity;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public List<Activity> getActivities() {
		return activities;
	}
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	public ActivityCategory getActivityCategory() {
		return activityCategory;
	}
	public void setActivityCategory(ActivityCategory activityCategory) {
		this.activityCategory = activityCategory;
	}
	public List<ActivityCategory> getCategories() {
		return categories;
	}
	public void setCategories(List<ActivityCategory> categories) {
		this.categories = categories;
	}

	public City getSelectedCity() {
		return selectedCity;
	}

	public void setSelectedCity(City selectedCity) {
		this.selectedCity = selectedCity;
	}

	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	public EquipmentType getEquipmentType() {
		return equipmentType;
	}
	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
	}
	public List<EquipmentType> getEquipmentTypes() {
		return equipmentTypes;
	}
	public void setEquipmentTypes(List<EquipmentType> equipmentTypes) {
		this.equipmentTypes = equipmentTypes;
	}
	
	
	
	
	
}
