package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import com.google.gson.Gson;

public class OrdineImplementazioneDAO implements OrdineDAO{
	private static String username = "UserAzienda2";
	private static String password = "user";
	
	/**
     * Passare un'oggetto ordine diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> dataOrdine
	     * <li>orarioOrdine
	     * <li>dataConsegna
	     * <li>OrarioConsegna
	     * <li>prodotto 
	     * <li>prezzoProdotto
	     * <li>quantitaProdotto
	     * <li>ivaProdotto
	     * <li>utente
	     * <li>indirizzoSpedizione
     * </ul>
     * 
     * Oppure una'altro inizializzare solo questi campi nel caso in cui il prodotto è stato acquistato ma non ancora consegnato: 
     * * <ul>
	     * <li> dataOrdine
	     * <li>orarioOrdine
	     * <li>prodotto 
	     * <li>prezzoProdotto
	     * <li>quantitaProdotto
	     * <li>ivaProdotto
	     * <li>utente
	     * <li>indirizzoSpedizione
     * </ul>
     * 
     * @param   ordine
     * @return  <ul>
     * 				<li>{@code true}: ordine inserito correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato inserito
     *          </ul>
     */
	@Override
	public boolean inserisciOrdine(OrdineBean ordine) {
		Query q = new Query();
		if(ordine != null && ordine.getDataOrdine() != null && ordine.getDataConsegna() != null && ordine.getOrarioOrdine() != null && ordine.getOrarioConsegna() != null && ordine.getProdotto() != null && ordine.getProdotto().getCodice() != 0 && ordine.getPrezzoProdotto()  != 0  && ordine.getQuantitaProdotto() != 0 && ordine.getIvaProdotto() != 0 && ordine.getUtente() != null && ordine.getUtente().getEmail()  != null && ordine.getIndirizzo() != null) {
			return q.updateQuery("INSERT INTO Ordine (dataOrdine, dataConsegna, orarioOrdine, orarioConsegna, prodotto, prezzoProdotto, quantitaProdotto, ivaProdotto, utente, indirizzoSpedizione) VALUES ('" + ordine.getDataOrdine() + "', '" + ordine.getDataConsegna() + "', '" + ordine.getOrarioOrdine() + "', '" + ordine.getOrarioConsegna() + "', " + ordine.getProdotto().getCodice() + ", " + ordine.getProdotto().getPrezzo() + ", " + ordine.getQuantitaProdotto() + ", " + ordine.getIvaProdotto() + ", '" + ordine.getUtente().getEmail() + "', '" + ordine.getIndirizzo() + "')", username, password);
		}
		if(ordine != null && ordine.getDataOrdine() != null && ordine.getOrarioOrdine() != null && ordine.getProdotto() != null && ordine.getProdotto().getCodice() != 0 && ordine.getPrezzoProdotto()  != 0  && ordine.getQuantitaProdotto() != 0 && ordine.getIvaProdotto() != 0 && ordine.getUtente() != null && ordine.getUtente().getEmail()  != null && ordine.getIndirizzo() != null) {
			return q.updateQuery("INSERT INTO Ordine (dataOrdine, orarioOrdine, prodotto, prezzoProdotto, quantitaProdotto, ivaProdotto, utente, indirizzoSpedizione) VALUES ('" + ordine.getDataOrdine() + "', '" + ordine.getOrarioOrdine() + "', "  + ordine.getProdotto().getCodice() + ", " + ordine.getProdotto().getPrezzo() + ", " + ordine.getQuantitaProdotto() + ", " + ordine.getIvaProdotto() + ", '"  + ordine.getUtente().getEmail() + "', '" + ordine.getIndirizzo() + "')", username, password);
		}
		return false;
	}

	/**
     * Passare un'oggetto ordine diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> id 
	     * <li> data consegna
     * </ul>
     * 
     * @param   ordine
     * @return  <ul>
     * 				<li>{@code true}: data modificata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato modificata
     *          </ul>
     */
	@Override
	public boolean modificaDataConsegna(OrdineBean ordine) {
		Query q = new Query();
		if(ordine != null && ordine.getId() != 0 && ordine.getDataConsegna() != null) {
			return q.controlloAndUpdateQueryOrdine(ordine.getId(), "UPDATE Ordine SET dataConsegna = '" + ordine.getDataConsegna() + "' WHERE idOrdine = " + ordine.getId(), username, password);
		}
		return false;
	}

