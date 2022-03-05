package it.prova.gestionecani.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionecani.model.Cane;

@WebServlet("/PrepareInsertCaneServlet")
public class PrepareInsertCaneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// metto un bean 'vuoto' in request perché per la pagina risulta necessario
		request.setAttribute("insert_cane_attr", new Cane());
		request.getRequestDispatcher("/cane/insert.jsp").forward(request, response);

	}

}
