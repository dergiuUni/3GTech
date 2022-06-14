package model;

import java.sql.ResultSet;

import model.UtenteBean.categoria;

public class UtenteImplementazioneDAO implements UtenteDAO{
	private static String username = "UserAzienda2";
	private static String password = "user";
	
	/**
     * Passare un'oggetto utente diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> nome
	     * <li> cognome
	     * <li> email
	     * <li> password
	     * <li> tipo dell'utente scelto dalla categoria definita
     * </ul>
     * 
     * @param   utente
     * @return  <ul>
     * 				<li>{@code true}: utente inserito correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato inserito
     *          </ul>
     */
	@Override
	public boolean inserisciUtente(UtenteBean utenteBean) {
		Query q = new Query();
		if(utenteBean.getNome() != null && utenteBean.getNome().length() <= 30 && utenteBean.getCognome() != null && utenteBean.getCognome().length() <= 30 && utenteBean.getEmail() != null && utenteBean.getEmail().length() <= 30 && utenteBean.getPassword() != null && utenteBean.getPassword().length() <= 20 && utenteBean.getTipo() != null ) {
			return q.updateQuery("INSERT INTO Utente (email, nome, cognome, password, tipo) VALUES ('" + utenteBean.getEmail() + "','" + utenteBean.getNome() + "','" + utenteBean.getCognome() + "','" + utenteBean.getPassword() + "','"+ utenteBean.getTipo() + "')", username, password);
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
     * @return  <ul>
     * 				<li>{@code true}: utente eliminato correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato eliminato
     *          </ul>
     */
	@Override
	public boolean rimuoviUtente(UtenteBean utenteBean) {
		Query q = new Query();
		if(utenteBean.getEmail() != null && utenteBean.getEmail().length() <= 30) {
			return q.controlloAndUpdateQueryUtente(utenteBean.getEmail(), "DELETE FROM Utente WHERE email = '" + utenteBean.getEmail() + "'", username, password);
		}
		return false;
	}

	/**
     * Passare un'oggetto utente diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> email
	     * <li> nome
     * </ul>
     * 
     * @param   utente
     * @return  <ul>
     * 				<li>{@code true}: modifica effettuata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato modificato
     *          </ul>
     */
	@Override
	public boolean modificaNome(UtenteBean utenteBean) {
		Query q = new Query();
		if(utenteBean.getEmail() != null && utenteBean.getEmail().length() <= 30 && utenteBean.getNome() != null && utenteBean.getNome().length() <= 30) {
			return q.controlloAndUpdateQueryUtente(utenteBean.getEmail(), "UPDATE Utente SET nome = '" + utenteBean.getNome() + "' WHERE email = '" + utenteBean.getEmail() + "'", username, password);
		}
		return false;
	}

	/**
     * Passare un'oggetto utente diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> email
	     * <li> cognome
     * </ul>
     * 
     * @param   utente
     * @return  <ul>
     * 				<li>{@code true}: modifica effettuata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato modificato
     *          </ul>
     */
	@Override
	public boolean modificaCognome(UtenteBean utenteBean) {
		Query q = new Query();
		if(utenteBean.getEmail() != null && utenteBean.getEmail().length() <= 30 && utenteBean.getCognome() != null && utenteBean.getCognome().length() <= 30) {
			return q.controlloAndUpdateQueryUtente(utenteBean.getEmail(), "UPDATE Utente SET cognome = '" + utenteBean.getCognome() + "' WHERE email = '" + utenteBean.getEmail() + "'", username, password);
		}
		return false;
	}

	/**
     * Passare un'oggetto utente diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> email
	     * <li> password
     * </ul>
     * 
     * @param   utente
     * @return  <ul>
     * 				<li>{@code true}: modifica effettuata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato modificato
     *          </ul>
     */
	@Override
	public boolean modificaPassword(UtenteBean utenteBean) {
		Query q = new Query();
		if(utenteBean.getEmail() != null) {
			System.out.println(utenteBean.getEmail()+" "+utenteBean.getPassword()); //per debugging
			return q.controlloAndUpdateQueryUtente(utenteBean.getEmail(), "UPDATE Utente SET password = '" + utenteBean.getPassword() + "' WHERE email = '" + utenteBean.getEmail() + "'", username, password);
		}
		return false;
	}
	
	@Override
	public boolean modificaIndirizzo(UtenteBean utenteBean) {
		Query q = new Query();
		if(utenteBean.getEmail() != null) {
			return q.controlloAndUpdateQueryUtente(utenteBean.getEmail(), "UPDATE Utente SET indirizzo = '" + utenteBean.getIndirizzo() + "' WHERE email = '" + utenteBean.getEmail() + "'", username, password);
		}
		return false;
	}
	
	public boolean modificaEmail(UtenteBean utenteBean) {
		Query q = new Query();
		if(utenteBean.getEmail() != null) {
			return q.controlloAndUpdateQueryUtente(utenteBean.getEmail(), "UPDATE Utente SET email = '" + utenteBean.getIndirizzo() + "' WHERE email = '" + utenteBean.getEmail() + "'", username, password);
		}
		return false;
	}

	/**
     * Passare un'oggetto utente diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> email
	     * <li> tipo dell'utente scelto dalla categoria definita
     * </ul>
     * 
     * @param   utente
     * @return  <ul>
     * 				<li>{@code true}: modifica effettuata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato modificato
     *          </ul>
     */
	@Override
	public boolean modificaTipo(UtenteBean utenteBean) {
		Query q = new Query();
		if(utenteBean.getEmail() != null && utenteBean.getEmail().length() <= 30 && utenteBean.getTipo() != null) {
			return q.controlloAndUpdateQueryUtente(utenteBean.getEmail(), "UPDATE Utente SET tipo = '" + utenteBean.getTipo() + "' WHERE email = '" + utenteBean.getEmail() + "'", username, password);
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
     * @return  <ul>
     * 				<li>{@code true}: l'utente è admin del sito
     *          	<li>{@code false}: l'utente NON è admin del sito
     *          </ul>
     */
	@Override
	public boolean isAdmin(UtenteBean utenteBean) {
		Connettore con = new Connettore();
		ResultSet result;
		
		if(utenteBean.getEmail() != null && utenteBean.getEmail().length() <= 30 ) {
			try {
				con.OpenConnection(username, password);
				result = con.getConnection().createStatement().executeQuery("SELECT * FROM Utente WHERE email = '" + utenteBean.getEmail() + "'");
				result.next();
				
				utenteBean.setTipo(categoria.valueOf(result.getString("tipo")));
				result.close();
				con.closeConnection();
			} catch (Exception e) {
				System.out.print("error dao implementazione");
			}	
		}
		if(utenteBean.getTipo() == categoria.valueOf("admin")) {
			return true;
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
     * @return  <ul>
     * 				<li>{@code true}: l'utente è un cliente registrato del sito
     *          	<li>{@code false}: l'utente NON è un cliente registrato del sito
     *          </ul>
     */
	@Override
	public boolean isCliente(UtenteBean utenteBean) {
		Connettore con = new Connettore();
		ResultSet result;
		
		if(utenteBean.getEmail() != null && utenteBean.getEmail().length() <= 30 ) {
			try {
				con.OpenConnection(username, password);
				result = con.getConnection().createStatement().executeQuery("SELECT * FROM Utente WHERE email = '" + utenteBean.getEmail() + "'");
				result.next();
				utenteBean.setTipo(categoria.valueOf(result.getString("tipo")));
				result.close();
				con.closeConnection();
			} catch (Exception e) {
				System.out.print("error dao implementazione");
			}	
		}
		if(utenteBean.getTipo() == categoria.valueOf("user")) {
			return true;
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
     * @return  <ul>
     * 				<li>{@code true}: l'utente è un cliente registrato del sito e quindi effettua la login
     *          	<li>{@code false}: l'utente NON è un cliente registrato del sito non fa la login
     *          </ul>
     */
	public boolean login(UtenteBean utenteBean) {
		Connettore con = new Connettore();
		ResultSet result;
		
		if(utenteBean.getEmail() != null) {
			try {
				con.OpenConnection(username, password);
				result = con.getConnection().createStatement().executeQuery("SELECT * FROM Utente WHERE email ='"+utenteBean.getEmail()+"' AND password='"+utenteBean.getPassword()+"';");
				if(result.next()) {
					utenteBean.setTipo(categoria.valueOf(result.getString("tipo")));
					utenteBean.setNome(result.getString("nome"));
					utenteBean.setCognome(result.getString("cognome"));
					return true;
				}
				result.close();
				con.closeConnection();
				return false;
			} catch (Exception e) {
				System.out.print("ERROR login");
				return false;
			}	
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
     * @return  void poichè aggiorna tutti i campi dell'oggetto utente che gli viene passato come input
     */
	@Override
	public void leggiSingoloUtente(UtenteBean utenteBean) {
		Connettore con = new Connettore();
		ResultSet result;
		
		if(utenteBean.getEmail() != null && utenteBean.getEmail().length() <= 30 ) {
			try {
				con.OpenConnection(username, password);
				result = con.getConnection().createStatement().executeQuery("SELECT * FROM Utente WHERE email = '" + utenteBean.getEmail() + "'");
				result.next();
				utenteBean.setNome(result.getString("nome"));
				utenteBean.setCognome(result.getString("cognome"));
				utenteBean.setEmail(result.getString("email"));
				utenteBean.setPassword(result.getString("password"));
				utenteBean.setTipo(categoria.valueOf(result.getString("tipo")));
				utenteBean.setIndirizzo(result.getString("indirizzo"));
				result.close();
				con.closeConnection();
			} catch (Exception e) {
				System.out.print("error dao implementazione");
			}	
		}
	}
}
