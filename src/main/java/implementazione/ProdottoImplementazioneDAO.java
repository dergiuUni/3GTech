package implementazione;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import com.google.gson.Gson;

import bean.ProdottoBean;
import bean.ProdottoBean.categoria;
import dao.ProdottoDAO;
import database.*;

public class ProdottoImplementazioneDAO implements ProdottoDAO {
	private static String username = "UserAzienda2";
	private static String password = "user";
	
	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice
	     * <li> nome prodotto
	     * <li> tipo del prodotto scelto dalla categoria definita
	     * <li> descrizione
	     * <li> prezzo
	     * <li> quantità
	     * <li> dataInserimento
     * </ul>
     * 
     * @param   prodotto
     * @return  <ul>
     * 				<li>{@code true}: prodotto inserito correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato inserito
     *          </ul>
     */
	@Override
	public boolean inserisciProdotto(ProdottoBean prodottoBean) {
		if(prodottoBean.getPrezzo() <= 0) {
			return false;
		}
		Query q = new Query();
		return q.updateQuery("INSERT INTO Prodotto (nome, tipo, descrizione, prezzo, quantita, inserimento) VALUES ('" + prodottoBean.getNome() 
		+ "','" + String.valueOf(prodottoBean.getTipo()) + "','" + prodottoBean.getDescrizione() + "'," + prodottoBean.getPrezzo() 
		+ ", '1' ,'" + prodottoBean.getInserimento() + "');", username, password);
	}

	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice
     * </ul>
     * 
     * @param   prodotto
     * @return  <ul>
     * 				<li>{@code true}: prodotto eliminato correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato eliminato
     *          </ul>
     */
	@Override
	public boolean rimuoviProdotto(ProdottoBean prodottoBean) {
		Query q = new Query();
			return q.controlloAndUpdateQueryProdotto(prodottoBean.getCodice(), "DELETE FROM Prodotto WHERE codice = " + prodottoBean.getCodice(), username, password);
	}

	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice
	     * <li> descrizione
     * </ul>
     * 
     * @param   prodotto
     * @return  <ul>
     * 				<li>{@code true}: modifica effettuata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato modificato
     *          </ul>
     */
	@Override
	public boolean modificaDescrizione(ProdottoBean prodottoBean) {
		Query q = new Query();
		if(prodottoBean.getCodice() != 0 &&  prodottoBean.getDescrizione() != null && prodottoBean.getDescrizione().length() <= 300 ) {
			return q.controlloAndUpdateQueryProdotto(prodottoBean.getCodice(), "UPDATE Prodotto SET descrizione = '" + prodottoBean.getDescrizione() + "' WHERE codice = " + prodottoBean.getCodice(), username, password);
		}
		return false;
	}

	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice
	     * <li> nome
     * </ul>
     * 
     * @param   prodotto
     * @return  <ul>
     * 				<li>{@code true}: modifica effettuata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato modificato
     *          </ul>
     */
	@Override
	public boolean modificaNome(ProdottoBean prodottoBean) {
		Query q = new Query();
		if(prodottoBean.getCodice() != 0 && prodottoBean.getNome() != null && prodottoBean.getNome().length() <= 100 ) {
			return q.controlloAndUpdateQueryProdotto(prodottoBean.getCodice(), "UPDATE Prodotto SET nome = '" + prodottoBean.getNome() + "' WHERE codice = " + prodottoBean.getCodice(), username, password);
		}
		return false;
	}

	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice
	     * <li> prezzo
     * </ul>
     * 
     * @param   prodotto
     * @return  <ul>
     * 				<li>{@code true}: modifica effettuata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato modificato
     *          </ul>
     */
	@Override
	public boolean modificaPrezzo(ProdottoBean prodottoBean) {
		Query q = new Query();
		if(prodottoBean.getCodice() != 0 && prodottoBean.getPrezzo() != 0 ) {
			return q.controlloAndUpdateQueryProdotto(prodottoBean.getCodice(), "UPDATE Prodotto SET prezzo = " + prodottoBean.getPrezzo() + " WHERE codice = " + prodottoBean.getCodice(), username, password);
		}
		return false;
	}

	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice
	     * <li> tipo del prodotto scelto dalla categoria definita
     * </ul>
     * 
     * @param   prodotto
     * @return  <ul>
     * 				<li>{@code true}: modifica effettuata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato modificato
     *          </ul>
     */
	@Override
	public boolean modificaTipo(ProdottoBean prodottoBean) {
		Query q = new Query();
		if(prodottoBean.getCodice() != 0 && prodottoBean.getTipo() != null ) {
			return q.controlloAndUpdateQueryProdotto(prodottoBean.getCodice(), "UPDATE Prodotto SET tipo = '" + String.valueOf(prodottoBean.getTipo()) + "' WHERE codice = " + prodottoBean.getCodice(), username, password);
		}
		return false;
	}
	
	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice
	     * <li> quantità
     * </ul>
     * 
     * @param   prodotto
     * @return  <ul>
     * 				<li>{@code true}: modifica effettuata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato modificato
     *          </ul>
     */
	@Override
	public boolean modificaQuantita(ProdottoBean prodottoBean) {
		Query q = new Query();
		if(prodottoBean.getCodice() != 0 && prodottoBean.getQuantitaDB() != 0 ) {
			return q.controlloAndUpdateQueryProdotto(prodottoBean.getCodice(), "UPDATE Prodotto SET quantita = " + prodottoBean.getQuantitaDB() + " WHERE codice = " + prodottoBean.getCodice(), username, password);
		}
		return false;
	}
	
	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice
     * </ul>
     * 
     * @param   prodotto
     * @return  <ul>
     * 				<li>{@code true}: modifica effettuata correttamente
     *          	<li>{@code false}: ci sta un qualche problema generico e non è stato modificato
     *          </ul>
     */
	@Override
	public boolean decrementaQuantita(ProdottoBean prodottoBean) {
		Query q = new Query();
		Connettore con = new Connettore();
		ResultSet result;
		
		if(prodottoBean.getCodice() != 0) {
			try {
				con.OpenConnection(username, password);
				result = con.getConnection().createStatement().executeQuery("SELECT quantita FROM Prodotto WHERE codice = " + prodottoBean.getCodice());
				result.next();
				prodottoBean.setQuantitaDB(result.getInt("quantita"));
				result.close();
				con.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.print("error dao implementazione");
			}
			if(prodottoBean.getQuantitaDB() > 0) {
				prodottoBean.setQuantitaDB(prodottoBean.getQuantitaDB() - 1);
				return q.updateQuery("UPDATE Prodotto SET quantita = " + prodottoBean.getQuantitaDB() + " WHERE codice = " + prodottoBean.getCodice(), username, password);
			}
		}
		return false;
	}
	
