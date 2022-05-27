package model;

import java.util.List;

public interface OrdineDAO {
	
	public boolean inserisciOrdine        (OrdineBean ordine);
	public boolean modificaDataConsegna   (OrdineBean ordine);
	public boolean modificaOrarioConsegna (OrdineBean ordine);
	public void leggiSingoloOrdine        (OrdineBean ordine);
	public List<OrdineBean> leggiOrdine   (UtenteBean utente);
	public void elencoFunzioni();
}
