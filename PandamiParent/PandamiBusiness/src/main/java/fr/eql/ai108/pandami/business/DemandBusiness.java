package fr.eql.ai108.pandami.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai108.pandami.entity.Demand;
import fr.eql.ai108.pandami.entity.User;
import fr.eql.ai108.pandami.ibusiness.DemandIBusiness;
import fr.eql.ai108.pandami.idao.DemandIDao;

@Remote (DemandIBusiness.class)
@Stateless
public class DemandBusiness implements DemandIBusiness{

	@EJB
	private DemandIDao proxyDemand;

	@Override
	public Demand createDemand(Demand demand) {
		Demand returnedDemand = null;
		if (!proxyDemand.exist(demand)) {
			returnedDemand = proxyDemand.add(demand);
		}
		return returnedDemand;
	}
	


}
