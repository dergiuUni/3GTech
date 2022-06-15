package model;

import java.util.List;

import org.json.JSONArray;

public interface OrdineDAO {
	
	public int inserisciOrdine        (OrdineBean ordine);
	public boolean modificaDataConsegna   (OrdineBean ordine);
	public boolean modificaOrarioConsegna (OrdineBean ordine);
	public void    leggiSingoloOrdine     (OrdineBean ordine);
	public JSONArray leggiOrdine   (UtenteBean utente);
	public void    elencoFunzioni();
}
