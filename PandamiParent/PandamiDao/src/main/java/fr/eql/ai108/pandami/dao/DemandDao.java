package fr.eql.ai108.pandami.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eql.ai108.pandami.entity.Demand;
import fr.eql.ai108.pandami.idao.DemandIDao;

@Remote(DemandIDao.class)
@Stateless
public class DemandDao extends GenericDao<Demand> implements DemandIDao{
	
	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;

	private static final String PARAM_ID_USER = "paramIdUser";

	private static final String QUERY_ONGOING_DEMANDS = " AND d.actionDate >= :paramTodayDate"
													  + " AND d.cancelDate IS NULL"
													  + " ORDER BY d.publishDate DESC";
	
	private static final String QUERY_GET_ALL_NOT_OWNED_BY_USER_ID = "SELECT d FROM Demand d WHERE d.user.id != :" + PARAM_ID_USER
																						   + QUERY_ONGOING_DEMANDS;
	
	private static final String QUERY_GET_ALL_BY_USER_ID = "SELECT d FROM Demand d WHERE d.user.id = :" + PARAM_ID_USER
																				 + QUERY_ONGOING_DEMANDS;
	
	private static final String QUERY_GET_ALL_PAST_BY_USER_ID = "SELECT d FROM Demand d WHERE d.user.id = :" + PARAM_ID_USER
																			   		+ " AND d.actionDate <= :paramTodayDate"
																			   		+ " ORDER BY d.publishDate DESC";

	private static final String QUERY_GET_ALL_VALIDATED_BY_USER_ID = "SELECT d FROM Demand d WHERE d.user.id = :paramIdUser"
																						 + " AND d.closeDate IS NOT NULL"
																						   + QUERY_ONGOING_DEMANDS;
	
	private static final String QUERY_GET_ALL_PENDING_VALIDATION_BY_USER_ID = "SELECT d FROM Demand d WHERE d.user.id = :paramIdUser"
																								  + " AND d.closeDate IS NULL"
			   																						+ QUERY_ONGOING_DEMANDS;

	@Override
	public List<Demand> getAllNotOwnedById(Integer id) {
		return genericQueryById(QUERY_GET_ALL_NOT_OWNED_BY_USER_ID, id, PARAM_ID_USER);
	}

	@Override
	public List<Demand> getAllByUser(Integer id) {
		return genericQueryById(QUERY_GET_ALL_BY_USER_ID, id, PARAM_ID_USER);
	}

	@Override
	public List<Demand> getAllPastDemandsByUser(Integer id) {
		return genericQueryById(QUERY_GET_ALL_PAST_BY_USER_ID, id, PARAM_ID_USER);
	}

	@Override
	public List<Demand> getAllValidatedByUser(Integer id) {
		return genericQueryById(QUERY_GET_ALL_VALIDATED_BY_USER_ID, id, PARAM_ID_USER);
	}

	@Override
	public List<Demand> getAllPendingValidationByUser(Integer id) {
		return genericQueryById(QUERY_GET_ALL_PENDING_VALIDATION_BY_USER_ID, id, PARAM_ID_USER);
	}
}
