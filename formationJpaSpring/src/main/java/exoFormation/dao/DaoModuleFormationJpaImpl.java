package exoFormation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import exoFormation.entity.ModuleFormation;
import exoFormation.entity.ModuleFormationKey;
import exoFormation.util.JpaContext;

public class DaoModuleFormationJpaImpl implements DaoModuleFormation {

	@Override
	public void insert(ModuleFormation obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public ModuleFormation update(ModuleFormation obj) {
		ModuleFormation moduleFormation = null;
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		moduleFormation = em.merge(obj);
		tx.commit();
		em.close();
		return moduleFormation;
	}

	@Override
	public void delete(ModuleFormation obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(ModuleFormationKey key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(ModuleFormation.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public ModuleFormation findByKey(ModuleFormationKey key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		ModuleFormation moduleFormation = null;
		moduleFormation = em.find(ModuleFormation.class, key);
		em.close();
		return moduleFormation;
	}

	@Override
	public List<ModuleFormation> findAll() {
		List<ModuleFormation> moduleFormations = null;
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<ModuleFormation> query = em.createQuery("from ModuleFormation", ModuleFormation.class);
		moduleFormations = query.getResultList();
		em.close();
		return moduleFormations;
	}

}
