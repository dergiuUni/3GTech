package implementazione;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;

import com.google.gson.Gson;

import bean.UtenteBean;
import bean.CartaBEAN;
import database.*;
import dao.PossiedeDAO;

public class PossiedeImplementazioneDAO implements PossiedeDAO{
	private static String username = "UserAzienda2";
	private static String password = "user";
	
	public JSONArray carteUtente(UtenteBean utente) {
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT Carta.numero FROM Carta, Possiede WHERE Possiede.emailUtente = " + utente.getEmail());
			while(result.next()) {
				CartaBEAN c = new CartaBEAN();
				c.setNumero(result.getString("numero"));
				array.put(gson.toJson(c));
			}
			result.close();
			con.closeConnection();
			return array;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error dao implementazione " + e);
		}
		return null;
	}
	
	public boolean inserisciCarta(UtenteBean utente, CartaBEAN carta) {
		Connettore con = new Connettore();
		con.OpenConnection(username, password);
		try {
			con.getConnection().createStatement().executeUpdate("INSERT INTO Possiede(emailUtente, numeroCarta) VALUES ('" + utente.getEmail() + "','" + carta.getNumero() + "')");
			return true;
		} catch (SQLException e) {
			System.out.println("errore inserimento possiese " + e);
		}
		return false;
	}
}
