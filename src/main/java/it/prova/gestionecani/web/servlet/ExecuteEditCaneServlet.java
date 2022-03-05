package it.prova.gestionecani.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionecani.model.Cane;
import it.prova.gestionecani.service.MyServiceFactory;
import it.prova.gestionecani.utility.UtilityCaneForm;


@WebServlet("/ExecuteEditCaneServlet")
public class ExecuteEditCaneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// estraggo input
		String nomeInputParam = request.getParameter("nome");
		String razzaInputParam = request.getParameter("razza");
		String pesoInputStringParam = request.getParameter("peso");
		String dataAdozioneStringParam = request.getParameter("dataAdozione");
		String etaInputParam = request.getParameter("eta");
		String idStringParam = request.getParameter("idCane");

		if (!NumberUtils.isCreatable(idStringParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		// preparo un bean (che mi serve sia per tornare in pagina
		// che per inserire) e faccio il binding dei parametri
		Cane caneInstance = UtilityCaneForm.createCaneFromParams(razzaInputParam, nomeInputParam, etaInputParam,
				dataAdozioneStringParam, pesoInputStringParam);
		Long idCaneDaAggiornare = Long.parseLong(idStringParam);
		caneInstance.setId(idCaneDaAggiornare);

		// se la validazione non risulta ok
		if (!UtilityCaneForm.validateCaneBean(caneInstance)) {
			request.setAttribute("insert_cane_attr", caneInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/cane/insert.jsp").forward(request, response);
			return;
		}

		try {
			MyServiceFactory.getCaneServiceInstance().aggiorna(caneInstance);
			request.setAttribute("listaCaniAttribute", MyServiceFactory.getCaneServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		request.getRequestDispatcher("/cane/results.jsp").forward(request, response);
	}

}
