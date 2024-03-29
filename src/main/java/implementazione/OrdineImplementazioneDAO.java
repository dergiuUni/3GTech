package implementazione;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;

import com.google.gson.Gson;

import bean.OrdineBean;
import bean.UtenteBean;
import bean.ProdottoBean;
import dao.OrdineDAO;
import database.*;

public class OrdineImplementazioneDAO implements OrdineDAO{
	private static String username = "UserAzienda2";
	private static String password = "user";
	
	/**
     * Passare un'oggetto ordine diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li>dataOrdine
	     * <li>orarioOrdine
	     * <li>dataConsegna
	     * <li>OrarioConsegna
	     * <li>prodotto 
	     * <li>prezzoProdotto
	     * <li>quantitaProdotto
	     * <li>ivaProdotto
	     * <li>utente
	     * <li>utente email
	     * <li>cartanumero
	     * <li>carta
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
	public int inserisciOrdine(OrdineBean ordine) {
		Query q = new Query();
		if(ordine != null && ordine.getDataOrdine() != null && ordine.getDataConsegna() != null && ordine.getOrarioOrdine() != null && ordine.getOrarioConsegna() != null && ordine.getProdotto() != null && ordine.getProdotto().getCodice() != 0 && ordine.getPrezzoProdotto()  != 0  && ordine.getQuantitaProdotto() != 0 && ordine.getIvaProdotto() != 0 && ordine.getUtente() != null && ordine.getUtente().getEmail()  != null && ordine.getIndirizzo() != null && ordine.getCarta() != null && ordine.getCarta().getNumero() != null) {
			q.updateQuery("INSERT INTO Ordine (dataOrdine, dataConsegna, orarioOrdine, orarioConsegna, prodotto, prezzoProdotto, quantitaProdotto, ivaProdotto, utente, indirizzoSpedizione, cartaUsata) VALUES ('" + ordine.getDataOrdine() + "', '" + ordine.getDataConsegna() + "', '" + ordine.getOrarioOrdine() + "', '" + ordine.getOrarioConsegna() + "', " + ordine.getProdotto().getCodice() + ", " + ordine.getProdotto().getPrezzo() + ", " + ordine.getQuantitaProdotto() + ", " + ordine.getIvaProdotto() + ", '" + ordine.getUtente().getEmail() + "', '" + ordine.getIndirizzo() + "','" + ordine.getCarta().getNumero() +"')", username, password);
		}
		if(ordine != null && ordine.getDataOrdine() != null && ordine.getOrarioOrdine() != null && ordine.getProdotto() != null && ordine.getProdotto().getCodice() != 0 && ordine.getPrezzoProdotto()  != 0  && ordine.getQuantitaProdotto() != 0 && ordine.getIvaProdotto() != 0 && ordine.getUtente() != null && ordine.getUtente().getEmail()  != null && ordine.getIndirizzo() != null && ordine.getCarta() != null && ordine.getCarta().getNumero() != null) {
			q.updateQuery("INSERT INTO Ordine (dataOrdine, orarioOrdine, prodotto, prezzoProdotto, quantitaProdotto, ivaProdotto, utente, indirizzoSpedizione, cartaUsata) VALUES ('" + ordine.getDataOrdine() + "', '" + ordine.getOrarioOrdine() + "', "  + ordine.getProdotto().getCodice() + ", " + ordine.getProdotto().getPrezzo() + ", " + ordine.getQuantitaProdotto() + ", " + ordine.getIvaProdotto() + ", '"  + ordine.getUtente().getEmail() + "', '" + ordine.getIndirizzo() + "','" + ordine.getCarta().getNumero() +"')", username, password);
		}
		int id=-1;
		try {
			Connettore con = new Connettore();
			con.OpenConnection(username, password);
			ResultSet rs = con.getConnection().createStatement().executeQuery("SELECT idOrdine FROM Ordine WHERE dataOrdine='"+ ordine.getDataOrdine()+"' AND orarioOrdine='"+ordine.getOrarioOrdine()+"'AND prodotto='"+ordine.getProdotto().getCodice()+"';");
			if(rs.next()) {
				id = rs.getInt("idOrdine");
			}
			rs.close();
			con.closeConnection();
		}catch(SQLException e) {
			System.out.println("errore inserisciordine " + e);
		}
		return id;
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

			UtenteImplementazioneDAO utimp = new UtenteImplementazioneDAO();
			utimp.leggiSingoloUtente(utente);
			array.put(gson.toJson(utente));
			
			while (result.next()) {
				OrdineBean ordine = new OrdineBean();
				ordine.setId(result.getInt("idOrdine"));
				ordine.setDataOrdine(result.getDate("dataOrdine"));
				ordine.setDataConsegna(result.getDate("dataConsegna"));
				ordine.setOrarioOrdine(result.getTime("orarioOrdine"));
				ordine.setOrarioConsegna(result.getTime("orarioConsegna"));
				ordine.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
			    ordine.setQuantitaProdotto(result.getInt("quantitaProdotto"));
			    ordine.setIvaProdotto(result.getInt("ivaProdotto"));
			    ordine.setIndirizzo(result.getString("indirizzoSpedizione"));
				array.put(gson.toJson(ordine));
				ProdottoBean pr = new ProdottoBean();
				ProdottoImplementazioneDAO primp = new ProdottoImplementazioneDAO();
			    pr.setCodice(result.getShort("prodotto"));
				primp.leggiSingoloProdotto(pr);
			    array.put(gson.toJson(pr));
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
	
	public JSONArray selectOrdiniUtente(UtenteBean utente) {
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Ordine, Prodotto WHERE  Ordine.prodotto = Prodotto.codice AND Ordine.utente='"+utente.getEmail() + "'");

			while (result.next()) {
				OrdineBean ordine = new OrdineBean();
				ordine.setId(result.getInt("idOrdine"));
				ordine.setDataOrdine(result.getDate("dataOrdine"));
				ordine.setDataConsegna(result.getDate("dataConsegna"));
				ordine.setOrarioOrdine(result.getTime("orarioOrdine"));
				ordine.setOrarioConsegna(result.getTime("orarioConsegna"));
				ordine.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
			    ordine.setQuantitaProdotto(result.getInt("quantitaProdotto"));
			    ordine.setIvaProdotto(result.getInt("ivaProdotto"));
			    ordine.setIndirizzo(result.getString("indirizzoSpedizione"));
			    ProdottoBean pr = new ProdottoBean();
			    pr.setCodice(result.getShort("codice"));
			    pr.setNome(result.getString("nome"));
			    pr.setDescrizione(result.getString("descrizione"));
			    ordine.setProdotto(pr);
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
	
	public JSONArray selectOrdiniData(Date d1, Date d2) {
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Connettore con = new Connettore();
		
		if(d1.toString() == null || d2.toString() == null || d1.toString() == "" || d2.toString() == "") {
			return array;
		}
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Ordine INNER JOIN Prodotto on Ordine.prodotto = Prodotto.codice WHERE dataOrdine BETWEEN '"+d1+"' AND '"+d2+"'");

			while (result.next()) {
				OrdineBean ordine = new OrdineBean();
				ordine.setId(result.getInt("idOrdine"));
				ordine.setDataOrdine(result.getDate("dataOrdine"));
				ordine.setDataConsegna(result.getDate("dataConsegna"));
				ordine.setOrarioOrdine(result.getTime("orarioOrdine"));
				ordine.setOrarioConsegna(result.getTime("orarioConsegna"));
				ordine.setPrezzoProdotto(result.getDouble("prezzoProdotto"));
			    ordine.setQuantitaProdotto(result.getInt("quantitaProdotto"));
			    ordine.setIvaProdotto(result.getInt("ivaProdotto"));
			    ordine.setIndirizzo(result.getString("indirizzoSpedizione"));
			    ProdottoBean pr = new ProdottoBean();
			    pr.setCodice(result.getShort("codice"));
			    pr.setNome(result.getString("nome"));
			    pr.setDescrizione(result.getString("descrizione"));
			    ordine.setProdotto(pr);
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
}