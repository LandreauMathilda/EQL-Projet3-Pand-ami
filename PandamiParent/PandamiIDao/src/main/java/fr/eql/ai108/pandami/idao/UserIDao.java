package fr.eql.ai108.pandami.idao;

import fr.eql.ai108.pandami.entity.User;

public interface UserIDao extends GenericIDao<User> {

	Boolean exist(User user);

}
