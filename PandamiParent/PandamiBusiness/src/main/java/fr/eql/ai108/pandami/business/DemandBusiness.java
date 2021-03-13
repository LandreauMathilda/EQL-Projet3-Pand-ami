package fr.eql.ai108.pandami.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai108.pandami.entity.Activity;
import fr.eql.ai108.pandami.entity.City;
import fr.eql.ai108.pandami.entity.Demand;
import fr.eql.ai108.pandami.ibusiness.DemandIBusiness;
import fr.eql.ai108.pandami.idao.ActivityIDao;
import fr.eql.ai108.pandami.idao.CityIDao;
import fr.eql.ai108.pandami.idao.DemandIDao;

@Remote (DemandIBusiness.class)
@Stateless
public class DemandBusiness implements DemandIBusiness{

	@EJB
	private DemandIDao proxyDemand;
	
	@EJB
	private CityIDao proxyCity;
	
	@EJB 
	private ActivityIDao proxyActivity;
	
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

}
