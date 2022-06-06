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
	public boolean aggiungiElemento(HttpServletRequest request, short codice, int quantita) {
		Session session = new Session();
		JSONArray arr;
		ProdottoBean pr = new ProdottoBean();
		Gson gson = new Gson();
		
		if(session.isInizializzatoCarrello(request) == true) {
			arr = new JSONArray(session.leggiCarrello(request));
			pr.setCodice(codice);
			pr.setQuantitaCarrello(quantita);
			arr.put(gson.toJson(pr));
			session.inserisciCarrello(request, arr.toString());
			return true;
		}
		else {
			arr = new JSONArray();
			pr.setCodice(codice);
			pr.setQuantitaCarrello(quantita);
			arr.put(gson.toJson(pr));
			session.inserisciCarrello(request, arr.toString());
			return true;
		}
	}
	
	public boolean modificaQuantita(HttpServletRequest request, short codice, int quantita) {
		Session session = new Session();
		JSONArray arr;
		Gson gson = new Gson();
		
		if(session.isInizializzatoCarrello(request) == true) {
			arr = new JSONArray(session.leggiCarrello(request));
			for(int i = 0; i < arr.length(); i++) {
				JSONObject ob = new JSONObject(arr.getString(i));
				ProdottoBean pr = new Gson().fromJson(ob.toString(), ProdottoBean.class);
				if(pr.getCodice() == codice) {
					pr.setQuantitaCarrello(quantita);
					arr.remove(i);
					arr.put(gson.toJson(pr));
					session.inserisciCarrello(request, arr.toString());
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean incrementaQauntitaDiUno(HttpServletRequest request, short codice) {
		Session session = new Session();
		JSONArray arr;
		Gson gson = new Gson();
		
		if(session.isInizializzatoCarrello(request) == true) {
			arr = new JSONArray(session.leggiCarrello(request));
			for(int i = 0; i < arr.length(); i++) {
				JSONObject ob = new JSONObject(arr.getString(i));
				ProdottoBean pr = new Gson().fromJson(ob.toString(), ProdottoBean.class);
				if(pr.getCodice() == codice) {
					pr.setQuantitaCarrello(pr.getQuantitaCarrello() + 1);
					arr.remove(i);
					arr.put(gson.toJson(pr));
					session.inserisciCarrello(request, arr.toString());
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean eliminaElemento(HttpServletRequest request, short codice) {
		Session session = new Session();
		JSONArray arr;
		Gson gson = new Gson();
		
		if(session.isInizializzatoCarrello(request) == true) {
			arr = new JSONArray(session.leggiCarrello(request));
			for(int i = 0; i < arr.length(); i++) {
				JSONObject ob = new JSONObject(arr.getString(i));
				ProdottoBean pr = new Gson().fromJson(ob.toString(), ProdottoBean.class);
				if(pr.getCodice() == codice) {
					arr.remove(i);
					session.inserisciCarrello(request, arr.toString());
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean eliminaTutto(HttpServletRequest request) {
		Session session = new Session();
		return session.azzeraCarrello(request);
	}
	
	public JSONArray leggi(HttpServletRequest request) {
		Session session = new Session();
		JSONArray arr;
		JSONArray arr2 = new JSONArray();
		Gson gson = new Gson();
		
		if(session.isInizializzatoCarrello(request) == true) {
			arr = new JSONArray(session.leggiCarrello(request));
			for(int i = 0; i < arr.length(); i++) {
				JSONObject ob = new JSONObject(arr.getString(i));
				ProdottoBean pr = new Gson().fromJson(ob.toString(), ProdottoBean.class);
				ProdottoImplementazioneDAO primp = new ProdottoImplementazioneDAO();
				primp.leggiSingoloProdotto(pr);
				arr2.put(gson.toJson(pr));
			}
			return arr2;
		}
		return null;
	}
}