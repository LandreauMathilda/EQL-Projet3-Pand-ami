package fr.eql.ai108.pandami.ibusiness;

import java.util.List;

import fr.eql.ai108.pandami.entity.Reply;

public interface ReplyIBusiness {
	
	List<Reply> displayOwnedReplies(Integer id);
	Reply updateReply (Reply reply);
	Reply createReply(Reply reply);
	List<Reply> displayRepliesByDemandId(Integer id);
	List<Reply> getNotSelectedRepliesByDemandId(Integer id);
}
