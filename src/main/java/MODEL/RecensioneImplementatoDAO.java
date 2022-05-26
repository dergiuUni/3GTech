package MODEL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecensioneImplementatoDAO implements RecensioneDAO {
	private static String username = "UserAzienda2";
	private static String password = "user";
	
	/**
     * Passare un'oggetto recensione diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> testo 
	     * <li> codice del prodotto 
	     * <li> email dell'utente
     * </ul>
     * 
     * @param   recensione
     * @return  <ul>
     * 				<li>{@code true}: recensione inserita correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stata inserita
     *          </ul>
     */
	@Override
	public boolean aggiungiRecensione(RecensioneBEAN recensione) {
		Query q = new Query();
		if(recensione != null && recensione.getTesto() != null && recensione.getTesto().length() <= 100 && recensione.getProdotto() != null && recensione.getProdotto().getCodice() != 0 && recensione.getUtente() != null && recensione.getUtente().getEmail() != null) {
			return q.updateQuery("INSERT INTO Recensione (testo, utente, prodotto) VALUES ('" + recensione.getTesto() + "', '" + recensione.getUtente().getEmail() + "', " + recensione.getProdotto().getCodice() + ")", username, password);
		}
		return false;
	}

	/**
     * Passare un'oggetto recensione diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> id 
     * </ul>
     * 
     * @param   recensione
     * @return  <ul>
     * 				<li>{@code true}: recensione eliminata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stata eliminata
     *          </ul>
     */
	@Override
	public boolean rimuoviRecensione(RecensioneBEAN recensione) {
		Query q = new Query();
		if(recensione != null && recensione.getId() != 0) {
			return q.updateQuery("DELETE FROM Recensione WHERE id = " + recensione.getId(), username, password);
		}
		return false;
	}
	
	/**
     * Passare un'oggetto recensione diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> id 
	     * <li> codice del prodotto
     * </ul>
     * 
     * @param   recensione
     * @return  <ul>
     * 				<li>{@code true}: lettura avvenura correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stata letta
     *          </ul>
     *          la media delle stelle la si trova nell oggetto che viene passato come input
     */
	public boolean leggiStelle(RecensioneBEAN recensione) {
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection( username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT ROUND(AVG(stelle)) FROM Recensione WHERE prodotto = " + recensione.getProdotto().getCodice());
			result.next();
			
			recensione.setStelle(result.getInt(1));
			result.close();
			con.closeConnection();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("error dao implementazione");
			System.out.print(e);
		}
		return false;
	}
	
	/**
     * Passare un'oggetto recensione diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> id 
	     * <li> codice del prodotto
	     * <li> email dell'utente
     * </ul>
     * 
     * @param   recensione
     * @return  <ul>
     * 				<li>{@code true}: stelle aggiunte correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stata inserita
     *          </ul>
     */
	public boolean lasciaStelle(RecensioneBEAN recensione) {
		Query q = new Query();
		
		if(recensione != null && recensione.getProdotto().getCodice() != 0 && recensione.getUtente().getEmail() != null) {
			q.updateQuery("UPDATE Recensione SET stelle = " + recensione.getStelle() + " WHERE utente = '" + recensione.getUtente().getEmail() + "' AND prodotto = " + recensione.getProdotto().getCodice(), username, password);
			return true;
		}
		return false;
	}

	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice 
     * </ul>
     * 
     * @param   recensione
     * @return  lista di tutte le recensioni effettuate su quel prodotto. La recensione sarà riempica dai campi id della recensione e dal testo
     */
	@Override
	public List<RecensioneBEAN> leggiRecensione(ProdottoBean prodotto) {
		List<RecensioneBEAN> pr = new ArrayList<RecensioneBEAN>();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection( username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Recensione WHERE prodotto = " + prodotto.getCodice());

			while (result.next()) {
				UtenteBean ut = new UtenteBean();
				ut.setEmail(result.getString("utente"));
				RecensioneBEAN p = new RecensioneBEAN(result.getInt("id"), result.getString("testo"), ut);
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
	 * 		<li>aggiungiRecensione
	 * 		<li>rimuoviRecensione
	 * 		<li>leggiRecensione
	 * 		<li>elencoFunzioni
	 * </ul>
	 * ATTENZIONE: Questo metodo non fa assolutamente nulla
	 */
	@Override
	public void elencoFunzioni() {
		
	}
}
