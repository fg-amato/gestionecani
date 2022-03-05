package it.prova.gestionecani.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionecani.model.Cane;

public class CaneDAOImpl implements CaneDAO {
	private EntityManager entityManager;

	@Override
	public List<Cane> list() throws Exception {
		return entityManager.createQuery("from Cane", Cane.class).getResultList();
	}

	@Override
	public Cane findOne(Long id) throws Exception {
		return entityManager.find(Cane.class, id);
	}

	@Override
	public void update(Cane input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		input = entityManager.merge(input);
	}

	@Override
	public void insert(Cane input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Cane input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

}
