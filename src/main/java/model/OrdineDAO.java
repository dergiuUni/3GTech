package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

public interface OrdineDAO {
	
	public int inserisciOrdine        (OrdineBean ordine);
	public boolean modificaDataConsegna   (OrdineBean ordine);
	public boolean modificaOrarioConsegna (OrdineBean ordine);
	public void    leggiSingoloOrdine     (OrdineBean ordine);
	public JSONArray leggiOrdine   (UtenteBean utente);
	public ArrayList<OrdineBean> leggiOrdineArraylist(UtenteBean utente);
	public JSONArray selectOrdiniUtente(UtenteBean utente);
	public JSONArray selectOrdiniData(Date d1, Date d2);
}
