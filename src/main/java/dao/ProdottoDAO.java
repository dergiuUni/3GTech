package dao;

import bean.ProdottoBean;
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
	public JSONArray      utimiInseritiAltro            ();
	public JSONArray 	  cerca                         (String cerco);
	public Short 		  getProdottoByName             (String name);
}