	public int quantitaProdotti() {
		Connettore con = new Connettore();
		ResultSet result;
		try {
			con.OpenConnection(username, password);
			result = con.getConnection().createStatement().executeQuery("SELECT COUNT(codice) AS total FROM Prodotto");
			result.next();
			int quantita = result.getInt("total");
			result.close();
			con.closeConnection();
			return quantita;
		}
		catch (SQLException e) {
			System.out.print("error dao implementazione");
		}
		return 0;
	}
	
	/**
     * Passare un'oggetto prodotto diverso da null e con i seguenti campi inizializzati correttamente:
     * <ul>
	     * <li> codice
     * </ul>
     * 
     * @param   ordine
     * @return  void poichè aggiorna tutti i campi dell'oggetto prodotto che gli viene passato come input
     */
	@Override
	public void leggiSingoloProdotto(ProdottoBean prodottoBean) {
		Connettore con = new Connettore();
		ResultSet result;
		if(prodottoBean.getCodice() != 0) {
			try {
				con.OpenConnection(username, password);
				result = con.getConnection().createStatement().executeQuery("SELECT * FROM Prodotto WHERE codice = " + prodottoBean.getCodice());
				result.next();
				
				prodottoBean.setNome(result.getString("nome"));
				prodottoBean.setDescrizione(result.getString("descrizione"));
				prodottoBean.setPrezzo(result.getDouble("prezzo"));
				prodottoBean.setTipo(categoria.valueOf(result.getString("tipo")));
				prodottoBean.setQuantitaDB(result.getInt("quantita"));
				prodottoBean.setInserimento(result.getDate("inserimento"));
				result.close();
				con.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.print("Errore leggiSingoloProdotto");
			}
		}
	}

