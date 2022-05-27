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
			return (String)request.getSession().getAttribute("utente");
		}
	}
	
	public boolean setUtenteSessionLogin(HttpServletRequest request, UtenteBean utente) {
		UtenteImplementazioneDAO ut = new UtenteImplementazioneDAO();
		
		destroySession(request);
		
		if(request.getSession(false) == null) {
			request.getSession().setMaxInactiveInterval(5*60);
			if(ut.isAdmin(utente)) {
				request.getSession(true).setAttribute("utente", "ADMIN");
				return true;
			}
			else {
				if(ut.isCliente(utente)) {
					request.getSession().setAttribute("utente", "CLIENTE");
					return true;
				}
				else {
					request.getSession().setAttribute("utente", "OSPITE");
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
			if (request.getSession().getAttribute("utente") == "ADMIN") {
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
			if (request.getSession().getAttribute("utente") == "CLIENTE") {
				return false;
			}
			else {
				return true;
			}
		}
	}
	
	public boolean isSessionOspite(HttpServletRequest request) {
		if(request.getSession(false) == null) {
			return true;
		}
		else {
			if (request.getSession().getAttribute("utente") == "OSPITE") {
				return false;
			}
			else {
				return false;
			}
		}
	}
	
	public boolean destroySession(HttpServletRequest request) {
		if(request.getSession().getAttribute("utente")!=null) {
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