package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UtenteBean;
import implementazione.UtenteImplementazioneDAO;

@WebServlet("/ModificaEmail")
public class ModificaEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteBean ut=new UtenteBean();
		String email=(String)request.getSession().getAttribute("email");		
		ut.setEmail(email);
		ut.setIndirizzo((String)request.getParameter("newEmail")); //Uso il campo EMAIL del bean per salvare la nuova password
		UtenteImplementazioneDAO dao=new UtenteImplementazioneDAO();
		
		if(dao.modificaEmail(ut)) 
			request.getRequestDispatcher("/DispatcherImpostazioni").forward(request, response);
		else
			request.getRequestDispatcher("/DispatcherImpostazioniErrore").forward(request, response);
		
	}
}
