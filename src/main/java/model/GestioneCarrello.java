package model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.Caret;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonParser;

import model.ProdottoBean.categoria;



public class GestioneCarrello {
	
	public JSONArray leggi(HttpServletRequest request){
		try {
			Session session = new Session();
			String carrelloSession = session.leggiCarrello(request);
			if(carrelloSession != null) {
				JSONArray jsonArray = new JSONArray(carrelloSession);
				JSONArray carrello = new JSONArray();
				Gson gson = new Gson();
				ProdottoImplementazioneDAO primpl = new ProdottoImplementazioneDAO();
				
					for(int i = 0; i < jsonArray.length(); i++) {
						ProdottoBean pr = new ProdottoBean();
						JSONObject jsonObject = jsonArray.getJSONObject(i);
						pr.setCodice(Short.valueOf(jsonObject.getString("codice")));
						//pr.setQuantitaCarrello(Integer.parseInt(jsonObject.getString("quantita")));
						primpl.leggiSingoloProdotto(pr);
						carrello.put(gson.toJson(pr));
					}
					return carrello;
			}
		}
		catch (Exception e) {
			System.out.print("errore lettura");
			System.out.print(e);
		}
		return null;
	}
	
	public boolean aggiungiElemento(HttpServletRequest request, short codice, int quantita) {
		Session session = new Session();
		JSONArray arr;
		Gson gson = new Gson();
		
		try {
			if(session.isInizializzatoCarrello(request) == true) {
				arr = new JSONArray(session.leggiCarrello(request));
				for(int i = 0; i < arr.length(); i++) {
					JSONObject ob = new JSONObject(arr.getString(i));
					if(ob.getInt("codice") == codice) {
						arr.remove(i);
						ob.put("quantita", quantita);
						arr.put(ob);
						session.inserisciCarrello(request, arr.toString());
						return true;
					}
				}
				ProdottoBean pr = new ProdottoBean();
				pr.setCodice(codice);
				pr.setQuantitaCarrello(quantita);
				arr.put(gson.toJson(pr));
				session.inserisciCarrello(request, arr.toString());
			}
			else {
				arr = new JSONArray();
				ProdottoBean pr = new ProdottoBean();
				pr.setCodice(codice);
				pr.setQuantitaCarrello(quantita);
				arr.put(gson.toJson(pr));
				session.inserisciCarrello(request, arr.toString());
			}
			return true;
		}
		catch (Exception e) {
			System.out.print("errore aggiunta");
			System.out.print(e);
		}
		return false;
	}
	
	public boolean incrementaUnoQuantita(HttpServletRequest request, short codice) {
		Session session = new Session();
		JSONArray carrelloJson;
		
		if(session.isInizializzatoCarrello(request) == true) {
			carrelloJson = new JSONArray(session.leggiCarrello(request));
			for(int i = 0; i < carrelloJson.length(); i++) {
				JSONObject ob = carrelloJson.getJSONObject(i);
				if(ob.getString("codice") == String.valueOf(codice)) {
					int q = Integer.valueOf(ob.getString("quantita"));
					q = q + 1;
					ob.put("quantita", String.valueOf(String.valueOf(q)));
					session.inserisciCarrello(request, carrelloJson.toString());
					return true;
				}
			}
			aggiungiElemento(request, codice, 1);
		}
		return false;
	}
	
	public boolean eliminaElemento(HttpServletRequest request, short codice) {
		Session session = new Session();
		JSONArray carrelloJson;
		
		if(session.isInizializzatoCarrello(request) == true) {
			carrelloJson = new JSONArray(session.leggiCarrello(request));
			for(int i = 0; i < carrelloJson.length(); i++) {
				JSONObject ob = carrelloJson.getJSONObject(i);
				if(ob.getString("codice") == String.valueOf(codice)) {
					carrelloJson.remove(i);
					session.inserisciCarrello(request, carrelloJson.toString());
				}
			}
			return true;
		}
		return false;
	}
	
	public boolean eliminaTutto(HttpServletRequest request) {
		Session session = new Session();
		return session.azzeraCarrello(request);
	}
}

//perche usare array list quando posso usare direttamente il json? modificare il tutto computer scaarico