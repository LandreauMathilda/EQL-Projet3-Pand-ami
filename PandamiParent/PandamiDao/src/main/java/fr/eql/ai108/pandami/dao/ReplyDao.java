package fr.eql.ai108.pandami.dao;

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
}
