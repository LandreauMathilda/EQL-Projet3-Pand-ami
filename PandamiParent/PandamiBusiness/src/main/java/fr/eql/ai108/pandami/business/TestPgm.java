package fr.eql.ai108.pandami.business;

import java.util.Date;

import fr.eql.ai108.pandami.entity.City;
import fr.eql.ai108.pandami.entity.Gender;
import fr.eql.ai108.pandami.entity.User;
import fr.eql.ai108.pandami.entity.UserType;

public class TestPgm {

	public static void main(String[] args) {
		City marseille = new City(2, "marseille", "13000");
		User tutu = new User(null, new UserType(2, "administrator"), "tutu", "tutu", new Gender(2, "feminin"), "1 rue du tutu", marseille, new Date(), "0101010101", "tutu@tutu.tutu", "titi", "titi", "0202020202", "titi", "titi", new Date());

		AccountBusiness ibusiness = new AccountBusiness();
		User tutuRecup = ibusiness.createAccount(tutu);

		System.out.println(tutuRecup.getName());

	}

}
