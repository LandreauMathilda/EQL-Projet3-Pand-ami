package fr.eql.ai108.pandami.business;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai108.pandami.entity.Activity;
import fr.eql.ai108.pandami.entity.ActivityCategory;
import fr.eql.ai108.pandami.entity.City;
import fr.eql.ai108.pandami.entity.Demand;
import fr.eql.ai108.pandami.entity.EquipmentType;
import fr.eql.ai108.pandami.entity.Reply;
import fr.eql.ai108.pandami.entity.Research;
import fr.eql.ai108.pandami.ibusiness.DemandIBusiness;
import fr.eql.ai108.pandami.idao.ActivityCategoryIDao;
import fr.eql.ai108.pandami.idao.ActivityIDao;
import fr.eql.ai108.pandami.idao.CityIDao;
import fr.eql.ai108.pandami.idao.DemandIDao;
import fr.eql.ai108.pandami.idao.EquipmentTypeIDao;
import fr.eql.ai108.pandami.idao.ReplyIDao;

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
	@EJB
	private ReplyIDao proxyReply;

	@Override
	public Demand createDemand(Demand demand) {
		Demand returnedDemand = null;
		returnedDemand = proxyDemand.add(demand);
		return returnedDemand;
	}
	
	@Override
	public List<Demand> displayAllDemands(){
		return proxyDemand.findAll();
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

	@Override
	public String displayDemandStatus(Integer demandId, Integer userId) {

		List<Reply> replies = proxyReply.getAllByDemand(demandId);
		String status = "";
		
		if (replies.size() == 0) {
			status = "En recherche de volontaire";
		}else {

			for (Reply reply : replies) {
				
				if(reply.getVolunteer().getId() != userId ) {

					if((reply.getSelectionDate() != null) && (reply.getDesistDate() == null) && (reply.getRejectDate() == null)) {
						status = "Attribué à un autre utilisateur";
						break;
					}else {
						status = "En recherche de volontaire";
					}
				}

				if(reply.getVolunteer().getId() == userId) {

					if((reply.getSelectionDate() != null) && (reply.getDesistDate() == null) && (reply.getRejectDate() == null)) {
						status = "Vous a été attribué";
						break;
					}else if((reply.getSelectionDate() == null) && (reply.getDesistDate() == null) && (reply.getRejectDate() != null)) {
						status ="Attribué à un autre utilisateur";
						break;
					}else if((reply.getSelectionDate() == null) && (reply.getDesistDate() == null) && (reply.getRejectDate() == null)) {
						status ="Demande envoyée - en attente de validation";
						break;
					}
				}
			}	
		}
		return status;
	}	

	@Override
	public List<Demand> getDemandsByResearch(Research research, List<Demand> demands) {
		
		System.out.println(research);
		
		for (Demand demand : demands) {
			System.out.println(demand);
		}
		
		//Si au moins 1 critère de ville est sélectionné
		if(research.getCities().size() > 0 && demands.size() > 0) {
			
			for(int i = demands.size() - 1; i > -1; i--) {

				for (int j = research.getCities().size() - 1; j > -1; j--) {
					
					if(demands.get(i).getCity().getId() == research.getCities().get(j).getId()) {
						break;
					}else if(j == 0) {
						demands.remove(demands.get(i));
					}
				}
			}
		}
		
		//Si au moins 1 critère d'activité est sélectionné
		if(research.getActivities().size() > 0 && demands.size() > 0) {
			
			for(int i = demands.size() - 1; i > -1; i--) {

				for (int j = research.getActivities().size() - 1; j > -1; j--) {
					
					if(demands.get(i).getActivity().getId() == research.getActivities().get(j).getId()) {
						break;
					}else if(j == 0) {
						demands.remove(demands.get(i));
					}
				}
			}
		}
		
		//Si au moins 1 critère d'équipement sélectionné
		if(research.getEquipment() != null && demands.size() > 0) {

			for(int i = demands.size() - 1; i > -1; i--) {
				if(demands.get(i).getActivity().getEquipmentType().getId() != research.getEquipment().getId()) {
					demands.remove(demands.get(i));
				}
			}
		}
		
		//Si au moins 1 critère de date est défini
		if(research.getRangeDate() != null && demands.size() > 0) {
			
			LocalDate researchStartDate = research.getRangeDate().get(0);
			LocalDate researchEndDate = research.getRangeDate().get(1);

			for(int i = demands.size() - 1; i > -1; i--) {
				
				LocalDate actionDate = demands.get(i).getActionDate();

				if((actionDate.compareTo(researchStartDate) < 0) || (actionDate.compareTo(researchEndDate) > 0)) {
					demands.remove(demands.get(i));
				}
			}	
		}

		//Si au moins 1 critère de d'heure de début est défini
		if(research.getStartHour() != null && demands.size() > 0) {
			
			LocalTime researchStartHour = research.getStartHour();

			for(int i = demands.size() - 1; i > -1; i--) {
				
				LocalTime actionStartHour = demands.get(i).getStartHour();

				if(actionStartHour.compareTo(researchStartHour) < 0) {
					demands.remove(demands.get(i));
				}
			}	
		}
		
		//Si au moins 1 critère de d'heure de début est défini
		if(research.getEndHour() != null && demands.size() > 0) {
			
			LocalTime researchEndHour = research.getEndHour();

			for(int i = demands.size() - 1; i > -1; i--) {
				
				LocalTime actionEndHour = demands.get(i).getEndHour();

				if(actionEndHour.compareTo(researchEndHour) > 0) {
					demands.remove(demands.get(i));
				}
			}	
		}
		return demands;
	}

}
