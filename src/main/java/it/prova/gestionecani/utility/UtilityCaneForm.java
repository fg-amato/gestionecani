package it.prova.gestionecani.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionecani.model.Cane;

public class UtilityCaneForm {

	public static Date parseDateArrivoFromString(String dataArrivoStringParam) {
		if (StringUtils.isBlank(dataArrivoStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataArrivoStringParam);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Cane createCaneFromParams(String razzaInputStringParam, String nomeInputStringParam,
			String etaInputStringParam, String dataArrivoStringParam, String pesoInputStringParam) {

		Cane result = new Cane(razzaInputStringParam, nomeInputStringParam);

		if (NumberUtils.isCreatable(etaInputStringParam)) {
			result.setEta(Integer.parseInt(etaInputStringParam));
		}

		if (NumberUtils.isCreatable(pesoInputStringParam)) {
			result.setPeso(Integer.parseInt(pesoInputStringParam));
		}

		result.setDataAdozione(parseDateArrivoFromString(dataArrivoStringParam));

		return result;
	}

	public static boolean validateCaneBean(Cane caneToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(caneToBeValidated.getNome()) || StringUtils.isBlank(caneToBeValidated.getRazza())
				|| caneToBeValidated.getEta() == null || caneToBeValidated.getEta() <= 0
				|| caneToBeValidated.getDataAdozione() == null || caneToBeValidated.getPeso() == null
				|| caneToBeValidated.getPeso() <= 0) {
			return false;
		}
		return true;
	}
}
