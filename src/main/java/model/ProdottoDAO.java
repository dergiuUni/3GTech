 package model;

import java.util.List;

import org.json.JSONArray;

public interface ProdottoDAO {
	
	public boolean        inserisciProdotto    (ProdottoBean prodottoBean);
	public boolean        rimuoviProdotto      (ProdottoBean prodottoBean);
	public boolean        modificaDescrizione  (ProdottoBean prodottoBean);
	public boolean        modificaNome         (ProdottoBean prodottoBean);
	public boolean 		  modificaPrezzo       (ProdottoBean prodottoBean);
	public boolean    	  modificaTipo         (ProdottoBean prodottoBean); 
	public boolean        modificaQuantita     (ProdottoBean prodottoBean); 
	public boolean        decrementaQuantita   (ProdottoBean prodottoBean);
	public int            quantitàProdotti     ();
	public void           leggiSingoloProdotto (ProdottoBean prodottoBean);
	public JSONArray leggiProdotto    ();
	public JSONArray utimiInseriti    ();
	public JSONArray random           ();
	public void elencoFunzioni();

}
