 package MODEL;

import java.util.List;

public interface ProdottoDAO {
	
	public boolean        inserisciProdotto    (ProdottoBean prodottoBean);
	public boolean        rimuoviProdotto      (ProdottoBean prodottoBean);
	public boolean        modificaDescrizione  (ProdottoBean prodottoBean);
	public boolean        modificaNome         (ProdottoBean prodottoBean);
	public boolean 		  modificaPrezzo       (ProdottoBean prodottoBean);
	public boolean    	  modificaTipo         (ProdottoBean prodottoBean); 
	public boolean        modificaQuantita     (ProdottoBean prodottoBean); 
	public boolean        decrementaQuantita   (ProdottoBean prodottoBean);
	public void           leggiSingoloProdotto (ProdottoBean prodottoBean);
	public List<ProdottoBean> leggiProdotto    ();
	public void elencoFunzioni();

}
