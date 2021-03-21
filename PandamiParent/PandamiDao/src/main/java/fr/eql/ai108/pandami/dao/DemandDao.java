package fr.eql.ai108.pandami.dao;

import java.time.LocalDate;
import java.util.List;

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

	private final String PARAM_ID_USER = "paramIdUser";
	private final String PARAM_TODAY_DATE = "paramTodayDate";

	@SuppressWarnings("unchecked")
	@Override
	public List<Demand> getAllNotOwnedById(Integer id) {
		LocalDate today = LocalDate.now();
		Query query = em.createQuery("SELECT d FROM Demand d WHERE d.user.id != :paramIdUser AND d.actionDate >= :paramTodayDate AND d.cancelDate IS NULL");
		query.setParameter(PARAM_ID_USER, id);
		query.setParameter(PARAM_TODAY_DATE, today);
		List<Demand> results = query.getResultList();
		return !results.isEmpty() ? results : null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Demand> getAllByUser(Integer id) {
		LocalDate today = LocalDate.now();
		Query query = em.createQuery("SELECT d FROM Demand d WHERE d.user.id = :paramIdUser AND d.actionDate >= :paramTodayDate AND d.cancelDate IS NULL ORDER BY d.publishDate DESC");
		query.setParameter(PARAM_ID_USER, id);
		query.setParameter(PARAM_TODAY_DATE, today);
		List<Demand> results = query.getResultList();
		return !results.isEmpty() ? results : null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Demand> getAllPastDemandsByUser(Integer id) {
		LocalDate today = LocalDate.now();
		Query query = em.createQuery("SELECT d FROM Demand d WHERE d.user.id = :paramIdUser AND d.actionDate <= :paramTodayDate ORDER BY d.publishDate DESC");
		query.setParameter(PARAM_ID_USER, id);
		query.setParameter(PARAM_TODAY_DATE, today);
		List<Demand> results = query.getResultList();
		return !results.isEmpty() ? results : null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Demand> getAllValidatedByUser(Integer id) {
		LocalDate today = LocalDate.now();
		Query query = em.createQuery("SELECT d FROM Demand d WHERE d.user.id = :paramIdUser AND"
															   + " d.actionDate >= :paramTodayDate AND"
															   + " d.closeDate IS NOT NULL AND"
															   + " d.cancelDate IS NULL"
															   + " ORDER BY d.publishDate DESC");
		query.setParameter(PARAM_ID_USER, id);
		query.setParameter(PARAM_TODAY_DATE, today);
		List<Demand> results = query.getResultList();
		return !results.isEmpty() ? results : null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Demand> getAllPendingValidationByUser(Integer id) {
		LocalDate today = LocalDate.now();
		Query query = em.createQuery("SELECT d FROM Demand d WHERE d.user.id = :paramIdUser AND"
															   + " d.actionDate >= :paramTodayDate AND"
															   + " d.closeDate IS NULL AND"
															   + " d.cancelDate IS NULL"
															   + " ORDER BY d.publishDate DESC");
		query.setParameter(PARAM_ID_USER, id);
		query.setParameter(PARAM_TODAY_DATE, today);
		List<Demand> results = query.getResultList();
		return !results.isEmpty() ? results : null;
	}
}
