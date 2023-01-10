package dao;

import org.json.JSONArray;

import bean.CartaBEAN;
import bean.UtenteBean;

public interface PossiedeDAO {
	public JSONArray carteUtente(UtenteBean utente);
	public boolean inserisciCarta(UtenteBean utente, CartaBEAN carta);
}
