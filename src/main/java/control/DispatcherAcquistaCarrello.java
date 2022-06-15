package control;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		Session session = new Session();
		UtenteBean ut = new UtenteBean();
		UtenteImplementazioneDAO utimp = new UtenteImplementazioneDAO();
		JSONArray arr = carrello.leggi(request);
		
		ArrayList<OrdineBean> list=new ArrayList<OrdineBean>();
		if(arr != null) {
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
				int id=orimp.inserisciOrdine(ordine);
				ordine.setId(id);
				list.add(ordine);
				System.out.println(pr.getCodice());
			}
		}
		request.setAttribute("list", list);
		carrello.eliminaTutto(request);
		request.getRequestDispatcher("WEB-INF/fattura.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
