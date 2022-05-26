package MODEL;

import java.sql.Date;
import java.sql.Time;

public class OrdineBean {
	private int id;
	private Date dataOrdine;
	private Date dataConsegna;
	private Time orarioOrdine;
	private Time orarioConsegna;
	private ProdottoBean prodotto;
	private double prezzoProdotto;
    private int quantitaProdotto;
    private int ivaProdotto;
    private UtenteBean utente;
    private String indirizzo;
	
	public OrdineBean(int id, Date dataOrdine, Date dataConsegna, Time orarioOrdine, Time orarioConsegna, ProdottoBean prodotto, double prezzoProdotto, int quantitaProdotto, int ivaProdotto, String indirizzo, UtenteBean utente) {
		this.id = id;
		this.dataOrdine = dataOrdine;
		this.dataConsegna = dataConsegna;
		this.orarioOrdine = orarioOrdine;
		this.orarioConsegna = orarioConsegna;
		this.prodotto = prodotto;
		this.prezzoProdotto = prezzoProdotto ;
		this.quantitaProdotto = quantitaProdotto;
		this.ivaProdotto = ivaProdotto; 
		this.indirizzo = indirizzo; 
		this.utente = utente;
	}
	
	public OrdineBean(int id, Date dataOrdine, Time orarioOrdine, ProdottoBean prodotto, double prezzoProdotto, int quantitaProdotto, int ivaProdotto, String indirizzo) {
		this.id = id;
		this.dataOrdine = dataOrdine;
		this.orarioOrdine = orarioOrdine;
		this.prodotto = prodotto;
		this.prezzoProdotto = prezzoProdotto ;
		this.quantitaProdotto = quantitaProdotto;
		this.ivaProdotto = ivaProdotto; 
		this.indirizzo = indirizzo; 
	}
	
	public OrdineBean() {

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataOrdine() {
		return dataOrdine;
	}
	public void setDataOrdine(Date dataOrdine) {
		this.dataOrdine = dataOrdine;
	}
	public Date getDataConsegna() {
		return dataConsegna;
	}
	public void setDataConsegna(Date date) {
		this.dataConsegna = date;
	}
	public Time getOrarioOrdine() {
		return orarioOrdine;
	}
	public void setOrarioOrdine(Time time) {
		this.orarioOrdine = time;
	}
	public Time getOrarioConsegna() {
		return orarioConsegna;
	}
	public void setOrarioConsegna(Time orarioConsegna) {
		this.orarioConsegna = orarioConsegna;
	}
	public ProdottoBean getProdotto() {
		return prodotto;
	}
	public void setProdotto(ProdottoBean prodotto) {
		this.prodotto = prodotto;
	}
	public UtenteBean getUtente() {
		return utente;
	}
	public void setUtente(UtenteBean utente) {
		this.utente = utente;
	}

	public double getPrezzoProdotto() {
		return prezzoProdotto;
	}

	public void setPrezzoProdotto(double prezzoProdotto) {
		this.prezzoProdotto = prezzoProdotto;
	}

	public int getQuantitaProdotto() {
		return quantitaProdotto;
	}

	public void setQuantitaProdotto(int quantitaProdotto) {
		this.quantitaProdotto = quantitaProdotto;
	}

	public int getIvaProdotto() {
		return ivaProdotto;
	}

	public void setIvaProdotto(int ivaProdotto) {
		this.ivaProdotto = ivaProdotto;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

}
