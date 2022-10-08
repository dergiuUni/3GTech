package model;

import java.util.List;

import org.json.JSONArray;

public interface RecensioneDAO {
	public boolean aggiungiRecensione(RecensioneBEAN recensione);
	public boolean rimuoviRecensione(RecensioneBEAN recensione);
	public boolean leggiStelle(RecensioneBEAN recensione);
	public boolean lasciaStelle(RecensioneBEAN recensione);
	public JSONArray leggiRecensione(ProdottoBean prodotto);
}
