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


@WebServlet("/ExecuteDeleteCaneServlet")
public class ExecuteDeleteCaneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdCane = request.getParameter("idCane");

		if (!NumberUtils.isCreatable(parametroIdCane)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		Long idCane = Long.parseLong(parametroIdCane);

		try {
			Cane caneDaRimuovere = MyServiceFactory.getCaneServiceInstance().caricaSingoloElemento(idCane);

			MyServiceFactory.getCaneServiceInstance().rimuovi(caneDaRimuovere);

			request.setAttribute("listaCaniAttribute", MyServiceFactory.getCaneServiceInstance().listAll());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/cane/results.jsp").forward(request, response);
	}

}
