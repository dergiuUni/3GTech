package dao;

import java.sql.Date;
import org.json.JSONArray;

import bean.OrdineBean;
import bean.UtenteBean;

public interface OrdineDAO {
	
	public int       inserisciOrdine        (OrdineBean ordine);
	public boolean   modificaDataConsegna   (OrdineBean ordine);
	public boolean   modificaOrarioConsegna (OrdineBean ordine);
	public void      leggiSingoloOrdine     (OrdineBean ordine);
	public JSONArray leggiOrdine            (UtenteBean utente);
	public JSONArray selectOrdiniUtente     (UtenteBean utente);
	public JSONArray selectOrdiniData       (Date d1, Date d2);
}
