package fr.eql.ai108.pandami.web;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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


	private LocalTime startHourDemo;
	private LocalTime endHourDemo;
	private LocalDate actionDateDemo;
	private String streetDemo;
	private City cityDemo;
	private Activity activityDemo;
	private LocalDateTime publishDateDemo;
	private LocalDateTime cancelDateDemo;
	private LocalDateTime closeDateDemo;
	private LocalDateTime reportDateDemo;
	private EquipmentType equipmentDemo;
	private ActivityCategory categoryDemo;



	@EJB
	private DemandIBusiness proxyDemandBu;

	@EJB
	private AccountIBusiness proxyAccountBu;

	@ManagedProperty (value="#{mbConnect.sessionUser}")
	private User sessionUser;

	@PostConstruct
	public void init() {
		cities = proxyDemandBu.displayCities();
		equipments = proxyDemandBu.displayEquipments();
		activities = proxyDemandBu.displayActivities();
		categories = proxyDemandBu.displayCategories();
		createActivitiesSelectCBox();
		demand.setCity(sessionUser.getCity());
		demand.setStreet(sessionUser.getStreet());
		message = "";
	}

	private void createActivitiesSelectCBox() {

		activities = proxyDemandBu.displayActivities();
		categories = proxyDemandBu.displayCategories();

		for(ActivityCategory cat : categories){

			SelectItemGroup selectItemGroup = new SelectItemGroup(cat.getLabel());
			SelectItem[] selectItems = null;
			List<SelectItem> tempList = new ArrayList<SelectItem>();

			for (Activity act : activities) {
				if(act.getActivityCategory().getId().equals(cat.getId())) { //Regroupage par catégorie : Si la catégorie d'activité d'une activité est egale à la categorie en cours alors on rajoute cette activité au menu déroulant 
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

	public String redirect(Demand demand) {
		this.demand = demand;
		return "/modifDemand.xhtml?faces-redirect=true";
	}

	public String upDateDemand(Demand demand) {
		demand = proxyDemandBu.upDateDemand(demand);
		this.demand.setCity(sessionUser.getCity());
		message="Votre demande à bien été modifiée";
		return "/modifDemand.xhtml?faces-redirect=true";
	}

	public String setDemo() {
		startHourDemo = LocalTime.of(15, 30);
		endHourDemo = LocalTime.of(17, 00);
		actionDateDemo = LocalDate.of(2021, 05, 07);
		streetDemo = "58 rue de Kaerlide";
		cityDemo = new City(3, "Vincennes", "94300");
		equipmentDemo = new EquipmentType(1, "Aucun", null);
		categoryDemo = new ActivityCategory(1, "Service à Domicile");
		
		activityDemo = new Activity(2, "Accompagnement scolaire", categoryDemo, equipmentDemo);
		
		demand = new Demand(null, sessionUser, actionDateDemo, startHourDemo, endHourDemo, streetDemo, publishDateDemo, cancelDateDemo, closeDateDemo, reportDateDemo, null, cityDemo, activityDemo, null, null, null);


		return "demandDeposit.xhtml?faces-redirect=true";
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

	public LocalTime getStartHourDemo() {
		return startHourDemo;
	}

	public void setStartHourDemo(LocalTime startHourDemo) {
		this.startHourDemo = startHourDemo;
	}

	public LocalTime getEndHourDemo() {
		return endHourDemo;
	}

	public void setEndHourDemo(LocalTime endHourDemo) {
		this.endHourDemo = endHourDemo;
	}

	public LocalDate getActionDateDemo() {
		return actionDateDemo;
	}

	public void setActionDateDemo(LocalDate actionDateDemo) {
		this.actionDateDemo = actionDateDemo;
	}

	public String getStreetDemo() {
		return streetDemo;
	}

	public void setStreetDemo(String streetDemo) {
		this.streetDemo = streetDemo;
	}

	public City getCityDemo() {
		return cityDemo;
	}

	public void setCityDemo(City cityDemo) {
		this.cityDemo = cityDemo;
	}

	public Activity getActivityDemo() {
		return activityDemo;
	}

	public void setActivityDemo(Activity activityDemo) {
		this.activityDemo = activityDemo;
	}

	public LocalDateTime getPublishDateDemo() {
		return publishDateDemo;
	}

	public void setPublishDateDemo(LocalDateTime publishDateDemo) {
		this.publishDateDemo = publishDateDemo;
	}

	public LocalDateTime getCancelDateDemo() {
		return cancelDateDemo;
	}

	public void setCancelDateDemo(LocalDateTime cancelDateDemo) {
		this.cancelDateDemo = cancelDateDemo;
	}

	public LocalDateTime getCloseDateDemo() {
		return closeDateDemo;
	}

	public void setCloseDateDemo(LocalDateTime closeDateDemo) {
		this.closeDateDemo = closeDateDemo;
	}

	public LocalDateTime getReportDateDemo() {
		return reportDateDemo;
	}

	public void setReportDateDemo(LocalDateTime reportDateDemo) {
		this.reportDateDemo = reportDateDemo;
	}

	public EquipmentType getEquipmentDemo() {
		return equipmentDemo;
	}

	public void setEquipmentDemo(EquipmentType equipmentDemo) {
		this.equipmentDemo = equipmentDemo;
	}

	public ActivityCategory getCategoryDemo() {
		return categoryDemo;
	}

	public void setCategoryDemo(ActivityCategory categoryDemo) {
		this.categoryDemo = categoryDemo;
	}
	

}
