package fr.eql.ai108.pandami.dao;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai108.pandami.entity.Demand;
import fr.eql.ai108.pandami.entity.User;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Demand> getAllNotOwnedById(Integer id) {

		LocalDate today = LocalDate.now();
		
		Query query = em.createQuery("SELECT d FROM Demand d WHERE d.user.id != :paramIdUser AND d.actionDate >= :paramTodayDate AND d.cancelDate IS NULL");
		
		query.setParameter("paramIdUser", id);
		query.setParameter("paramTodayDate", today);
		List<Demand> results = query.getResultList();

		return results.size() > 0 ? results : null;
	}

}
