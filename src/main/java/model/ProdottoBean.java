package model;

import java.io.Serializable;
import java.util.Date;

public class ProdottoBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private short codice;
    private String nome;
    private String descrizione;
    private double prezzo;  
    private int quantitaDB;
    private int quantitaCarrello;
    private Date inserimento;
    public static enum categoria{
    	Videogame,
    	Console,
    	Computer,
    	Elettrodomestici,
    	Altro
    }
    categoria tipo;
    
    public ProdottoBean() {
		// TODO Auto-generated constructor stub
	}
    
    public ProdottoBean(String nome, String descrizione, double prezzo, categoria tipo, int quantitaDB, Date inserimento) {
    	this.nome = nome;
    	this.descrizione = descrizione;
    	this.prezzo = prezzo;
    	this.tipo = tipo;
    	this.quantitaDB = quantitaDB;
    	this.inserimento = inserimento;
    }
    
    public ProdottoBean(String nome, String descrizione, double prezzo, categoria tipo, Date inserimento) {
    	this.nome = nome;
    	this.descrizione = descrizione;
    	this.prezzo = prezzo;
    	this.tipo = tipo;
    	this.inserimento = inserimento;
    }
    
    public short getCodice() {
		return codice;
	}
	public void setCodice(short codice) {
		this.codice = codice;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public categoria getTipo() {
		return tipo; 
	}
	public void setTipo(categoria tipo) {
		this.tipo = tipo;
	}

	public Date getInserimento() {
		return inserimento;
	}

	public void setInserimento(Date inserimento) {
		this.inserimento = inserimento;
	}

	public int getQuantitaDB() {
		return quantitaDB;
	}

	public void setQuantitaDB(int quantitaDB) {
		this.quantitaDB = quantitaDB;
	}

	public int getQuantitaCarrello() {
		return quantitaCarrello;
	}

	public void setQuantitaCarrello(int quantitaCarrello) {
		this.quantitaCarrello = quantitaCarrello;
	}
}
