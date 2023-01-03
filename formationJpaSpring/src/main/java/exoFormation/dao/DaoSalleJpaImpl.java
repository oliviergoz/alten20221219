package exoFormation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import exoFormation.entity.Salle;
import exoFormation.util.JpaContext;

public class DaoSalleJpaImpl implements DaoSalle {

	@Override
	public void insert(Salle obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Salle update(Salle obj) {
		Salle salle = null;
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		salle = em.merge(obj);
		tx.commit();
		em.close();
		return salle;
	}

	@Override
	public void delete(Salle obj) {
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
		em.remove(em.find(Salle.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Salle findByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Salle salle = null;
		salle = em.find(Salle.class, key);
		em.close();
		return salle;
	}

	@Override
	public List<Salle> findAll() {
		List<Salle> salles = null;
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Salle> query = em.createQuery("from Salle", Salle.class);
		salles = query.getResultList();
		em.close();
		return salles;
	}

}
