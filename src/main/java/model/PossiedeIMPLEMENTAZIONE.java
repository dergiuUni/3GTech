package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;

import com.google.gson.Gson;

import model.ProdottoBean.categoria;

public class PossiedeIMPLEMENTAZIONE {
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
			System.out.print("error dao implementazione");
			System.out.print(e);
		}
		return null;
	}
}
