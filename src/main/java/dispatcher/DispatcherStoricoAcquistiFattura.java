package dispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementazione.OrdineImplementazioneDAO;
import sessione.*;
import bean.UtenteBean;

@WebServlet("/DispatcherStoricoAcquistiFattura")
public class DispatcherStoricoAcquistiFattura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherStoricoAcquistiFattura() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrdineImplementazioneDAO orimp = new OrdineImplementazioneDAO();
		UtenteBean ut = new UtenteBean();
		Session session = new Session();
		ut.setEmail(session.getEmail(request));
		request.setAttribute("list", orimp.leggiOrdine(ut));
		request.getRequestDispatcher("/WEB-INF/fattura.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
