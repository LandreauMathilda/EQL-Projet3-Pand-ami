package fr.eql.ai108.pandami.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eql.ai108.pandami.entity.Reply;
import fr.eql.ai108.pandami.idao.ReplyIDao;

@Remote(ReplyIDao.class)
@Stateless
public class ReplyDao extends GenericDao<Reply> implements ReplyIDao {

	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;
	
	private static final String PARAM_ID_USER = "paramIdUser";
	private static final String PARAM_ID_DEMAND = "paramIdDemand";
	
	private static final String QUERY_ONGOING_REPLIES = " AND r.demand.actionDate >= :paramTodayDate"
	   		  										  + " AND r.rejectDate IS NULL"
	   		  										  + " AND r.desistDate IS NULL";
	
	private static final String QUERY_GET_ALL_BY_USER_ID = "SELECT r FROM Reply r WHERE r.volunteer.id = :" + PARAM_ID_USER
			  														   		    + QUERY_ONGOING_REPLIES
			  														   		  + " ORDER BY r.replyDate DESC"; 

	private static final String QUERY_GET_ALL_BY_DEMAND_ID = "SELECT r FROM Reply r WHERE r.demand.id = :" + PARAM_ID_DEMAND
																				  + QUERY_ONGOING_REPLIES
			  															 		+ " ORDER BY r.replyDate DESC";
	
	private static final String QUERY_GET_ALL_EXCEPT_SELECTED_BY_DEMAND_ID = "SELECT r FROM Reply r WHERE r.demand.id = :" + PARAM_ID_DEMAND
																								  + QUERY_ONGOING_REPLIES
			  																			 		+ " AND r.selectionDate IS NULL";
	
	private static final String QUERY_GET_ALL_ORDER_DESC_BY_USER_ID = "SELECT r FROM Reply r WHERE r.volunteer.id = :" + PARAM_ID_USER
			  																	  		 + " AND r.demand.actionDate <= :paramTodayDate"
			  																	  		 + " ORDER BY r.demand.actionDate DESC";
	
	@Override
	public List<Reply> getAllByUser(Integer userId) {
		return genericQueryById(QUERY_GET_ALL_BY_USER_ID, userId, PARAM_ID_USER);
	}
	
	@Override
	public List<Reply> getAllByDemandId(Integer demandId) {
		return genericQueryById(QUERY_GET_ALL_BY_DEMAND_ID, demandId, PARAM_ID_DEMAND);
	}

	@Override
	public List<Reply> getAllExceptSelectedByDemandId(Integer demandId) {
		return genericQueryById(QUERY_GET_ALL_EXCEPT_SELECTED_BY_DEMAND_ID, demandId, PARAM_ID_DEMAND);
	}
	
	@Override
	public List<Reply> getAllPastRepliesByUser(Integer userId) {
		return genericQueryById(QUERY_GET_ALL_ORDER_DESC_BY_USER_ID, userId, PARAM_ID_USER);
	}
}