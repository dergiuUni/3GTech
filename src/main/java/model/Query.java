package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Query {
	public Query() {}
	
	public boolean updateQuery(String query, String email, String password) {
		try {
			Connection con=ConnectionPool.getConnection(email, password);
			con.createStatement().executeUpdate(query);
			ConnectionPool.releaseConnection(con);
			return true;
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean controlloAndUpdateQueryProdotto(Short codice, String query, String email, String password) {
		try {
			Connection con=ConnectionPool.getConnection(email, password);
			ResultSet result = con.createStatement().executeQuery("SELECT count(codice) FROM Prodotto WHERE codice = " + codice);
			result.next();
			if(result.getInt(1) >= 0) {
				con.createStatement().executeUpdate(query);
			}
			result.close();
			ConnectionPool.releaseConnection(con);
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
			System.out.print("Provo a chiamare ConnectionPool");
			Connection con=ConnectionPool.getConnection(email, password);
			ResultSet result = con.createStatement().executeQuery("SELECT count(email) FROM Utente WHERE email = '" + emailUtente + "'");
			result.next();
			if(result.getInt(1) >= 0) {
				con.createStatement().executeUpdate(query);
			}
			result.close();
			ConnectionPool.releaseConnection(con);
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
			System.out.print("Provo a chiamare ConnectionPool");
			Connection con=ConnectionPool.getConnection(email, password);
			ResultSet result = con.createStatement().executeQuery("SELECT count(idOrdine) FROM Ordine WHERE idOrdine = " + id);
			result.next();
			if(result.getInt(1) >= 0) {
				con.createStatement().executeUpdate(query);
			}
			result.close();
			ConnectionPool.releaseConnection(con);
			return true;
		}
		catch(Exception e) {
			System.out.print("error qui");
			System.out.print(e);
		}
		return false;
	}
}
