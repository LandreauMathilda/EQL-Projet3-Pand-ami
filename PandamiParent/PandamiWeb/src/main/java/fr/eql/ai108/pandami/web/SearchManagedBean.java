package fr.eql.ai108.pandami.web;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import fr.eql.ai108.pandami.entity.Activity;
import fr.eql.ai108.pandami.entity.ActivityCategory;
import fr.eql.ai108.pandami.entity.Demand;
import fr.eql.ai108.pandami.entity.EquipmentType;
import fr.eql.ai108.pandami.ibusiness.DemandIBusiness;

@ManagedBean (name="mbSearch")
@SessionScoped
public class SearchManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private DemandIBusiness proxyDemandBu;

	private List<Activity> activities;
	private List<ActivityCategory> categories;
	private List<EquipmentType> equipments;
	private List<Demand> demands = new ArrayList<>();
	private List<LocalDateTime> range;
	private LocalTime beginTime;
	private LocalTime endTime;
	private List<SelectItem> cBoxCategories = new ArrayList<>();;
	private String[] selectedActivities;
	private EquipmentType selectedEquipment;
	private Demand selectedDemand;

	@PostConstruct
	public void init() {
		standardInit();
	}

	/*
	 * 	Méthode permettant de lancer une initialisation standard des champs de recherches et des demandes sans critères définis
	 */
	private void standardInit() {
		demands = proxyDemandBu.getNotOwnedDemands(1); //!!!!!!!!!!User à récupérer en session!!!!!!!!!!
		equipments = proxyDemandBu.displayEquipments();
		createActivitiesSelectCBox();
	}

	/*
	 * 	Méthode permettant de créer l'architecture de la SelectCheckBox des activités
	 */
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

	//getter setters
	public List<LocalDateTime> getRange() {
		return range;
	}

	public void setRange(List<LocalDateTime> range) {
		this.range = range;
	}

	public LocalTime getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(LocalTime beginTime) {
		this.beginTime = beginTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public List<SelectItem> getcBoxCategories() {
		return cBoxCategories;
	}

	public String[] getSelectedActivities() {
		return selectedActivities;
	}

	public void setcBoxCategories(List<SelectItem> cBoxCategories) {
		this.cBoxCategories = cBoxCategories;
	}

	public void setSelectedActivities(String[] selectedActivities) {
		this.selectedActivities = selectedActivities;
	}

	public List<Demand> getDemands() {
		return demands;
	}

	public void setDemands(List<Demand> demands) {
		this.demands = demands;
	}

	public Demand getSelectedDemand() {
		return selectedDemand;
	}

	public void setSelectedDemand(Demand selectedDemand) {
		this.selectedDemand = selectedDemand;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public List<EquipmentType> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<EquipmentType> equipments) {
		this.equipments = equipments;
	}

	public EquipmentType getSelectedEquipment() {
		return selectedEquipment;
	}

	public void setSelectedEquipment(EquipmentType selectedEquipment) {
		this.selectedEquipment = selectedEquipment;
	}

	public List<ActivityCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<ActivityCategory> categories) {
		this.categories = categories;
	}
}
