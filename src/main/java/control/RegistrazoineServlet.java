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
 * Servlet implementation class RegistrazoineServlet
 */
@WebServlet("/RegistrazoineServlet")
public class RegistrazoineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrazoineServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteBean user=new UtenteBean();
		String nome=request.getParameter("nome"), cognome=request.getParameter("cognome"), telefono=request.getParameter("telefono");
		String indirizzo=request.getParameter("indirizzo"), password=request.getParameter("password"), email=request.getParameter("email");
		user.setNome(nome);
		user.setCognome(cognome);
		user.setIndirizzo(indirizzo);
		user.setPassword(password);
		user.setEmail(email);
		
		UtenteImplementazioneDAO op=new UtenteImplementazioneDAO();
		op.inserisciUtente(user);
		response.sendRedirect("login/LoginHTML.html");
	}

}
