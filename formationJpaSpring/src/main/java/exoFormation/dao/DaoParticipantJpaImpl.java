package exoFormation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import exoFormation.entity.Participant;
import exoFormation.util.JpaContext;

public class DaoParticipantJpaImpl implements DaoParticipant {

	@Override
	public void insert(Participant obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Participant update(Participant obj) {
		Participant participant = null;
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		participant = em.merge(obj);
		tx.commit();
		em.close();
		return participant;
	}

	@Override
	public void delete(Participant obj) {
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
		em.remove(em.find(Participant.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Participant findByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Participant participant = null;
		participant = em.find(Participant.class, key);
		em.close();
		return participant;
	}

	@Override
	public List<Participant> findAll() {
		List<Participant> participants = null;
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Participant> query = em.createQuery("from Participant", Participant.class);
		participants = query.getResultList();
		em.close();
		return participants;
	}

}
