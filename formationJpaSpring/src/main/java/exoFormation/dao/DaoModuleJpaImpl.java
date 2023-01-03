package exoFormation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import exoFormation.entity.Module;
import exoFormation.util.JpaContext;

public class DaoModuleJpaImpl implements DaoModule {

	@Override
	public void insert(Module obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Module update(Module obj) {
		Module module = null;
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		module = em.merge(obj);
		tx.commit();
		em.close();
		return module;
	}

	@Override
	public void delete(Module obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Module.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Module findByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Module module = null;
		module = em.find(Module.class, key);
		em.close();
		return module;
	}

	@Override
	public List<Module> findAll() {
		List<Module> modules = null;
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Module> query = em.createQuery("from Module", Module.class);
		modules = query.getResultList();
		em.close();
		return modules;
	}

}
