package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TelefonoImplementatoDAO implements TelefonoDAO{
	private static String username = "UserAzienda2";
	private static String password = "user";
	
	/**
     * Passare un'oggetto telefonodiverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> numero 
	     * <li> email dell'utente
     * </ul>
     * 
     * @param   telefono
     * @return  <ul>
     * 				<li>{@code true}: telefono inserito correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato inserito
     *          </ul>
     */
	public boolean aggiungiTelefono (TelefonoBEAN telefono) {
		Query q = new Query();
		if(telefono.getNumero() != null && telefono.getNumero().length() == 10 && telefono.getUtente() != null) {
			return q.updateQuery("INSERT INTO Telefono(utente, numero) VALUES ('" + telefono.getUtente().getEmail() + "', '" + telefono.getNumero() + "')", username, password);
		}
		return false;
	}

	/**
     * Passare un'oggetto telefono diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> numero
     * </ul>
     * 
     * @param   telefono
     * @return  <ul>
     * 				<li>{@code true}: telefono eliminato correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato eliminato
     *          </ul>
     */
	@Override
	public boolean rimuoviTelefono(TelefonoBEAN telefono) {
		Query q = new Query();
		if(telefono.getNumero() != null && telefono.getNumero().length() == 10) {
			return q.updateQuery("DELETE FROM Telefono WHERE numero = '" + telefono.getNumero() + "'", username, password);
		}
		return false;
	}

	/**
     * Passare un'oggetto utente diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> email
     * </ul>
     * 
     * @param   utente
     * @return  lista di tutti i gli oggetti telefono con il campo numero inizializzato di un determinato utente(passato in input)
     */
	@Override
	public List<TelefonoBEAN> leggiTelefono(UtenteBean utente) {
		List<TelefonoBEAN> pr = new ArrayList<TelefonoBEAN>();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Telefono WHERE utente = '" + utente.getEmail() + "'");

			while (result.next()) {
				TelefonoBEAN p = new TelefonoBEAN(result.getString("numero"));
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
	 * 		<li>aggiungiTelefono
	 * 		<li>rimuoviTelefono
	 *		<li>leggiTelefono
	 *		<li>elencoFunzioni
	 * </ul>
	 * ATTENZIONE: Questo metodo non fa assolutamente nulla
	 */
	@Override
	public void elencoFunzioni() {
		
	}
}
