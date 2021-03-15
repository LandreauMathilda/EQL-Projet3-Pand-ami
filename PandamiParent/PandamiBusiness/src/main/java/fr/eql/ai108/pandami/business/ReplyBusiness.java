package fr.eql.ai108.pandami.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai108.pandami.entity.Reply;
import fr.eql.ai108.pandami.ibusiness.ReplyIBusiness;
import fr.eql.ai108.pandami.idao.ReplyIDao;

@Remote(ReplyIBusiness.class)
@Stateless
public class ReplyBusiness implements ReplyIBusiness {
	
	@EJB
	private ReplyIDao proxyReply;

	@Override
	public List<Reply> displayOwnedReplies(Integer id) {
		return proxyReply.getAllByUser(id);
	}

}
