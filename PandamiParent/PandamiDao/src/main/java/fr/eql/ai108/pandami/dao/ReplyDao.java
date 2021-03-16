package fr.eql.ai108.pandami.dao;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.eql.ai108.pandami.entity.Reply;
import fr.eql.ai108.pandami.idao.ReplyIDao;

@Remote(ReplyIDao.class)
@Stateless
public class ReplyDao extends GenericDao<Reply> implements ReplyIDao {

	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Reply> getAllByUser(Integer id) {
		LocalDate today = LocalDate.now();
		Query query = em.createQuery("SELECT r FROM Reply r WHERE r.volunteer.id = :paramIdUser"
				+ " AND r.demand.actionDate >= :paramTodayDate AND r.rejectDate IS NULL"
				+ " AND r.desistDate IS NULL ORDER BY r.replyDate DESC"); 
		query.setParameter("paramIdUser", id); 
		query.setParameter("paramTodayDate", today);
		List<Reply> results = query.getResultList();
		return results.size() > 0 ? results : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reply> getAllByDemand(Integer demandId) {
		
		Query query = em.createQuery("SELECT r FROM Reply r WHERE r.demand.id = :paramDemandId");
		query.setParameter("paramDemandId", demandId);
		List<Reply> results = query.getResultList();
		return results.size() > 0 ? results : null;

	}
}
