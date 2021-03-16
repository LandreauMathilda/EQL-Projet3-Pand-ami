package fr.eql.ai108.pandami.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

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
import fr.eql.ai108.pandami.entity.UserType;
import fr.eql.ai108.pandami.ibusiness.AdminIBusiness;
import fr.eql.ai108.pandami.idao.ActivityCategoryIDao;
import fr.eql.ai108.pandami.idao.ActivityIDao;
import fr.eql.ai108.pandami.idao.CancelReasonIDao;
import fr.eql.ai108.pandami.idao.CityIDao;
import fr.eql.ai108.pandami.idao.DesistReasonIDao;
import fr.eql.ai108.pandami.idao.EndedTypeIDao;
import fr.eql.ai108.pandami.idao.EquipmentTypeIDao;
import fr.eql.ai108.pandami.idao.GenderIDao;
import fr.eql.ai108.pandami.idao.ReportIssueIDao;
import fr.eql.ai108.pandami.idao.UserTypeIDao;

@Remote (AdminIBusiness.class)
@Stateless
public class AdminBusiness implements AdminIBusiness{
	
	@EJB 
	private ActivityIDao proxyActivity;
	@EJB
	private ActivityCategoryIDao proxyActivityCategory;
	@EJB
	private CancelReasonIDao proxyCancelReason;
	@EJB
	private CityIDao proxyCity;
	@EJB
	private DesistReasonIDao proxyDesistReason;
	@EJB 
	private EndedTypeIDao proxyEndedType;
	@EJB
	private EquipmentTypeIDao proxyEquipmentType;
	@EJB
	private GenderIDao proxyGender;
	@EJB 
	private ReportIssueIDao proxyReportIssue;
	@EJB 
	private UserTypeIDao proxyUserType;


	@Override
	public List<Activity> displayActivities() {
		return proxyActivity.findAll();
	}

	@Override
	public List<ActivityCategory> displayCategories() {
		return proxyActivityCategory.findAll();
	}

	@Override
	public List<CancelReason> displayCancelReasons() {
		return proxyCancelReason.findAll();
	}

	@Override
	public List<City> displayCities() {
		return proxyCity.findAll();
	}

	@Override
	public List<DesistReason> displayDesistReasons() {
		return proxyDesistReason.findAll();
	}

	@Override
	public List<EndedType> displayEndedTypes() {
		return proxyEndedType.findAll();
	}

	@Override
	public List<EquipmentType> displayEquipmentTypes() {
		return proxyEquipmentType.findAll();
	}

	@Override
	public List<Gender> displayGenders() {
		return proxyGender.findAll();
	}

	@Override
	public List<ReportIssue> displayReportIssues() {
		return proxyReportIssue.findAll();
	}

	@Override
	public List<UserType> displayUserTypes() {
		return proxyUserType.findAll();
	}

	@Override
	public List<Activity> upDateActivities(List<Activity> activities) {
	List<Activity> returnedActivities = new ArrayList<Activity>();
	returnedActivities = activities;
	for (Activity activity : returnedActivities) {
		  proxyActivity.add(activity);
	}
		 // 	Demand returnedDemand = proxyDemand.update(demand);
		
		return null;
	}

	@Override
	public List<ActivityCategory> upDateDisplayCategories(List<ActivityCategory> activityCategiries) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CancelReason> upDateDisplayCancelReasons(List<CancelReason> cancelReasons) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<City> upDateDisplayCities(List<City> cities) {
		List<City> returnedCities = new ArrayList<City>();
		
		for (City city : cities) {
			proxyCity.update(city);
			returnedCities.add(city);
		}
			
			return returnedCities;
	}

	@Override
	public List<DesistReason> upDateDisplayDesistReasons(List<DesistReason> desistReasons) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EndedType> upDateDisplayEndedTypes(List<EndedType> endedTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EquipmentType> upDateDisplayEquipmentTypes(List<EquipmentType> equipmentTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gender> upDateDisplayGenders(List<Gender> genders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReportIssue> upDateDisplayReportIssues(List<ReportIssue> reportIssues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserType> upDateDisplayUserTypes(List<UserType> userTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City upDateCity(City selectedCity) {
		City returnedCity = proxyCity.update(selectedCity);
		return returnedCity;
	}

	@Override
	public City deleteCity(City selectedCity) {
		City returnedCity = new City(selectedCity.getName(), selectedCity.getZipCode());
		proxyCity.delete(selectedCity);
		return returnedCity;
	}

	
}
