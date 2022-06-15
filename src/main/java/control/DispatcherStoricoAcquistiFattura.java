package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrdineBean;
import model.OrdineImplementazioneDAO;
import model.Session;
import model.UtenteBean;

/**
 * Servlet implementation class DispatcherStoricoAcquistiFattura
 */
@WebServlet("/DispatcherStoricoAcquistiFattura")
public class DispatcherStoricoAcquistiFattura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherStoricoAcquistiFattura() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrdineImplementazioneDAO orimp = new OrdineImplementazioneDAO();
		UtenteBean ut = new UtenteBean();
		Session session = new Session();
		
		ut.setEmail(session.getEmail(request));
		
		
		request.setAttribute("list", orimp.leggiOrdineArraylist(ut));
		request.getRequestDispatcher("/WEB-INF/fattura.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
