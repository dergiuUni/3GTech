package bean;

import java.io.Serializable;
import java.util.Date;

public class CartaBEAN implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date scadenza;
	private String titolare;
	private short cvc;
	private String numero;
	
	public Date getScadenza() {
		return scadenza;
	}
	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}
	public String getTitolare() {
		return titolare;
	}
	public void setTitolare(String titolare) {
		this.titolare = titolare;
	}
	public short getCvc() {
		return cvc;
	}
	public void setCvc(short cvc) {
		this.cvc = cvc;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
