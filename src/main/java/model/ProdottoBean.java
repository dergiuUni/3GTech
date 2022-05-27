package model;

public class ProdottoBean {
	private short codice;
    private String nome;
    private String descrizione;
    private double prezzo;  
    private int quantita;
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
    
    public ProdottoBean(String nome, String descrizione, double prezzo, categoria tipo, int quantita) {
    	this.nome = nome;
    	this.descrizione = descrizione;
    	this.prezzo = prezzo;
    	this.tipo = tipo;
    	this.quantita = quantita;
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

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
}
