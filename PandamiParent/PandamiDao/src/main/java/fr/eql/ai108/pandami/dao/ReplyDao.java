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
	
	private final String PARAM_ID_USER = "paramIdUser";
	private final String PARAM_ID_DEMAND = "paramIdDemand";
	private final String PARAM_TODAY_DATE = "paramTodayDate";
	private final String GET_ALL_BY_USER_ID_QUERY = "SELECT r FROM Reply r WHERE r.volunteer.id = :" + PARAM_ID_USER
			  														   + " AND r.demand.actionDate >= :" + PARAM_TODAY_DATE
			  														   + " AND r.rejectDate IS NULL"
			  														   + " AND r.desistDate IS NULL"
			  														   + " ORDER BY r.replyDate DESC"; 

	private final String GET_ALL_BY_DEMAND_ID_QUERY = "SELECT r FROM Reply r WHERE r.demand.id = :" + PARAM_ID_DEMAND
			  															 + " AND r.demand.actionDate >= :" + PARAM_TODAY_DATE
			  															 + " AND r.rejectDate IS NULL"
			  															 + " AND r.desistDate IS NULL"
			  															 + " ORDER BY r.replyDate DESC";
	
	private final String GET_ALL_EXCEPT_SELECTED_BY_DEMAND_ID_QUERY = "SELECT r FROM Reply r WHERE r.demand.id = :" + PARAM_ID_DEMAND
			  																			 + " AND r.demand.actionDate >= :" + PARAM_TODAY_DATE
			  																			 + " AND r.rejectDate IS NULL"
			  																			 + " AND r.desistDate IS NULL"
			  																			 + " AND r.selectionDate IS NULL";
	
	private final String GET_ALL_ORDER_DESC_BY_USER_ID_QUERY = "SELECT r FROM Reply r WHERE r.volunteer.id = :" + PARAM_ID_USER
			  																	  + " AND r.demand.actionDate <= :" + PARAM_TODAY_DATE
			  																	  + " ORDER BY r.demand.actionDate DESC";
	
	@SuppressWarnings("unchecked")
	private List<Reply> genericQueryById (String jpqlQuery, Integer id, String paramId) {
		LocalDate today = LocalDate.now();
		Query query = em.createQuery(jpqlQuery); 
		query.setParameter(paramId, id); 
		query.setParameter(PARAM_TODAY_DATE, today);
		List<Reply> results = query.getResultList();
		return !results.isEmpty() ? results : null;
	}
	
	@Override
	public List<Reply> getAllByUser(Integer userId) {
		return genericQueryById(GET_ALL_BY_USER_ID_QUERY, userId, PARAM_ID_USER);
	}
	
	@Override
	public List<Reply> getAllByDemandId(Integer demandId) {
		return genericQueryById(GET_ALL_BY_DEMAND_ID_QUERY, demandId, PARAM_ID_DEMAND);
	}

	@Override
	public List<Reply> getAllExceptSelectedByDemandId(Integer demandId) {
		return genericQueryById(GET_ALL_EXCEPT_SELECTED_BY_DEMAND_ID_QUERY, demandId, PARAM_ID_DEMAND);
	}
	
	@Override
	public List<Reply> getAllPastRepliesByUser(Integer userId) {
		return genericQueryById(GET_ALL_ORDER_DESC_BY_USER_ID_QUERY, userId, PARAM_ID_USER);
	}
}