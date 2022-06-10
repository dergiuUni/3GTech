package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProdottoImplementazioneDAO;
import model.UtenteBean;

/**
 * Servlet implementation class OrdiniUtente
 */
@WebServlet("/OrdiniUtente")
public class OrdiniUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteBean ut=new UtenteBean();
		ut.setEmail((String)request.getParameter("perEmail"));
		ProdottoImplementazioneDAO dao=new ProdottoImplementazioneDAO();
		String elenco=dao.selectOrdiniUtente(ut);
		request.setAttribute("elenco", elenco);
		request.getRequestDispatcher("/WEB-INF/elencoOrdiniADMIN.jsp").forward(request, response);
	}

}
