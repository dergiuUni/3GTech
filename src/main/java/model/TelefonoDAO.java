package model;

import java.util.List;

public interface TelefonoDAO {
	public boolean aggiungiTelefono(TelefonoBEAN telefono);
	public boolean rimuoviTelefono(TelefonoBEAN telefono);
	public List<TelefonoBEAN> leggiTelefono(UtenteBean utente);
	public void elencoFunzioni();
}
