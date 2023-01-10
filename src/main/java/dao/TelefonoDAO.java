package dao;

import org.json.JSONArray;

import bean.TelefonoBEAN;
import bean.UtenteBean;

public interface TelefonoDAO {
	public boolean   aggiungiTelefono (TelefonoBEAN telefono);
	public boolean   rimuoviTelefono  (TelefonoBEAN telefono);
	public JSONArray leggiTelefono    (UtenteBean utente);
}
