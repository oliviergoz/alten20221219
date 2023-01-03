package exoFormation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import exoFormation.entity.Formateur;

@Repository
public class DaoFormateurJpaImpl implements DaoFormateur {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insert(Formateur obj) {
		em.persist(obj);
	}

	@Override
	@Transactional
	public Formateur update(Formateur obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional
	public void delete(Formateur obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Formateur.class, key));
	}

	@Override
	public Formateur findByKey(Long key) {
		return em.find(Formateur.class, key);
	}

	@Override
	public List<Formateur> findAll() {
		return em.createQuery("from Formateur", Formateur.class).getResultList();
	}

}
