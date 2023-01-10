package bean;

import java.io.Serializable;

public class TelefonoBEAN implements Serializable {
	private static final long serialVersionUID = 1L;
	private String numero;
	private UtenteBean utente;
	
	public TelefonoBEAN(String numero, UtenteBean utente) {
		this.numero = numero;
		this.utente = utente;
	}
	
	public TelefonoBEAN() {
	}
	
	public TelefonoBEAN(String numero) {
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public UtenteBean getUtente() {
		return utente;
	}
	
	public void setUtente(UtenteBean utente) {
		this.utente = utente;
	}
}
