package fr.eql.ai108.pandami.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai108.pandami.entity.User;
import fr.eql.ai108.pandami.ibusiness.AccountIBusiness;
import fr.eql.ai108.pandami.idao.UserIDao;

@Remote (AccountIBusiness.class)
@Stateless
public class AccountBusiness implements AccountIBusiness{

	@EJB
	private UserIDao proxyUser;

	@Override
	public User createAccount(User user) {
		User returnedUser = null;
		if (!proxyUser.exist(user)) {
			returnedUser = proxyUser.add(user);
		}
		return returnedUser;
	}

}
