package fr.eql.ai108.pandami.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eql.ai108.pandami.entity.ReportIssue;
import fr.eql.ai108.pandami.idao.ReportIssueIDao;

@Remote(ReportIssueIDao.class)
@Stateless
public class ReportIssueDao extends GenericDao<ReportIssue> implements ReportIssueIDao {

	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;
}
