package exoFormation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import exoFormation.entity.Materiel;
import exoFormation.entity.Ordinateur;
import exoFormation.entity.VideoProjecteur;
import exoFormation.util.JpaContext;

public class DaoMaterielJpaImpl implements DaoMateriel {

	@Override
	public void insert(Materiel obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Materiel update(Materiel obj) {
		Materiel materiel = null;
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		materiel = em.merge(obj);
		tx.commit();
		em.close();
		return materiel;
	}

	@Override
	public void delete(Materiel obj) {
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
		em.remove(em.find(Materiel.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Materiel findByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Materiel materiel = null;
		materiel = em.find(Materiel.class, key);
		em.close();
		return materiel;
	}

	@Override
	public List<Materiel> findAll() {
		List<Materiel> materiels = null;
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Materiel> query = em.createQuery("from Materiel", Materiel.class);
		materiels = query.getResultList();
		em.close();
		return materiels;
	}

	@Override
	public List<Ordinateur> findAllOrdinateur() {
		List<Ordinateur> ordinateurs = null;
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Ordinateur> query = em.createQuery("from Ordinateur", Ordinateur.class);
		ordinateurs = query.getResultList();
		em.close();
		return ordinateurs;
	}

	@Override
	public List<VideoProjecteur> findAllVideoProjecteur() {
		List<VideoProjecteur> videos = null;
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<VideoProjecteur> query = em.createQuery("from VideoProjecteur", VideoProjecteur.class);
		videos = query.getResultList();
		em.close();
		return videos;
	}

}
