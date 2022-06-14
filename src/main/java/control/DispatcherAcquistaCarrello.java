package control;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Local;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import model.GestioneCarrello;
import model.OrdineBean;
import model.OrdineImplementazioneDAO;
import model.ProdottoBean;
import model.Session;
import model.UtenteBean;
import model.UtenteImplementazioneDAO;


/**
 * Servlet implementation class DispatcherAcquistaCarrello
 */
@WebServlet("/DispatcherAcquistaCarrello")
public class DispatcherAcquistaCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherAcquistaCarrello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrdineImplementazioneDAO orimp = new OrdineImplementazioneDAO();
		GestioneCarrello carrello = new GestioneCarrello();
		ProdottoBean pr;
		OrdineBean ordine = new OrdineBean();
		Session session = new Session();
		UtenteBean ut = new UtenteBean();
		UtenteImplementazioneDAO utimp = new UtenteImplementazioneDAO();
		JSONArray arr = carrello.leggi(request);
		LocalDate now = LocalDate.now();  
		LocalTime tim = LocalTime.now();
		
		for(int i = 0; i < arr.length(); i++) {
			JSONObject ob = new JSONObject(arr.getString(i));
			pr = new Gson().fromJson(ob.toString(), ProdottoBean.class);
			
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
			orimp.inserisciOrdine(ordine);
		}
		
		carrello.eliminaTutto(request);
		request.getRequestDispatcher("DispatcherFatture");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