	/**
	 * legge tutti i prodotti contenuti nel db
     * @return  arraylist composto da oggetti prodotto con tutti i campi inizializzati 
     */
	@Override
	public JSONArray leggiProdotto() {
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Prodotto ");

			while (result.next()) {
				ProdottoBean p = new ProdottoBean(result.getString("nome"), result.getString("descrizione"), result.getDouble("prezzo"), categoria.valueOf(result.getString("tipo")),result.getInt("quantita"), result.getDate("inserimento"));
				p.setCodice(result.getShort("codice"));
				array.put(gson.toJson(p));
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
	
	@Override
	public JSONArray utimiInseriti() {
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Prodotto ORDER BY inserimento DESC");
			result.next();
			for(int i = 0; i < 3 && result != null; i++) {
				ProdottoBean p = new ProdottoBean(result.getString("nome"), result.getString("descrizione"), result.getDouble("prezzo"), categoria.valueOf(result.getString("tipo")), result.getInt("quantita"), result.getDate("inserimento"));
				p.setCodice(result.getShort("codice"));
				array.put(gson.toJson(p));
				result.next();
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
	
	@Override
	public JSONArray random() {
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Prodotto ORDER BY RAND() LIMIT 3");
			while(result.next()) {
				ProdottoBean p = new ProdottoBean(result.getString("nome"), result.getString("descrizione"), result.getDouble("prezzo"), categoria.valueOf(result.getString("tipo")), result.getInt("quantita"), result.getDate("inserimento"));
				p.setCodice(result.getShort("codice"));
				array.put(gson.toJson(p));
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
	
	public JSONArray videogameRandom() {
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Prodotto WHERE tipo = 'Videogame' ORDER BY RAND() LIMIT 3");
			while(result.next()) {
				ProdottoBean p = new ProdottoBean(result.getString("nome"), result.getString("descrizione"), result.getDouble("prezzo"), categoria.valueOf(result.getString("tipo")), result.getInt("quantita"), result.getDate("inserimento"));
				p.setCodice(result.getShort("codice"));
				array.put(gson.toJson(p));
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
	
	public JSONArray consoleRandom() {
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Prodotto WHERE tipo = 'Console' ORDER BY RAND() LIMIT 3");
			while(result.next()) {
				ProdottoBean p = new ProdottoBean(result.getString("nome"), result.getString("descrizione"), result.getDouble("prezzo"), categoria.valueOf(result.getString("tipo")), result.getInt("quantita"), result.getDate("inserimento"));
				p.setCodice(result.getShort("codice"));
				array.put(gson.toJson(p));
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
	
	public JSONArray computerRandom() {
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Prodotto WHERE tipo = 'Computer' ORDER BY RAND() LIMIT 3");
			while(result.next()) {
				ProdottoBean p = new ProdottoBean(result.getString("nome"), result.getString("descrizione"), result.getDouble("prezzo"), categoria.valueOf(result.getString("tipo")), result.getInt("quantita"), result.getDate("inserimento"));
				p.setCodice(result.getShort("codice"));
				array.put(gson.toJson(p));
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
	
	public JSONArray elettrodomesticiRandom() {
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Prodotto WHERE tipo = 'Elettrodomestici' ORDER BY RAND() LIMIT 3");
			while(result.next()) {
				ProdottoBean p = new ProdottoBean(result.getString("nome"), result.getString("descrizione"), result.getDouble("prezzo"), categoria.valueOf(result.getString("tipo")), result.getInt("quantita"), result.getDate("inserimento"));
				p.setCodice(result.getShort("codice"));
				array.put(gson.toJson(p));
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
	
	public JSONArray altroRandom() {
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Prodotto WHERE tipo = 'Altro' ORDER BY RAND() LIMIT 3");
			while(result.next()) {
				ProdottoBean p = new ProdottoBean(result.getString("nome"), result.getString("descrizione"), result.getDouble("prezzo"), categoria.valueOf(result.getString("tipo")), result.getInt("quantita"), result.getDate("inserimento"));
				p.setCodice(result.getShort("codice"));
				array.put(gson.toJson(p));
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
	
	public JSONArray utimiInseritiVideogame() {
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Prodotto WHERE tipo = 'Videogame' ORDER BY inserimento DESC");
			result.next();
			for(int i = 0; i < 3 && result != null; i++) {
				ProdottoBean p = new ProdottoBean(result.getString("nome"), result.getString("descrizione"), result.getDouble("prezzo"), categoria.valueOf(result.getString("tipo")), result.getInt("quantita"), result.getDate("inserimento"));
				p.setCodice(result.getShort("codice"));
				array.put(gson.toJson(p));
				result.next();
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
	
	public JSONArray utimiInseritiConsole() {
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Prodotto WHERE tipo = 'Console' ORDER BY inserimento DESC");
			result.next();
			for(int i = 0; i < 3 && result != null; i++) {
				ProdottoBean p = new ProdottoBean(result.getString("nome"), result.getString("descrizione"), result.getDouble("prezzo"), categoria.valueOf(result.getString("tipo")), result.getInt("quantita"), result.getDate("inserimento"));
				p.setCodice(result.getShort("codice"));
				array.put(gson.toJson(p));
				result.next();
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
	
	public JSONArray utimiInseritiComputer() {
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Prodotto WHERE tipo = 'Computer' ORDER BY inserimento DESC");
			result.next();
			for(int i = 0; i < 3 && result != null; i++) {
				ProdottoBean p = new ProdottoBean(result.getString("nome"), result.getString("descrizione"), result.getDouble("prezzo"), categoria.valueOf(result.getString("tipo")), result.getInt("quantita"), result.getDate("inserimento"));
				p.setCodice(result.getShort("codice"));
				array.put(gson.toJson(p));
				result.next();
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
	
	public JSONArray utimiInseritiElettrodomestici() {
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Prodotto WHERE tipo = 'Elettrodomestici' ORDER BY inserimento DESC");
			result.next();
			for(int i = 0; i < 3 && result != null; i++) {
				ProdottoBean p = new ProdottoBean(result.getString("nome"), result.getString("descrizione"), result.getDouble("prezzo"), categoria.valueOf(result.getString("tipo")), result.getInt("quantita"), result.getDate("inserimento"));
				p.setCodice(result.getShort("codice"));
				array.put(gson.toJson(p));
				result.next();
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
	
	public JSONArray utimiInseritiAltro() {
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM Prodotto WHERE tipo = 'Altro' ORDER BY inserimento DESC");
			result.next();
			for(int i = 0; i < 3 && result != null; i++) {
				ProdottoBean p = new ProdottoBean(result.getString("nome"), result.getString("descrizione"), result.getDouble("prezzo"), categoria.valueOf(result.getString("tipo")), result.getInt("quantita"), result.getDate("inserimento"));
				p.setCodice(result.getShort("codice"));
				array.put(gson.toJson(p));
				result.next();
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
	
	public JSONArray cerca(String cerco) {
		JSONArray array = new JSONArray();
		Gson gson = new Gson();
		Connettore con = new Connettore();
		
		try {
			con.OpenConnection(username, password);
			Statement st = con.getConnection().createStatement();
			ResultSet result = st.executeQuery("SELECT nome FROM Prodotto WHERE Prodotto.nome LIKE '%"+ cerco + "%'");
			result.next();
			for(int i = 0; i < 3 && result != null; i++) {
				ProdottoBean p = new ProdottoBean(result.getString("nome"), result.getString("descrizione"), result.getDouble("prezzo"), categoria.valueOf(result.getString("tipo")), result.getInt("quantita"), result.getDate("inserimento"));
				p.setCodice(result.getShort("codice"));
				p.setNome(result.getString("nome"));
				array.put(gson.toJson(p));
				result.next();
			}
			result.close();
			con.closeConnection();
			return array;
		} catch (SQLException e) {
			System.out.print("error dao implementazione");
			System.out.print(e);
		}
		return null;
	}
	
	public ArrayList<String> cerca2(String cerco) {
        if(cerco.length()<2) return null;
        ArrayList<String> array = new ArrayList<String>();
        Connettore con = new Connettore();

        try {
            con.OpenConnection(username, password);
            Statement st = con.getConnection().createStatement();
            ResultSet result = st.executeQuery("SELECT nome FROM Prodotto WHERE Prodotto.nome LIKE '%"+ cerco + "%'");
            while(result.next()) {
                array.add(result.getString("nome"));
            }
            result.close();
            con.closeConnection();
            if(array.size()>0) return array;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.print("error dao implementazione");
            System.out.print(e);
        }
        return null;
    }
	
	public Short getProdottoByName(String name) {
		Connettore con = new Connettore();
		ResultSet result;
		Short c=-1;
			try {
				con.OpenConnection(username, password);
				result = con.getConnection().createStatement().executeQuery("SELECT * FROM Prodotto WHERE nome = '" + name+"'");
				result.next();
				c= result.getShort("codice");
				result.close();
				con.closeConnection();
			} catch (SQLException e) {
				System.out.print("error dao implementazione");
	            System.out.print(e);
			}
			return c;
		}
	
	public boolean exists(short id) {
        Connettore con = new Connettore();
        ResultSet result;
        Short c=-1;
            try {
                con.OpenConnection(username, password);
                result = con.getConnection().createStatement().executeQuery("SELECT * FROM Prodotto WHERE codice = '" + id+"'");
                if(result.next())return true;
                else return false;
            } catch (SQLException e) {
                System.out.print("Errore in getProdottoByName\n");
                System.out.println(e.getMessage());
                return false;
            }
    }
	}