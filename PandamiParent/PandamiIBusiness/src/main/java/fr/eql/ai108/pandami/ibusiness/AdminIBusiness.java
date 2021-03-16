package fr.eql.ai108.pandami.ibusiness;

import java.util.List;

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

public interface AdminIBusiness {

	List<Activity> displayActivities();
	List<ActivityCategory> displayCategories();
	List<CancelReason> displayCancelReasons();
	List<City> displayCities();
	List<DesistReason> displayDesistReasons();
	List<EndedType> displayEndedTypes();
	List<EquipmentType> displayEquipmentTypes();
	List<Gender> displayGenders();
	List<ReportIssue> displayReportIssues();
	List<UserType> displayUserTypes();
	
	List<Activity> upDateActivities(List<Activity> activities);
	List<ActivityCategory> upDateDisplayCategories(List<ActivityCategory> activityCategiries);
	List<CancelReason> upDateDisplayCancelReasons(List<CancelReason> cancelReasons);
	List<City> upDateDisplayCities(List<City> cities);
	List<DesistReason> upDateDisplayDesistReasons(List<DesistReason> desistReasons);
	List<EndedType> upDateDisplayEndedTypes(List<EndedType> endedTypes);
	List<EquipmentType> upDateDisplayEquipmentTypes(List<EquipmentType> equipmentTypes);
	List<Gender> upDateDisplayGenders(List<Gender> genders);
	List<ReportIssue> upDateDisplayReportIssues(List<ReportIssue> reportIssues);
	List<UserType> upDateDisplayUserTypes(List<UserType> userTypes);
	City upDateCity(City selectedCity);
	City deleteCity(City selectedCity);
}
	
