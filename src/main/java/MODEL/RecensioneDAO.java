package MODEL;

import java.util.List;

public interface RecensioneDAO {
	public boolean aggiungiRecensione(RecensioneBEAN recensione);
	public boolean rimuoviRecensione(RecensioneBEAN recensione);
	public boolean leggiStelle(RecensioneBEAN recensione);
	public boolean lasciaStelle(RecensioneBEAN recensione);
	public List<RecensioneBEAN> leggiRecensione(ProdottoBean prodotto);
	public void elencoFunzioni();
}
