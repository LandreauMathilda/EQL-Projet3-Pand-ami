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

import fr.eql.ai108.pandami.entity.Demand;
import fr.eql.ai108.pandami.ibusiness.DemandIBusiness;

@ManagedBean (name="mbSearch")
@SessionScoped
public class SearchManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @EJB
    private DemandIBusiness proxyDemandBu;
    
    private List<Demand> demands = new ArrayList<>();

	private List<LocalDateTime> range;
	private LocalTime beginTime;
	private LocalTime endTime;
	
	private List<SelectItem> categories;
	private String[] selectedCategories;
	
	private String selectedMateriel;
	private Demand selectedDemand;
	
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
		
		demands = proxyDemandBu.getNotOwnedDemands(1); //User à récupérer en session!!!!!!!!!!
		
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

	public List<SelectItem> getCategories() {
		return categories;
	}

	public void setCategories(List<SelectItem> categories) {
		this.categories = categories;
	}

	public String[] getSelectedCategories() {
		return selectedCategories;
	}

	public void setSelectedCategories(String[] selectedCategories) {
		this.selectedCategories = selectedCategories;
	}

	public String getSelectedMateriel() {
		return selectedMateriel;
	}

	public void setSelectedMateriel(String selectedMateriel) {
		this.selectedMateriel = selectedMateriel;
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
}
