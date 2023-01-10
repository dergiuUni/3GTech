package dispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carrello.*;
import sessione.*;

@WebServlet("/DispatcherCarrelloServlet")
public class DispatcherCarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherCarrelloServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestioneCarrello carrello = new GestioneCarrello();
		Session session = new Session();
		
		if(session.leggiCarrello(request) != null) {
			request.setAttribute("listaCarrello", carrello.leggi(request).toString());
		}
		else {
			request.setAttribute("listaCarrello", "[]");
		}
		request.getRequestDispatcher("/WEB-INF/carrello.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
