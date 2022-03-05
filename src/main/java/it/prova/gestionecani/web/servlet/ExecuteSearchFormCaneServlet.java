package it.prova.gestionecani.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionecani.model.Cane;
import it.prova.gestionecani.service.MyServiceFactory;
import it.prova.gestionecani.utility.UtilityCaneForm;


@WebServlet("/ExecuteSearchFormCaneServlet")
public class ExecuteSearchFormCaneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// estraggo input
		String nomeInputParam = request.getParameter("nome");
		String razzaInputParam = request.getParameter("razza");
		String pesoInputStringParam = request.getParameter("peso");
		String dataAdozioneStringParam = request.getParameter("dataAdozione");
		String etaInputParam = request.getParameter("eta");

		
		Cane caneInstance = UtilityCaneForm.createCaneFromParams(razzaInputParam, nomeInputParam, etaInputParam,
				dataAdozioneStringParam, pesoInputStringParam);

		try {
			request.setAttribute("listaCaniAttribute", MyServiceFactory.getCaneServiceInstance().findByExample(caneInstance));
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
