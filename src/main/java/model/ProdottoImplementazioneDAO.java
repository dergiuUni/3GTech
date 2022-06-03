package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.ProdottoBean.categoria;

public class ProdottoImplementazioneDAO implements ProdottoDAO {
	private static String username = "UserAzienda2";
	private static String password = "user";
	
	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice
	     * <li> nome prodotto
	     * <li> tipo del prodotto scelto dalla categoria definita
	     * <li> descrizione
	     * <li> prezzo
	     * <li> quantità
     * </ul>
     * 
     * @param   prodotto
     * @return  <ul>
     * 				<li>{@code true}: prodotto inserito correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato inserito
     *          </ul>
     */
	@Override
	public boolean inserisciProdotto(ProdottoBean prodottoBean) {
		Query q = new Query();
		if(prodottoBean.getCodice() != 0 && prodottoBean.getNome() != null && prodottoBean.getNome().length() <= 100 && prodottoBean.getTipo() != null && prodottoBean.getDescrizione() != null && prodottoBean.getDescrizione().length() <= 300 && prodottoBean.getPrezzo() != 0 && prodottoBean.getQuantita() != 0) {
			return q.updateQuery("INSERT INTO Prodotto (nome, tipo, descrizione, prezzo, quantita) VALUES ('" + prodottoBean.getNome() + "','" + String.valueOf(prodottoBean.getTipo()) + "','" + prodottoBean.getDescrizione() + "'," + prodottoBean.getPrezzo() + "," + prodottoBean.getQuantita() + ")", username, password);
		}
		return false;
	}

	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice
     * </ul>
     * 
     * @param   prodotto
     * @return  <ul>
     * 				<li>{@code true}: prodotto eliminato correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato eliminato
     *          </ul>
     */
	@Override
	public boolean rimuoviProdotto(ProdottoBean prodottoBean) {
		Query q = new Query();
		if(prodottoBean.getCodice() != 0) {
			return q.controlloAndUpdateQueryProdotto(prodottoBean.getCodice(), "DELETE FROM Prodotto WHERE codice = " + prodottoBean.getCodice(), username, password);
		}
		return false;
	}

	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice
	     * <li> descrizione
     * </ul>
     * 
     * @param   prodotto
     * @return  <ul>
     * 				<li>{@code true}: modifica effettuata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato modificato
     *          </ul>
     */
	@Override
	public boolean modificaDescrizione(ProdottoBean prodottoBean) {
		Query q = new Query();
		if(prodottoBean.getCodice() != 0 &&  prodottoBean.getDescrizione() != null && prodottoBean.getDescrizione().length() <= 300 ) {
			return q.controlloAndUpdateQueryProdotto(prodottoBean.getCodice(), "UPDATE Prodotto SET descrizione = '" + prodottoBean.getDescrizione() + "' WHERE codice = " + prodottoBean.getCodice(), username, password);
		}
		return false;
	}

	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice
	     * <li> nome
     * </ul>
     * 
     * @param   prodotto
     * @return  <ul>
     * 				<li>{@code true}: modifica effettuata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato modificato
     *          </ul>
     */
	@Override
	public boolean modificaNome(ProdottoBean prodottoBean) {
		Query q = new Query();
		if(prodottoBean.getCodice() != 0 && prodottoBean.getNome() != null && prodottoBean.getNome().length() <= 100 ) {
			return q.controlloAndUpdateQueryProdotto(prodottoBean.getCodice(), "UPDATE Prodotto SET nome = '" + prodottoBean.getNome() + "' WHERE codice = " + prodottoBean.getCodice(), username, password);
		}
		return false;
	}

	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice
	     * <li> prezzo
     * </ul>
     * 
     * @param   prodotto
     * @return  <ul>
     * 				<li>{@code true}: modifica effettuata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato modificato
     *          </ul>
     */
	@Override
	public boolean modificaPrezzo(ProdottoBean prodottoBean) {
		Query q = new Query();
		if(prodottoBean.getCodice() != 0 && prodottoBean.getPrezzo() != 0 ) {
			return q.controlloAndUpdateQueryProdotto(prodottoBean.getCodice(), "UPDATE Prodotto SET prezzo = " + prodottoBean.getPrezzo() + " WHERE codice = " + prodottoBean.getCodice(), username, password);
		}
		return false;
	}

	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice
	     * <li> tipo del prodotto scelto dalla categoria definita
     * </ul>
     * 
     * @param   prodotto
     * @return  <ul>
     * 				<li>{@code true}: modifica effettuata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato modificato
     *          </ul>
     */
	@Override
	public boolean modificaTipo(ProdottoBean prodottoBean) {
		Query q = new Query();
		if(prodottoBean.getCodice() != 0 && prodottoBean.getTipo() != null ) {
			return q.controlloAndUpdateQueryProdotto(prodottoBean.getCodice(), "UPDATE Prodotto SET tipo = '" + String.valueOf(prodottoBean.getTipo()) + "' WHERE codice = " + prodottoBean.getCodice(), username, password);
		}
		return false;
	}
	
	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice
	     * <li> quantità
     * </ul>
     * 
     * @param   prodotto
     * @return  <ul>
     * 				<li>{@code true}: modifica effettuata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato modificato
     *          </ul>
     */
	@Override
	public boolean modificaQuantita(ProdottoBean prodottoBean) {
		Query q = new Query();
		if(prodottoBean.getCodice() != 0 && prodottoBean.getQuantita() != 0 ) {
			return q.controlloAndUpdateQueryProdotto(prodottoBean.getCodice(), "UPDATE Prodotto SET quantita = " + prodottoBean.getQuantita() + " WHERE codice = " + prodottoBean.getCodice(), username, password);
		}
		return false;
	}
	
	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice
     * </ul>
     * 
     * @param   prodotto
     * @return  <ul>
     * 				<li>{@code true}: modifica effettuata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato modificato
     *          </ul>
     */
	@Override
	public boolean decrementaQuantita(ProdottoBean prodottoBean) {
		Query q = new Query();
		Connettore con = new Connettore();
		ResultSet result;
		
		if(prodottoBean.getCodice() != 0) {
			try {
				con.OpenConnection(username, password);
				result = con.getConnection().createStatement().executeQuery("SELECT quantita FROM Prodotto WHERE codice = " + prodottoBean.getCodice());
				result.next();
				prodottoBean.setQuantita(result.getInt("quantita"));
				result.close();
				con.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.print("error dao implementazione");
			}
			if(prodottoBean.getQuantita() > 0) {
				prodottoBean.setQuantita(prodottoBean.getQuantita() - 1);
				return q.updateQuery("UPDATE Prodotto SET quantita = " + prodottoBean.getQuantita() + " WHERE codice = " + prodottoBean.getCodice(), username, password);
			}
		}
		return false;
	}
	
