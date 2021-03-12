package fr.eql.ai108.pandami.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai108.pandami.entity.Demand;
import fr.eql.ai108.pandami.idao.DemandIDao;

@Remote(DemandIDao.class)
@Stateless
public class DemandDao extends GenericDao<Demand> implements DemandIDao{
	
	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;

	@Override
	public Demand createDemand(Demand demand) {
		Query query = em.createQuery("INSERT d.actionDate = :paramActionD, d.startHour = :paramStartHour, d.endHour = :paramEndHour, d.street = :paramStreet, d.publishDate = :paramPublishD, d.cancelDate = :paramCancelD, d.closeDate = :paramCloseD, d.reportDate = :paramReportD INTO Demand d");
		query.setParameter("paramActionD", demand.getActionDate());
		query.setParameter("paramStartHour", demand.getStartHour());
		query.setParameter("paramEndHour", demand.getEndHour());
		query.setParameter("paramStreet", demand.getStreet());
		query.setParameter("paramPublishD", demand.getPublishDate());
		query.setParameter("paramCancelD", demand.getCancelDate());
		query.setParameter("paramCloseD", demand.getCloseDate());
		query.setParameter("paramReportD", demand.getReportDate());
		return demand;
	
	}



}
