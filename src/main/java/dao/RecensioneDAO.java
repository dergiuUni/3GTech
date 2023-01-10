package dao;

import org.json.JSONArray;

import bean.RecensioneBEAN;
import bean.ProdottoBean;

public interface RecensioneDAO {
	public boolean   aggiungiRecensione (RecensioneBEAN recensione);
	public boolean   rimuoviRecensione  (RecensioneBEAN recensione);
	public boolean   leggiStelle        (RecensioneBEAN recensione);
	public boolean   lasciaStelle       (RecensioneBEAN recensione);
	public JSONArray leggiRecensione    (ProdottoBean prodotto);
}