	public int quantit�Prodotti() {
		Connettore con = new Connettore();
		ResultSet result;
		try {
			con.OpenConnection(username, password);
			result = con.getConnection().createStatement().executeQuery("SELECT COUNT(codice) AS total FROM Prodotto");
			result.next();
			int quantita = result.getInt("total");
			result.close();
			con.closeConnection();
			return quantita;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("error dao implementazione");
		}
		return 0;
	}
	
	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice
     * </ul>
     * 
     * @param   ordine
     * @return  void poichè aggiorna tutti i campi dell'oggetto prodotto che gli viene passato come input
     */
	@Override
	public void leggiSingoloProdotto(ProdottoBean prodottoBean) {
		Connettore con = new Connettore();
		ResultSet result;
		if(prodottoBean.getCodice() != 0) {
			try {
				con.OpenConnection(username, password);
				result = con.getConnection().createStatement().executeQuery("SELECT * FROM Prodotto WHERE codice = " + prodottoBean.getCodice());
				result.next();
				prodottoBean.setNome(result.getString("nome"));
				prodottoBean.setDescrizione(result.getString("descrizione"));
				prodottoBean.setPrezzo(result.getDouble("prezzo"));
				prodottoBean.setTipo(categoria.valueOf(result.getString("tipo")));
				prodottoBean.setQuantita(result.getInt("quantita"));
				result.close();
				con.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.print("error dao implementazione");
			}
		}
	}

	/**
	 * legge tutti i prodotti contenuti nel db
     * @return  arraylist composto da oggetti prodotto con tutti i campi inizializzati 
     */
	@Override
	public List<ProdottoBean> leggiProdotto() {
		List<ProdottoBean> pr = new ArrayList<ProdottoBean>();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Prodotto ");

			while (result.next()) {
				ProdottoBean p = new ProdottoBean(result.getString("nome"), result.getString("descrizione"), result.getDouble("prezzo"), categoria.valueOf(result.getString("tipo")), result.getInt("quantita"));
				p.setCodice(result.getShort("codice"));
				pr.add(p);
			}
			result.close();
			con.closeConnection();
			return pr;
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
	 * 		<li>inserisciProdotto
	 * 		<li>rimuoviProdotto
	 * 		<li>modificaDescizione
	 * 		<li>modificaNome
	 * 		<li>modificaPrezzo
	 * 		<li>modificaTipo 
	 * 		<li>modificaQuantità
	 * 		<li>decrementaQuantità
	 *      <li>quantitàProdotti
	 * 		<li>leggiSingoloProdotto
	 * 		<li>leggiProdotto
	 * 		<li>elencoFunzioni
	 * </ul>
	 * ATTENZIONE: Questo metodo non fa assolutamente nulla
	 */
	@Override
	public void elencoFunzioni() {
		
	}
}

/*
 * executeUpdate per insert, delete o update executeQuery per le query select
 */