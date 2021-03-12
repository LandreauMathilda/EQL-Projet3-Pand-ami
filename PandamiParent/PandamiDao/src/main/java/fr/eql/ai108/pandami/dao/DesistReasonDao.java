package fr.eql.ai108.pandami.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eql.ai108.pandami.entity.DesistReason;
import fr.eql.ai108.pandami.idao.DesistReasonIDao;

@Remote(DesistReasonIDao.class)
@Stateless
public class DesistReasonDao extends GenericDao<DesistReason> implements DesistReasonIDao {

	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;
}
