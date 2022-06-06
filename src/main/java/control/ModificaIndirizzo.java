package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UtenteBean;
import model.UtenteImplementazioneDAO;

/**
 * Servlet implementation class ModificaIndirizzo
 */
@WebServlet("/ModificaIndirizzo")
public class ModificaIndirizzo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteBean ut=new UtenteBean();
		String email=(String)request.getSession().getAttribute("email");
		ut.setEmail(email);
		ut.setIndirizzo((String)request.getParameter("newIndirizzo"));
		UtenteImplementazioneDAO dao=new UtenteImplementazioneDAO();
		dao.modificaIndirizzo(ut);
		request.getRequestDispatcher("/DispatcherImpostazioni").forward(request, response);
	}

}
