package exoFormation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import exoFormation.entity.Formation;
import exoFormation.util.JpaContext;

public class DaoFormationJpaImpl implements DaoFormation {

	@Override
	public void insert(Formation obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Formation update(Formation obj) {
		Formation formation = null;
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		formation = em.merge(obj);
		tx.commit();
		em.close();
		return formation;
	}

	@Override
	public void delete(Formation obj) {
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
		em.remove(em.find(Formation.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Formation findByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Formation formation = null;
		formation = em.find(Formation.class, key);
		em.close();
		return formation;
	}

	@Override
	public List<Formation> findAll() {
		List<Formation> formations = null;
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Formation> query = em.createQuery("from Formation", Formation.class);
		formations = query.getResultList();
		em.close();
		return formations;
	}

}
