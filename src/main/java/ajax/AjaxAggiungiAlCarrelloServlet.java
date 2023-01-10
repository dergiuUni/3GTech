package ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carrello.*;

@WebServlet("/AjaxAggiungiAlCarrelloServlet")
public class AjaxAggiungiAlCarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxAggiungiAlCarrelloServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestioneCarrello carrello = new GestioneCarrello();
		carrello.incrementaQauntitaDiUno(request, Short.valueOf(request.getParameter("prodotto")));
		response.getWriter().write("aggiunto");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
