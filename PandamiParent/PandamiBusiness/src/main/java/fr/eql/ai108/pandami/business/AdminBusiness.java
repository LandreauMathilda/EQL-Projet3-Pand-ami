package fr.eql.ai108.pandami.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai108.pandami.entity.Activity;
import fr.eql.ai108.pandami.entity.ActivityCategory;
import fr.eql.ai108.pandami.entity.CancelReason;
import fr.eql.ai108.pandami.entity.City;
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
	private CityIDao proxyCity;
	@EJB
	private EquipmentTypeIDao proxyEquipmentType;
	@EJB
	private CancelReasonIDao proxyCancelReason;
	@EJB
	private GenderIDao proxyGender;
	@EJB 
	private EndedTypeIDao proxyEndedType;
	@EJB 
	private UserTypeIDao proxyUserType;
	@EJB 
	private ReportIssueIDao proxyReportIssue;
	@EJB
	private DesistReasonIDao proxyDesistReason;



	@Override
	public List<Activity> displayActivities() {
		return proxyActivity.findAll();
	}
	@Override
	public List<ActivityCategory> displayCategories() {
		return proxyActivityCategory.findAll();
	}

	@Override
	public List<City> displayCities() {
		return proxyCity.findAll();
	}
	@Override
	public List<EquipmentType> displayEquipmentTypes() {
		return proxyEquipmentType.findAll();
	}


	@Override
	public City upDateCity(City selectedCity) {
		return proxyCity.update(selectedCity);
	}

	@Override
	public City addCity(City selectedCity) {
		return proxyCity.add(selectedCity);
	}
	
	@Override
	public Activity upDateActivity(Activity selectedActivity) {
		return proxyActivity.update(selectedActivity);
	}
	
	@Override
	public Activity addActivity(Activity selectedActivity) {
		return proxyActivity.add(selectedActivity);
	}
	
	@Override
	public ActivityCategory upDateCategory(ActivityCategory selectedActivityCategory) {
		return proxyActivityCategory.update(selectedActivityCategory);
	}
	
	@Override
	public ActivityCategory addCategory(ActivityCategory selectedActivityCategory) {
		return proxyActivityCategory.add(selectedActivityCategory);
	}
	
	@Override
	public EquipmentType upDateEquipment(EquipmentType selectedEquipmentType) {
		return proxyEquipmentType.update(selectedEquipmentType);
	}
	
	@Override
	public EquipmentType addEquipment(EquipmentType selectedEquipmentType) {
		return proxyEquipmentType.add(selectedEquipmentType);
	}
	
	@Override
	public List<CancelReason> displayCancelReasons() {
		return proxyCancelReason.findAll();
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
}
