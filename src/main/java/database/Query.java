package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Query {
	public Query() {}
	
	public boolean updateQuery(String query, String username, String password) {
		try {
			Connettore connettore = new Connettore();
			connettore.OpenConnection(username, password);
			connettore.getConnection().createStatement().executeUpdate(query);
			connettore.closeConnection();
			return true;
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean controlloAndUpdateQueryProdotto(Short codice, String query, String email, String password) {
		try {
			Connettore connettore = new Connettore();
			connettore.OpenConnection(email, password);
			ResultSet result = connettore.getConnection().createStatement().executeQuery("SELECT count(codice) FROM Prodotto WHERE codice = " + codice);
			result.next();
			if(result.getInt(1) > 0) {
				connettore.getConnection().createStatement().executeUpdate(query);
			}
			else {
				result.close();
				connettore.closeConnection();
				return false;
			}
			result.close();
			connettore.closeConnection();
			return true;
		}
		catch(Exception e) {
			System.out.print("error qui");
			System.out.print(e);
		}
		return false;
	}

	public boolean controlloAndUpdateQueryUtente(String emailUtente, String query, String email, String password) {
		try {
			Connettore connettore = new Connettore();
			connettore.OpenConnection(email, password);
			
			ResultSet result = connettore.getConnection().createStatement().executeQuery("SELECT count(email) FROM Utente WHERE email = '" + emailUtente + "'");
			result.next();
			if(result.getInt(1) >= 0) {
				connettore.getConnection().createStatement().executeUpdate(query);
			}
			result.close();
			connettore.closeConnection();
			return true;
		}
		catch(Exception e) {
			System.out.print("error qui");
			System.out.print(e);
		}
		return false;
	}
	
	public boolean controlloAndUpdateQueryOrdine(int id, String query, String email, String password) {
		try {
			Connettore connettore = new Connettore();
			connettore.OpenConnection(email, password);
			
			ResultSet result = connettore.getConnection().createStatement().executeQuery("SELECT count(idOrdine) FROM Ordine WHERE idOrdine = " + id);
			result.next();
			if(result.getInt(1) >= 0) {
				connettore.getConnection().createStatement().executeUpdate(query);
			}
			result.close();
			connettore.closeConnection();
			return true;
		}
		catch(Exception e) {
			System.out.print("error qui");
			System.out.print(e);
		}
		return false;
	}
}
