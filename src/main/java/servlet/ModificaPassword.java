package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UtenteBean;
import implementazione.UtenteImplementazioneDAO;

@WebServlet("/ModificaPassword")
public class ModificaPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteBean ut=new UtenteBean();
		String email=(String)request.getSession().getAttribute("email");
		ut.setEmail(email);
		ut.setPassword((String)request.getParameter("newPassword"));
		System.out.println(ut.getPassword()+" "+ut.getEmail()); //per debugging
		UtenteImplementazioneDAO dao=new UtenteImplementazioneDAO();
		dao.modificaPassword(ut);
		request.getRequestDispatcher("/DispatcherImpostazioni").forward(request, response);
	}
}
