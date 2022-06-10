package model;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Session {
	HttpSession session;
	
	public Session() {}
	
	public String getUtenteSessionLogin(HttpServletRequest request) {
		if(request.getSession(false) == null) {
			return null;
		}
		else {
			return (String)request.getSession(false).getAttribute("utente");
		}
	}
	
	public boolean setUtenteSessionLogin(HttpServletRequest request, UtenteBean utente) {
		UtenteImplementazioneDAO ut = new UtenteImplementazioneDAO();
		
		destroySession(request);
		
		if(request.getSession(false) == null) {
			request.getSession().setMaxInactiveInterval(60*60);
			if(ut.isAdmin(utente)) {
				request.getSession(true).setAttribute("utente", "ADMIN");
				request.getSession().setAttribute("email", utente.getEmail());
				return true;
			}
			else {
				if(ut.isCliente(utente)) {
					request.getSession(true).setAttribute("utente", "CLIENTE");
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
		if(request.getSession(false) == null) {
			return false;
		}
		else {
			if (request.getSession(false).getAttribute("utente") == "ADMIN") {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public boolean isSessionCliente(HttpServletRequest request) {
		if(request.getSession(false) == null) {
			return false;
		}
		else {
			if (request.getSession(false).getAttribute("utente") == "CLIENTE") {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public boolean isSessionOspite(HttpServletRequest request) {
		if(request.getSession(false) == null) {
			return false;
		}
		else {
			if (request.getSession(false).getAttribute("utente") == "OSPITE") {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public boolean azzeraCarrello(HttpServletRequest request) {
		if(isSessionCliente(request) == true) {
			request.getSession().removeAttribute("carrello");
			return true;
		}
		return false;
	}
	
	public boolean inserisciCarrello(HttpServletRequest request, String carrello) {
		azzeraCarrello(request);
		if(isSessionCliente(request) == true) {
			request.getSession(true).setAttribute("carrello", carrello);
			return true;
		}
		return false;
	}
	
	public String leggiCarrello(HttpServletRequest request) {
		if(isSessionCliente(request) == true) {
			return (String) request.getSession(false).getAttribute("carrello");
		}
		return null;
	}
	
	public boolean isInizializzatoCarrello(HttpServletRequest request) {
		if((String)request.getSession(false).getAttribute("carrello") != null) {
			return true;
		}
		return false;
	}
	
	public boolean destroySession(HttpServletRequest request) {
		if(request.getSession(false).getAttribute("utente")!=null) {
			request.getSession(false).removeAttribute("carrello");
			request.getSession(false).removeAttribute("utente");
		}
		
		request.getSession(false).invalidate();
		
		if(request.getSession(false) == null) {
			return true;
		}
		else {
			return false;
		}
	}
}