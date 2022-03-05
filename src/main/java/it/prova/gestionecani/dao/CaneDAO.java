package it.prova.gestionecani.dao;

import java.util.List;

import it.prova.gestionecani.model.Cane;

public interface CaneDAO extends IBaseDAO<Cane> {

	public List<Cane> findByExample(Cane example) throws Exception;
}