	/**
     * Passare un'oggetto ordine diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> id 
	     * <li> orario consegna
     * </ul>
     * 
     * @param   ordine
     * @return  <ul>
     * 				<li>{@code true}: orario modificata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato modificata
     *          </ul>
     */
	@Override
	public boolean modificaOrarioConsegna(OrdineBean ordine) {
		Query q = new Query();
		
		if(ordine != null && ordine.getId() != 0 && ordine.getOrarioConsegna() != null) {
			return q.controlloAndUpdateQueryOrdine(ordine.getId(), "UPDATE Ordine SET orarioConsegna = '" + ordine.getOrarioConsegna() + "' WHERE idOrdine = " + ordine.getId(), username, password);
		}
		return false;
	}
	
	/**
     * Passare un'oggetto ordine diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> id 
     * </ul>
     * 
     * @param   ordine
     * @return  void poichè aggiorna tutti i campi dell'oggetto prodotto che gli viene passato come input
     */
	@Override
	public void leggiSingoloOrdine(OrdineBean ordine) {
		Connettore con = new Connettore();
		ResultSet result;
		

		if(ordine.getId() != 0) {
			try {
				con.OpenConnection(username, password);
				result = con.getConnection().createStatement().executeQuery("SELECT * FROM Ordine WHERE idOrdine = " + ordine.getId());
				result.next();
				ordine.setId(result.getInt("idOrdine"));
				ordine.setDataOrdine(result.getDate("dataOrdine"));
				ordine.setDataConsegna(result.getDate("dataConsegna"));
				ordine.setOrarioOrdine(result.getTime("orarioOrdine"));
				ordine.setOrarioConsegna(result.getTime("orarioConsegna"));
				ProdottoBean prodotto = new ProdottoBean();
				prodotto.setCodice(result.getShort("prodotto"));
				ordine.setProdotto(prodotto);
				ordine.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
			    ordine.setQuantitaProdotto(result.getInt("quantitaProdotto"));
			    ordine.setIvaProdotto(result.getInt("ivaProdotto"));
			    UtenteBean ut = new UtenteBean();
			    ut.setEmail(result.getString("utente"));
			    ordine.setUtente(ut);
			    ordine.setIndirizzo(result.getString("indirizzoSpedizione"));
				
				result.close();
				con.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.print("error dao implementazione");
			}
		}
		
	}

	/**
     * Passare un'oggetto utente diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> email 
     * </ul>
     * 
     * @param   utente
     * @return  arraylist composto da oggetti ordini i quali sono tutti gli acquisti che ha effettuato un determinato utente(quello che viene passato come input) PS:il campo prodotto viene formatta solo con il codice, per sapere altri dettagli chiamare la funzione propria 
     */
	@Override
	public JSONArray leggiOrdine(UtenteBean utente) {
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Ordine WHERE utente ='" + utente.getEmail() + "'");

			while (result.next()) {
				OrdineBean ordine = new OrdineBean();
				ordine.setId(result.getInt("idOrdine"));
				ordine.setDataOrdine(result.getDate("dataOrdine"));
				ordine.setDataConsegna(result.getDate("dataConsegna"));
				ordine.setOrarioOrdine(result.getTime("orarioOrdine"));
				ordine.setOrarioConsegna(result.getTime("orarioConsegna"));
				ProdottoBean prodotto = new ProdottoBean();
				prodotto.setCodice(result.getShort("prodotto"));
				ordine.setProdotto(prodotto);
				ordine.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
			    ordine.setQuantitaProdotto(result.getInt("quantitaProdotto"));
			    ordine.setIvaProdotto(result.getInt("ivaProdotto"));
			    UtenteBean ut = new UtenteBean();
			    ut.setEmail(result.getString("utente"));
			    ordine.setUtente(ut);
			    ordine.setIndirizzo(result.getString("indirizzoSpedizione"));
				array.put(gson.toJson(ordine));
			}
			result.close();
			con.closeConnection();
			return array;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("error dao implementazione");
			System.out.print(e);
		}
		return null;
	}
	
	/**
	 * Elenco di tutte le funzioni di questa classe. 
	 * <ul>
	 * 		<li>inserisciOrdine
	 * 		<li>modificaDataConsegna
	 * 		<li>modificaOrarioConsegna 
	 * 		<li>leggiSingoloOrdine: restituisce l'oggetto ordine passatogli con tutti i campi compilati
	 * 		<li>leggiOrdine: resiturisce una lista contenente tutti gli ordini di un determinato utente 
	 * 		<li>elencoFunzioni();
	 * </ul>
	 * ATTENZIONE: Questo metodo non fa assolutamente nulla
	 */
	@Override
	public void elencoFunzioni() {
		
	}
}