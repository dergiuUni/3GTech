package implementazione;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import bean.CartaBEAN;
import bean.UtenteBean;
import dao.CartaDAO;
import database.*;

public class CartaImplementazioneDAO implements CartaDAO {
	private static String username = "UserAzienda2";
	private static String password = "user";
	
	public boolean aggiungiCarta(CartaBEAN carta, UtenteBean utente) {
		Query q = new Query();
		if(carta != null && carta.getNumero() != null && carta.getScadenza() != null && carta.getTitolare() != null && carta.getCvc() != 0 && utente != null && utente.getEmail() != null) {
			if( q.updateQuery("INSERT INTO Carta(scadenza, titolare, cvc, numero) VALUES (" + carta.getScadenza() + carta.getTitolare() + carta.getCvc() + carta.getNumero(), username, password) == true) {
				PossiedeImplementazioneDAO pos = new PossiedeImplementazioneDAO();
				return pos.inserisciCarta(utente, carta);
			}
		}
		return false;
	}
	
	public boolean rimuoviCarta(CartaBEAN carta) {
		Query q = new Query();
		if(carta != null && carta.getNumero() != null) {
			return q.updateQuery("DELETE FROM Carta WHERE numero = " + carta.getNumero(), username, password);
		}
		return false;
	}
	
	public boolean exists(CartaBEAN carta) {
		Connettore con = new Connettore();
		ResultSet result;
		
		if(carta.getNumero() != null) {
			try {
				con.OpenConnection(username, password);
				result = con.getConnection().createStatement().executeQuery("SELECT * FROM Carta WHERE numero = '" + carta.getNumero() + "'");
				
				while(result.next()) {
					return true;
				}
				
				result.close();
				con.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.print("error dao implementazione");
			}
		}
		return false;
	}
	
	public boolean pagamento(CartaBEAN carta) {
		Connettore con = new Connettore();
		ResultSet result;
		CartaBEAN c = new CartaBEAN();
		
		if(carta.getNumero() != null) {
			try {
				con.OpenConnection(username, password);
				result = con.getConnection().createStatement().executeQuery("SELECT * FROM Carta ");
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
			if((c.getTitolare().compareTo(carta.getTitolare()) == 0)  && c.getScadenza().compareTo(carta.getScadenza()) == 0  && c.getNumero().compareTo(carta.getNumero()) == 0 && c.getCvc() == carta.getCvc()) {
				return true;
			}
		}
		return false;
	}
	
}
