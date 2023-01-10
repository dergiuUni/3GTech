package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UtenteBean;
import implementazione.UtenteImplementazioneDAO;
import sessione.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email"), password=request.getParameter("password");
		UtenteBean user=new UtenteBean();
		user.setEmail(email);
		user.setPassword(password);
	
		UtenteImplementazioneDAO op=new UtenteImplementazioneDAO();
		Session s=new Session();
		
		if(op.login(user)) {
			s.setUtenteSessionLogin(request,user);
			request.getRequestDispatcher("/index").forward(request, response);
		}
		else {
			s.destroySession(request);
			request.getRequestDispatcher("/DispatcherLoginServlet").forward(request, response);
		}
	}

}
