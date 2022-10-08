package model;

import java.util.List;

import org.json.JSONArray;

public interface TelefonoDAO {
	public boolean aggiungiTelefono(TelefonoBEAN telefono);
	public boolean rimuoviTelefono(TelefonoBEAN telefono);
	public JSONArray leggiTelefono(UtenteBean utente);
}
