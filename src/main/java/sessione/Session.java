package sessione;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import implementazione.UtenteImplementazioneDAO;
import bean.UtenteBean;

public class Session {
	HttpSession session;
	
	public Session() {}
	
	public String getUtenteSessionLogin(HttpServletRequest request) {
		if(request.getSession() == null) {
			return null;
		}
		else {
			return (String)request.getSession().getAttribute("utente");
		}
	}
	
	public boolean setUtenteSessionLogin(HttpServletRequest request, UtenteBean utente) {
		UtenteImplementazioneDAO ut = new UtenteImplementazioneDAO();
		
		destroySession(request);
		
		if(request.getSession() == null) {
			request.getSession().setMaxInactiveInterval(60*60);
			if(ut.isAdmin(utente)) {
				request.getSession(true).setAttribute("utente", "ADMIN");
				//non stava nulla
				request.getSession().setAttribute("email", utente.getEmail());
				return true;
			}
			else {
				if(ut.isCliente(utente)) {
					request.getSession(true).setAttribute("utente", "CLIENTE");
					//non stava nulla
					request.getSession().setAttribute("email", utente.getEmail());
					return true;
				}
				else {
					request.getSession(true).setAttribute("utente", "OSPITE");
					request.getSession().setAttribute("email", utente.getEmail());
				}
			}
		}
		return false;
	}
	
	public boolean isSessionAdmin(HttpServletRequest request) {
		if(request.getSession() == null) {
			return false;
		}
		else {
			if (request.getSession().getAttribute("utente") == "ADMIN") {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public boolean isSessionCliente(HttpServletRequest request) {
		if(request.getSession() == null) {
			return false;
		}
		else {
			if (request.getSession().getAttribute("utente") == "CLIENTE") {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public boolean isSessionOspite(HttpServletRequest request) {
		if(request.getSession() == null) {
			return false;
		}
		else {
			if (request.getSession().getAttribute("utente") == "OSPITE") {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public boolean azzeraCarrello(HttpServletRequest request) {
		if(isSessionCliente(request) == true) {
			//non stava nulla ma dovrebbe essere false
			request.getSession().removeAttribute("carrello");
			return true;
		}
		return false;
	}
	
	public boolean inserisciCarrello(HttpServletRequest request, String carrello) {
		azzeraCarrello(request);
		if(isSessionCliente(request) == true) {
			//qua stava true non so se e sbagliato o meno controllo
			request.getSession().setAttribute("carrello", carrello);
			return true;
		}
		return false;
	}
	
	public String leggiCarrello(HttpServletRequest request) {
		if(isSessionCliente(request) == true) {
			return (String) request.getSession().getAttribute("carrello");
		}
		return null;
	}
	
	public boolean isInizializzatoCarrello(HttpServletRequest request) {
 		if((String)request.getSession().getAttribute("carrello") != null) {
			return true;
		}
		return false;
	}
	
	public boolean destroySession(HttpServletRequest request) {
		if(request.getSession().getAttribute("utente")!=null) {
			request.getSession().removeAttribute("carrello");
			request.getSession().removeAttribute("utente");
			request.getSession().removeAttribute("email");
		}
		
		request.getSession().invalidate();
		
		if(request.getSession() == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getEmail(HttpServletRequest request) {
		return (String)request.getSession().getAttribute("email");
	}
}