package model;

import java.util.Date;

public interface CartaDAO {
	public boolean aggiungiCarta(Date scadenza, String titolare, short cvc, String numero);
	public boolean rimuoviCarta(String numero);
	public boolean pagamento(Date scadenza, String titolare, short cvc, String numero);
}