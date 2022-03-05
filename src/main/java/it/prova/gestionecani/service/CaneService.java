package it.prova.gestionecani.service;

import java.util.List;

import it.prova.gestionecani.dao.CaneDAO;
import it.prova.gestionecani.model.Cane;

public interface CaneService {
	// questo mi serve per injection
	public void setCaneDao(CaneDAO articoloDao);

	public List<Cane> listAll() throws Exception;

	public Cane caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Cane input) throws Exception;

	public void inserisciNuovo(Cane input) throws Exception;

	public void rimuovi(Cane input) throws Exception;

	public List<Cane> findByExample(Cane input) throws Exception;
}
