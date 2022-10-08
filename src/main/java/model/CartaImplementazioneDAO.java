package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CartaImplementazioneDAO {
	private static String username = "UserAzienda2";
	private static String password = "user";
	
	public boolean aggiungiCarta(CartaBEAN carta) {
		Query q = new Query();
		if(carta != null && carta.getNumero() != null) {
			return q.updateQuery("INSERT INTO Carta(scadenza, titolare, cvc, numero) VALUES (" + carta.getScadenza() + carta.getTitolare() + carta.getCvc() + carta.getNumero(), username, password);
		}
		return false;
	}
	
	public boolean rimuoviCarta(CartaBEAN carta) {
		Query q = new Query();
		return q.updateQuery("DELETE FROM Carta WHERE numero = " + carta.getNumero(), username, password);
	}
	
	public boolean pagamento(CartaBEAN carta) {
		Query q = new Query();
		Connettore con = new Connettore();
		ResultSet result;
		CartaBEAN c = new CartaBEAN();
		
		if(carta.getNumero() != null) {
			try {
				con.OpenConnection(username, password);
				result = con.getConnection().createStatement().executeQuery("SELECT numero FROM Carta ");
				result.next();
				
				c.setScadenza(result.getDate("scadenza"));
				c.setCvc((short)result.getInt("cvc"));
				c.setTitolare(result.getString("titolare"));
				c.setNumero(result.getString("numero"));
				result.close();
				con.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.print("error dao implementazione");
			}
			if(c.getTitolare() == carta.getTitolare() && c.getScadenza() == carta.getScadenza() && c.getNumero() == carta.getNumero() && c.getCvc() == carta.getCvc()) {
				return true;
			}
		}
		return false;
	}
	
}
