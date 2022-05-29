package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TelefonoBEAN;
import model.TelefonoImplementatoDAO;
import model.UtenteBean;
import model.UtenteImplementazioneDAO;
import model.UtenteBean.categoria;
/**
 * Servlet implementation class RegistrazoineServlet
 */
@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrazioneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteBean user = new UtenteBean();
		UtenteImplementazioneDAO op = new UtenteImplementazioneDAO();
		TelefonoBEAN tel = new TelefonoBEAN();
		TelefonoImplementatoDAO telimp = new TelefonoImplementatoDAO();
		
		String nome = request.getParameter("nome"), cognome = request.getParameter("cognome"), telefono = request.getParameter("telefono");
		String indirizzo = request.getParameter("indirizzo"), password = request.getParameter("password"), email = request.getParameter("email");
		
		user.setNome(nome);
		user.setCognome(cognome);
		user.setIndirizzo(indirizzo);
		user.setPassword(password);
		user.setEmail(email);
		user.setTipo(categoria.user);
		tel.setNumero(telefono);
		tel.setUtente(user);
		
		op.inserisciUtente(user);
		telimp.aggiungiTelefono(tel);
		
		request.getRequestDispatcher("/DispatcherLoginServlet").forward(request, response);
	}

}
