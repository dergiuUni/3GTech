package bean;

import java.io.Serializable;

public class PossiedeBEAN implements Serializable {
	private static final long serialVersionUID = 1L;
	private UtenteBean utente;
	private CartaBEAN carta;
	
	public UtenteBean getUtente() {
		return utente;
	}
	public void setUtente(UtenteBean utente) {
		this.utente = utente;
	}
	public CartaBEAN getCarta() {
		return carta;
	}
	public void setCarta(CartaBEAN carta) {
		this.carta = carta;
	}
	
	
}
