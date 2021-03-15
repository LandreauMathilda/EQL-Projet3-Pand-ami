package fr.eql.ai108.pandami.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai108.pandami.entity.Activity;
import fr.eql.ai108.pandami.entity.ActivityCategory;
import fr.eql.ai108.pandami.entity.City;
import fr.eql.ai108.pandami.entity.Demand;
import fr.eql.ai108.pandami.entity.EquipmentType;
import fr.eql.ai108.pandami.ibusiness.DemandIBusiness;
import fr.eql.ai108.pandami.idao.ActivityCategoryIDao;
import fr.eql.ai108.pandami.idao.ActivityIDao;
import fr.eql.ai108.pandami.idao.CityIDao;
import fr.eql.ai108.pandami.idao.DemandIDao;
import fr.eql.ai108.pandami.idao.EquipmentTypeIDao;

@Remote (DemandIBusiness.class)
@Stateless
public class DemandBusiness implements DemandIBusiness{

	@EJB
	private DemandIDao proxyDemand;
	@EJB
	private CityIDao proxyCity;
	@EJB 
	private ActivityIDao proxyActivity;
	@EJB
	private ActivityCategoryIDao proxyActCategory;
	@EJB
	private EquipmentTypeIDao proxyEquipment;
	
	@Override
	public Demand createDemand(Demand demand) {
		Demand returnedDemand = null;
		returnedDemand = proxyDemand.add(demand);
		return returnedDemand;
	}

	@Override
	public List<Demand> getNotOwnedDemands(Integer id) {
		return proxyDemand.getAllNotOwnedById(id);
	}
	
	@Override
	public List<City> displayCities() {
		return proxyCity.findAll();
	}

	@Override
	public List<Activity> displayActivities() {
		return proxyActivity.findAll();
	}
	
	@Override
	public List<EquipmentType> displayEquipments() {
		return proxyEquipment.findAll();
	}
	
	@Override
	public List<ActivityCategory> displayCategories() {
		return proxyActCategory.findAll();
	}

	@Override
	public List<Demand> displayOwnedDemands(Integer id) {
		return proxyDemand.getAllByUser(id);
	}

	@Override
	public Demand upDateDemand(Demand demand) {
		Demand returnedDemand = proxyDemand.update(demand);
		return returnedDemand;
	}
}
