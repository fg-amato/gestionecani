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

	@Override
	public List<Cane> findByExample(Cane example) throws Exception {
		if (example == null)
			throw new Exception("Problema valore in input");

		String query = "from cane c where 1=1 ";

		if (example.getNome() != null && !example.getNome().isEmpty()) {
			query += " and c.nome like '" + example.getNome() + "%' ";
		}

		if (example.getRazza() != null && !example.getRazza().isEmpty()) {
			query += " and c.razza like '" + example.getRazza() + "%' ";
		}

		if (example.getPeso() != null && example.getPeso() > 0) {
			query += " and c.peso > '" + example.getPeso() + "%'";
		}

		if (example.getEta() != null && example.getEta() > 0) {
			query += " and c.eta > '" + example.getEta() + "%'";
		}

		if (example.getDataAdozione() != null) {
			query += " and c.dataAdozione>='" + new java.sql.Date(example.getDataAdozione().getTime()) + "' ";
		}

		return entityManager.createQuery(query, Cane.class).getResultList();

	}

}
