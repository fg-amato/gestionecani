package it.prova.gestionecani.service;

import it.prova.gestionecani.dao.CaneDAO;
import it.prova.gestionecani.dao.CaneDAOImpl;

public class MyServiceFactory {

	// implementiamo il singleton in modo da evitare
	// proliferazione di riferimenti
	private static CaneService CANE_SERVICE_INSTANCE = null;
	private static CaneDAO CANEDAO_INSTANCE = null;

	public static CaneService getCaneServiceInstance() {
		if (CANE_SERVICE_INSTANCE == null)
			CANE_SERVICE_INSTANCE = new CaneServiceImpl();

		if (CANEDAO_INSTANCE == null)
			CANEDAO_INSTANCE = new CaneDAOImpl();

		CANE_SERVICE_INSTANCE.setCaneDao(CANEDAO_INSTANCE);

		return CANE_SERVICE_INSTANCE;
	}

}
