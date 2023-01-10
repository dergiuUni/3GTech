package dispatcher;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import bean.CartaBEAN;
import bean.OrdineBean;
import bean.ProdottoBean;
import bean.UtenteBean;
import carrello.GestioneCarrello;
import implementazione.CartaImplementazioneDAO;
import implementazione.OrdineImplementazioneDAO;
import implementazione.UtenteImplementazioneDAO;
import sessione.*;

@WebServlet("/DispatcherConfermaPagamento")
public class DispatcherConfermaPagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherConfermaPagamento() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GestioneCarrello carrello = new GestioneCarrello();
		ProdottoBean pr;
		Session session = new Session();
		UtenteBean ut = new UtenteBean();
		UtenteImplementazioneDAO utimp = new UtenteImplementazioneDAO();
		JSONArray arr = carrello.leggi(request);
		CartaBEAN cr = new CartaBEAN();
		CartaImplementazioneDAO crimp = new CartaImplementazioneDAO();
		OrdineImplementazioneDAO orimp = new OrdineImplementazioneDAO();
		JSONArray list = new JSONArray();
		Gson gson = new Gson();
		
		 if(arr != null) {
			cr.setScadenza(Date.valueOf(request.getParameter("scadenza").toString()));
			cr.setTitolare(request.getParameter("email").toString());
			cr.setCvc(Short.parseShort(request.getParameter("cvc").toString()));
			cr.setNumero(request.getParameter("numero").toString());
			
			if(crimp.exists(cr) == false) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("WEB-INF/fattura2.jsp").forward(request, response);
				return;
			}
			
			for(int i = 0; i < arr.length(); i++) {
				OrdineBean ordine = new OrdineBean();
				JSONObject ob = new JSONObject(arr.getString(i));
				pr = new Gson().fromJson(ob.toString(), ProdottoBean.class);
				LocalDate now = LocalDate.now();  
				LocalTime tim = LocalTime.now();
				
				
				ordine.setDataOrdine(Date.valueOf(now.getYear() + "-" + now.get(ChronoField.MONTH_OF_YEAR) + "-" + now.get(ChronoField.DAY_OF_MONTH)));
				ordine.setOrarioOrdine(Time.valueOf(tim));
				ordine.setProdotto(pr);
				ordine.setPrezzoProdotto(pr.getPrezzo());
				ordine.setQuantitaProdotto(pr.getQuantitaCarrello());
				ordine.setIvaProdotto(10); 
				ut.setEmail(session.getEmail(request));
				utimp.leggiSingoloUtente(ut);
				ordine.setUtente(ut);
				ordine.setIndirizzo(ut.getIndirizzo()); 
				ordine.setCarta(cr);
				ordine.setId(orimp.inserisciOrdine(ordine));
				list.put(gson.toJson(ordine));
			}
		}
		session.azzeraCarrello(request);
		request.setAttribute("list", list);
		request.getRequestDispatcher("WEB-INF/fattura2.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}


