package dao;

import bean.CartaBEAN;
import bean.UtenteBean;

public interface CartaDAO {
	public boolean aggiungiCarta(CartaBEAN carta, UtenteBean utente);
	public boolean rimuoviCarta (CartaBEAN carta);
	public boolean exists       (CartaBEAN carta);
	public boolean pagamento    (CartaBEAN carta);
}