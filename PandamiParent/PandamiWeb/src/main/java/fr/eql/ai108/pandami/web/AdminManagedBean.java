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
	private ActivityCategory activityCategory;
	private List<ActivityCategory> categories;
	private CancelReason cancelReason;
	private List<CancelReason> cancelReasons;
	private City selectedCity;
	private List<City> cities;
	
	private String cityName;
	private String cityZipCode;
	
	private DesistReason desistReason;
	private List<DesistReason> desistReasons;
	private EndedType endedType;
	private List<EndedType> endedTypes;
	private EquipmentType equipmentType;
	private List<EquipmentType> equipmentTypes;
	private Gender gender;
	private List<Gender> genders;
	private ReportIssue reportIssue;
	private List<ReportIssue> reportIssues;
	private UserType userType;
	private List<UserType> userTypes;
	private String message;
	private List<Demand> demands;
	
	@EJB
	private AdminIBusiness proxyAdminBu;
	
	@EJB
	private DemandIBusiness proxyDemandBU;
	
	@PostConstruct
    public void init() {
		activities = proxyAdminBu.displayActivities();
		categories = proxyAdminBu.displayCategories();
		cancelReasons = proxyAdminBu.displayCancelReasons();
    	cities = proxyAdminBu.displayCities();
    	desistReasons = proxyAdminBu.displayDesistReasons();
    	endedTypes = proxyAdminBu.displayEndedTypes();
    	equipmentTypes = proxyAdminBu.displayEquipmentTypes();
    	genders = proxyAdminBu.displayGenders();
    	reportIssues = proxyAdminBu.displayReportIssues();
    	userTypes = proxyAdminBu.displayUserTypes();
    	demands = proxyDemandBU.displayAllDemands();
    }

	public String upDateCities() {
		System.out.println(selectedCity.toString());
		City returnedCity = proxyAdminBu.upDateCity(selectedCity);
		
		//cities = proxyAdminBu.displayCities();
		System.out.println(returnedCity.toString());
		message = "Villes bien mises à jour";
		System.out.println(message);
		return "/adminRef.xhtml?faces-redirect=true";
	}
	
	public String deleteCity() {
		City returnedCity = proxyAdminBu.deleteCity(selectedCity);
		message = returnedCity.toString() + " a bien été supprimée";
		System.out.println(message);
		return "/adminRef.xhtml?faces=redirect=true";
	}
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityZipCode() {
		return cityZipCode;
	}

	public void setCityZipCode(String cityZipCode) {
		this.cityZipCode = cityZipCode;
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
	public CancelReason getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(CancelReason cancelReason) {
		this.cancelReason = cancelReason;
	}
	
	public List<CancelReason> getCancelReasons() {
		return cancelReasons;
	}
	public void setCancelReasons(List<CancelReason> cancelReasons) {
		this.cancelReasons = cancelReasons;
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
	public DesistReason getDesistReason() {
		return desistReason;
	}
	public void setDesistReason(DesistReason desistReason) {
		this.desistReason = desistReason;
	}
	public List<DesistReason> getDesistReasons() {
		return desistReasons;
	}
	public void setDesistReasons(List<DesistReason> desistReasons) {
		this.desistReasons = desistReasons;
	}
	public EndedType getEndedType() {
		return endedType;
	}
	public void setEndedType(EndedType endedType) {
		this.endedType = endedType;
	}
	public List<EndedType> getEndedTypes() {
		return endedTypes;
	}
	public void setEndedTypes(List<EndedType> endedTypes) {
		this.endedTypes = endedTypes;
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
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public List<Gender> getGenders() {
		return genders;
	}
	public void setGenders(List<Gender> genders) {
		this.genders = genders;
	}
	public ReportIssue getReportIssue() {
		return reportIssue;
	}
	public void setReportIssue(ReportIssue reportIssue) {
		this.reportIssue = reportIssue;
	}
	public List<ReportIssue> getReportIssues() {
		return reportIssues;
	}
	public void setReportIssues(List<ReportIssue> reportIssues) {
		this.reportIssues = reportIssues;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public List<UserType> getUserTypes() {
		return userTypes;
	}
	public void setUserTypes(List<UserType> userTypes) {
		this.userTypes = userTypes;
	}

	public List<Demand> getDemands() {
		return demands;
	}

	public void setDemands(List<Demand> demands) {
		this.demands = demands;
	}
	
	
	
	
	
	
}
