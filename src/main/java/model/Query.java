package model;

import java.sql.ResultSet;

public class Query {
	public Query() {
		
	}
	
	public boolean updateQuery(String query, String email, String password) {
		Connettore con = new Connettore();
		try {
			con.OpenConnection(email, password);
			con.getConnection().createStatement().executeUpdate(query);
			con.closeConnection();
			return true;
		}
		catch(Exception e) {
			System.out.print("error update query");
			System.out.print(e);
		}
		return false;
	}
	
	public boolean controlloAndUpdateQueryProdotto(Short codice, String query, String email, String password) {
		Connettore con = new Connettore();
		try {
			con.OpenConnection(email, password);
			ResultSet result = con.getConnection().createStatement().executeQuery("SELECT count(codice) FROM Prodotto WHERE codice = " + codice);
			result.next();
			if(result.getInt(1) >= 0) {
				con.getConnection().createStatement().executeUpdate(query);
			}
			result.close();
			con.closeConnection();
			return true;
		}
		catch(Exception e) {
			System.out.print("error qui");
			System.out.print(e);
		}
		return false;
	}

	public boolean controlloAndUpdateQueryUtente(String emailUtente, String query, String email, String password) {
		Connettore con = new Connettore();
		try {
			con.OpenConnection(email, password);
			ResultSet result = con.getConnection().createStatement().executeQuery("SELECT count(email) FROM Utente WHERE email = '" + emailUtente + "'");
			result.next();
			if(result.getInt(1) >= 0) {
				con.getConnection().createStatement().executeUpdate(query);
			}
			result.close();
			con.closeConnection();
			return true;
		}
		catch(Exception e) {
			System.out.print("error qui");
			System.out.print(e);
		}
		return false;
	}
	
	public boolean controlloAndUpdateQueryOrdine(int id, String query, String email, String password) {
		Connettore con = new Connettore();
		try {
			con.OpenConnection(email, password);
			ResultSet result = con.getConnection().createStatement().executeQuery("SELECT count(idOrdine) FROM Ordine WHERE idOrdine = " + id);
			result.next();
			if(result.getInt(1) >= 0) {
				con.getConnection().createStatement().executeUpdate(query);
			}
			result.close();
			con.closeConnection();
			return true;
		}
		catch(Exception e) {
			System.out.print("error qui");
			System.out.print(e);
		}
		return false;
	}
}
