package fr.eql.ai108.pandami.idao;

import java.util.List;

import fr.eql.ai108.pandami.entity.Reply;

public interface ReplyIDao extends GenericIDao<Reply> {
	
	List<Reply> getAllByUser(Integer id);
	
	List<Reply> getAllByDemand(Integer id);

}
