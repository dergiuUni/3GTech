 package model;

import java.sql.Date;
import java.util.ArrayList;

import org.json.JSONArray;

public interface ProdottoDAO {
	
	public boolean        inserisciProdotto      (ProdottoBean prodottoBean);
	public boolean        rimuoviProdotto        (ProdottoBean prodottoBean);
	public boolean        modificaDescrizione    (ProdottoBean prodottoBean);
	public boolean        modificaNome           (ProdottoBean prodottoBean);
	public boolean 		  modificaPrezzo         (ProdottoBean prodottoBean);
	public boolean    	  modificaTipo           (ProdottoBean prodottoBean); 
	public boolean        modificaQuantita       (ProdottoBean prodottoBean); 
	public boolean        decrementaQuantita     (ProdottoBean prodottoBean);
	public int            quantitaProdotti       ();
	public void           leggiSingoloProdotto   (ProdottoBean prodottoBean);
	public JSONArray      leggiProdotto          ();
	public JSONArray      utimiInseriti          ();
	public JSONArray      random                 ();
	public JSONArray      videogameRandom        ();
	public JSONArray      consoleRandom          ();
	public JSONArray      computerRandom         ();
	public JSONArray      elettrodomesticiRandom ();
	public JSONArray      altroRandom            ();
	public JSONArray      utimiInseritiVideogame ();
	public JSONArray      utimiInseritiConsole   ();
	public JSONArray      utimiInseritiComputer  (); 
	public JSONArray      utimiInseritiElettrodomestici ();
	public JSONArray      utimiInseritiAltro     ();
	public ArrayList<String>      cerca                  (String cerco);
	public void           elencoFunzioni         ();
	public String elenco();
	public String selectOrdiniUtente(UtenteBean utente);
	public String selectOrdiniData(Date d1, Date d2);
	public ArrayList<String> elencoPerRicerca();
	public Short getProdottoByName(String name);
}
