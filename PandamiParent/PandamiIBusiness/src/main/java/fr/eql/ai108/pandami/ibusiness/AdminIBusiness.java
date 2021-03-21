package fr.eql.ai108.pandami.ibusiness;

import java.util.List;

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

public interface AdminIBusiness {

	List<Activity> displayActivities();
	List<ActivityCategory> displayCategories();
	List<City> displayCities();
	List<EquipmentType> displayEquipmentTypes();
	List<CancelReason> displayCancelReasons();
	List<DesistReason> displayDesistReasons();
	List<EndedType> displayEndedTypes();
	List<Gender> displayGenders();
	List<ReportIssue> displayReportIssues();
	List<UserType> displayUserTypes();
	
	City upDateCity(City selectedCity);
	City addCity(City selectedCity);
	Activity upDateActivity(Activity selectedActivity);
	Activity addActivity(Activity selectedActivity);
	ActivityCategory upDateCategory(ActivityCategory selectedActivityCategory);
	ActivityCategory addCategory(ActivityCategory selectedActivityCategory);
	EquipmentType upDateEquipment(EquipmentType selectedEquipmentType);
	EquipmentType addEquipment(EquipmentType selectedEquipmentType);

}
	
