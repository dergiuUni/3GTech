package model;

public class TelefonoBEAN {
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
