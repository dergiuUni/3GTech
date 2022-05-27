package model;

public class RecensioneBEAN {
	private int id;
	private String testo;
	private UtenteBean utente;
	private ProdottoBean prodotto;
	private int stelle;
	
	public RecensioneBEAN(int id, String testo, UtenteBean utente) {
		this.id = id;
		this.testo = testo;
		this.utente = utente;
	}
	public RecensioneBEAN() {
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTesto() {
		return testo;
	}
	
	public void setTesto(String testo) {
		this.testo = testo;
	}
	
	public UtenteBean getUtente() {
		return utente;
	}
	
	public void setUtente(UtenteBean utente) {
		this.utente = utente;
	}
	
	public ProdottoBean getProdotto() {
		return prodotto;
	}
	
	public void setProdotto(ProdottoBean prodotto) {
		this.prodotto = prodotto;
	}
	public int getStelle() {
		return stelle;
	}
	public void setStelle(int stelle) {
		if(stelle >= 0 && stelle <=5) {
			this.stelle = stelle;
		}
	}
}
