package fr.eql.ai108.pandami.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eql.ai108.pandami.entity.CancelReason;
import fr.eql.ai108.pandami.idao.CancelReasonIDao;

@Remote(CancelReasonIDao.class)
@Stateless
public class CancelReasonDao extends GenericDao<CancelReason> implements CancelReasonIDao {
	
	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;
}
