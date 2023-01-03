package exoFormation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import exoFormation.entity.Formateur;
import exoFormation.util.JpaContext;

public class DaoFormateurJpaImpl implements DaoFormateur {

	@Override
	public void insert(Formateur obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Formateur update(Formateur obj) {
		Formateur formateur = null;
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		formateur = em.merge(obj);
		tx.commit();
		em.close();
		return formateur;
	}

	@Override
	public void delete(Formateur obj) {
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
		em.remove(em.find(Formateur.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Formateur findByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Formateur formateur = null;
		formateur = em.find(Formateur.class, key);
		em.close();
		return formateur;
	}

	@Override
	public List<Formateur> findAll() {
		List<Formateur> formateurs = null;
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Formateur> query = em.createQuery("from Formateur", Formateur.class);
		formateurs = query.getResultList();
		em.close();
		return formateurs;
	}

}
