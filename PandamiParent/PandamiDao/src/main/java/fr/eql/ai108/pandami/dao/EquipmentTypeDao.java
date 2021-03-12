package fr.eql.ai108.pandami.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eql.ai108.pandami.entity.EquipmentType;
import fr.eql.ai108.pandami.idao.EquipmentTypeIDao;

@Remote(EquipmentTypeIDao.class)
@Stateless
public class EquipmentTypeDao extends GenericDao<EquipmentType> implements EquipmentTypeIDao {

	@PersistenceContext(unitName = "PandamiPU")
	private EntityManager em;
}
