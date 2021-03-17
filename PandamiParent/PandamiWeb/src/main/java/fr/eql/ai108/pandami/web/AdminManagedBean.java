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
	private ActivityCategory activityCategory;
	private CancelReason cancelReason;
	private City selectedCity;
	private String cityName;
	private String cityZipCode;
	private DesistReason desistReason;
	private EndedType endedType;
	private EquipmentType equipmentType;
	private Gender gender;
	private ReportIssue reportIssue;
	private UserType userType;
	private String message;
	private String activityLabel;
	private ActivityCategory categoryForActivity;
	private EquipmentType equipmentForActivity;
	private EquipmentType selectedEquipment;
	private Activity selectedActivity;
	private ActivityCategory selectedCategory;
	private ActivityCategory newCategory = new ActivityCategory();
	private City newCity = new City();
	private Demand selectedDemand = new Demand();
	private Activity newActivity = new Activity();
	private EquipmentType newEquipment = new EquipmentType();
	
	private List<Activity> activities;
	private List<ActivityCategory> categories;
	private List<CancelReason> cancelReasons;
	private List<City> cities;
	private List<DesistReason> desistReasons;	
	private List<EndedType> endedTypes;
	private List<EquipmentType> equipmentTypes;
	private List<Gender> genders;
	private List<ReportIssue> reportIssues;
	private List<UserType> userTypes;
	private List<Demand> demands;
	
	@EJB
	private AdminIBusiness proxyAdminBu;
	
	@EJB
	private DemandIBusiness proxyDemandBU;
	
	@PostConstruct
    public void init() {
		activities = proxyAdminBu.displayActivities();
		categories = proxyAdminBu.displayCategories();
    	cities = proxyAdminBu.displayCities();
    	equipmentTypes = proxyAdminBu.displayEquipmentTypes();
    	demands = proxyDemandBU.displayAllDemands();
		cancelReasons = proxyAdminBu.displayCancelReasons();
    	desistReasons = proxyAdminBu.displayDesistReasons();
    	endedTypes = proxyAdminBu.displayEndedTypes();
    	genders = proxyAdminBu.displayGenders();
    	reportIssues = proxyAdminBu.displayReportIssues();
    	userTypes = proxyAdminBu.displayUserTypes();
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

	public User getUser() {
		return user;
	}

	public Activity getActivity() {
		return activity;
	}

	public ActivityCategory getActivityCategory() {
		return activityCategory;
	}

	public CancelReason getCancelReason() {
		return cancelReason;
	}

	public City getSelectedCity() {
		return selectedCity;
	}

	public String getCityName() {
		return cityName;
	}

	public String getCityZipCode() {
		return cityZipCode;
	}

	public DesistReason getDesistReason() {
		return desistReason;
	}

	public EndedType getEndedType() {
		return endedType;
	}

	public EquipmentType getEquipmentType() {
		return equipmentType;
	}

	public Gender getGender() {
		return gender;
	}

	public ReportIssue getReportIssue() {
		return reportIssue;
	}

	public UserType getUserType() {
		return userType;
	}

	public String getMessage() {
		return message;
	}

	public String getActivityLabel() {
		return activityLabel;
	}

	public ActivityCategory getCategoryForActivity() {
		return categoryForActivity;
	}

	public EquipmentType getEquipmentForActivity() {
		return equipmentForActivity;
	}

	public Demand getSelectedDemand() {
		return selectedDemand;
	}

	public Activity getNewActivity() {
		return newActivity;
	}

	public ActivityCategory getSelectedCategory() {
		return selectedCategory;
	}

	public ActivityCategory getNewCategory() {
		return newCategory;
	}

	public City getNewCity() {
		return newCity;
	}

	public EquipmentType getSelectedEquipment() {
		return selectedEquipment;
	}

	public EquipmentType getNewEquipment() {
		return newEquipment;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public List<ActivityCategory> getCategories() {
		return categories;
	}

	public List<CancelReason> getCancelReasons() {
		return cancelReasons;
	}

	public List<City> getCities() {
		return cities;
	}

	public List<DesistReason> getDesistReasons() {
		return desistReasons;
	}

	public List<EndedType> getEndedTypes() {
		return endedTypes;
	}

	public List<EquipmentType> getEquipmentTypes() {
		return equipmentTypes;
	}

	public List<Gender> getGenders() {
		return genders;
	}

	public List<ReportIssue> getReportIssues() {
		return reportIssues;
	}

	public List<UserType> getUserTypes() {
		return userTypes;
	}

	public List<Demand> getDemands() {
		return demands;
	}

	public AdminIBusiness getProxyAdminBu() {
		return proxyAdminBu;
	}

	public DemandIBusiness getProxyDemandBU() {
		return proxyDemandBU;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public void setActivityCategory(ActivityCategory activityCategory) {
		this.activityCategory = activityCategory;
	}

	public void setCancelReason(CancelReason cancelReason) {
		this.cancelReason = cancelReason;
	}

	public void setSelectedCity(City selectedCity) {
		this.selectedCity = selectedCity;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setCityZipCode(String cityZipCode) {
		this.cityZipCode = cityZipCode;
	}

	public void setDesistReason(DesistReason desistReason) {
		this.desistReason = desistReason;
	}

	public void setEndedType(EndedType endedType) {
		this.endedType = endedType;
	}

	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setReportIssue(ReportIssue reportIssue) {
		this.reportIssue = reportIssue;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setActivityLabel(String activityLabel) {
		this.activityLabel = activityLabel;
	}

	public void setCategoryForActivity(ActivityCategory categoryForActivity) {
		this.categoryForActivity = categoryForActivity;
	}

	public void setEquipmentForActivity(EquipmentType equipmentForActivity) {
		this.equipmentForActivity = equipmentForActivity;
	}

	public void setSelectedDemand(Demand selectedDemand) {
		this.selectedDemand = selectedDemand;
	}

	public void setNewActivity(Activity newActivity) {
		this.newActivity = newActivity;
	}

	public void setSelectedCategory(ActivityCategory selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public void setNewCategory(ActivityCategory newCategory) {
		this.newCategory = newCategory;
	}

	public void setNewCity(City newCity) {
		this.newCity = newCity;
	}

	public void setSelectedEquipment(EquipmentType selectedEquipment) {
		this.selectedEquipment = selectedEquipment;
	}

	public void setNewEquipment(EquipmentType newEquipment) {
		this.newEquipment = newEquipment;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public void setCategories(List<ActivityCategory> categories) {
		this.categories = categories;
	}

	public void setCancelReasons(List<CancelReason> cancelReasons) {
		this.cancelReasons = cancelReasons;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public void setDesistReasons(List<DesistReason> desistReasons) {
		this.desistReasons = desistReasons;
	}

	public void setEndedTypes(List<EndedType> endedTypes) {
		this.endedTypes = endedTypes;
	}

	public void setEquipmentTypes(List<EquipmentType> equipmentTypes) {
		this.equipmentTypes = equipmentTypes;
	}

	public void setGenders(List<Gender> genders) {
		this.genders = genders;
	}

	public void setReportIssues(List<ReportIssue> reportIssues) {
		this.reportIssues = reportIssues;
	}

	public void setUserTypes(List<UserType> userTypes) {
		this.userTypes = userTypes;
	}

	public void setDemands(List<Demand> demands) {
		this.demands = demands;
	}

	public void setProxyAdminBu(AdminIBusiness proxyAdminBu) {
		this.proxyAdminBu = proxyAdminBu;
	}

	public void setProxyDemandBU(DemandIBusiness proxyDemandBU) {
		this.proxyDemandBU = proxyDemandBU;
	}

	public Activity getSelectedActivity() {
		return selectedActivity;
	}

	public void setSelectedActivity(Activity selectedActivity) {
		this.selectedActivity = selectedActivity;
	}
}
