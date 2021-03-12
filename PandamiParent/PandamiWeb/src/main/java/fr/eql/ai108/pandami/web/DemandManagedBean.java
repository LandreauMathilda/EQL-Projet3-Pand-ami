package fr.eql.ai108.pandami.web;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import fr.eql.ai108.pandami.entity.Activity;
import fr.eql.ai108.pandami.entity.Demand;
import fr.eql.ai108.pandami.entity.EquipmentType;
import fr.eql.ai108.pandami.ibusiness.DemandIBusiness;

@ManagedBean(name = "mbDemand")
@SessionScoped 

public class DemandManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	   private Demand demand = new Demand();
	    private String message;

		private LocalDate date;
		private LocalTime beginTime;
		private LocalTime endTime;
		
		private List<SelectItem> categories;
		private String selectedCategory;
		
		private List<Activity> activities;
		private String selectedActivity;
		
		private List<EquipmentType> equipments; 
		private String selectedEquipment;
		


	    @EJB
	    private DemandIBusiness proxyDemandBu;
	    
	    public String createDemand() {
	    	demand = proxyDemandBu.createDemand(demand);
	    	
	    	if (demand == null) {
	    		message = "Une demande identique est déjà enregistrée";
	    	}else {
	    		message = "Votre demande a bien été enregistrée";
	    	}
	    	demand = new Demand();
	    	
	    	return "/connectedHome.xhtml?faces-redirect=true";
	    }
	    
		@PostConstruct
		public void init() {
			
			categories = new ArrayList<>();
			SelectItemGroup livraison = new SelectItemGroup("Livraison de biens");
			livraison.setSelectItems(new SelectItem[] {
					new SelectItem("Livraisons de medicaments"),
					new SelectItem("courses essentielles")
			});
			
			SelectItemGroup divertissement = new SelectItemGroup("divertissement");
			divertissement.setSelectItems(new SelectItem[] {
					new SelectItem("compagnie"),
					new SelectItem("promenade")
			});
			
			categories.add(livraison);
			categories.add(divertissement);
		}
	    

		public LocalDate getDate() {
			return date;
		}

		public void setDate(LocalDate date) {
			this.date = date;
		}

		public String getSelectedCategory() {
			return selectedCategory;
		}

		public void setSelectedCategory(String selectedCategory) {
			this.selectedCategory = selectedCategory;
		}

		public List<Activity> getActivities() {
			return activities;
		}

		public void setActivities(List<Activity> activities) {
			this.activities = activities;
		}

		public String getSelectedActivity() {
			return selectedActivity;
		}

		public void setSelectedActivity(String selectedActivity) {
			this.selectedActivity = selectedActivity;
		}

		public List<EquipmentType> getEquipments() {
			return equipments;
		}

		public void setEquipments(List<EquipmentType> equipments) {
			this.equipments = equipments;
		}

		public String getSelectedEquipment() {
			return selectedEquipment;
		}

		public void setSelectedEquipment(String selectedEquipment) {
			this.selectedEquipment = selectedEquipment;
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

		public List<SelectItem> getCategories() {
			return categories;
		}

		public void setCategories(List<SelectItem> categories) {
			this.categories = categories;
		}


		public Demand getDemand() {
			return demand;
		}

		public void setDemand(Demand demand) {
			this.demand = demand;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	    
	    
}
