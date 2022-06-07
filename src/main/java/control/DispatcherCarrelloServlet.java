package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.cj.xdevapi.JsonArray;

import model.GestioneCarrello;
import model.Session;
import model.ProdottoBean;
/**
 * Servlet implementation class DispatcherCarrelloServlet
 */
@WebServlet("/DispatcherCarrelloServlet")
public class DispatcherCarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherCarrelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestioneCarrello carrello = new GestioneCarrello();
		Session session = new Session();
		
		if(session.leggiCarrello(request) != null) {
			request.setAttribute("listaCarrello", carrello.leggi(request).toString());
		}
		else {
			request.setAttribute("listaCarrello", "[]");
		}
		
		request.getRequestDispatcher("/WEB-INF/carrello.jsp").forward(request, response);
		/*
		session.azzeraCarrello(request);
		carrello.aggiungiElemento(request, (short)1, 1);
		carrello.aggiungiElemento(request, (short)2, 1);
		carrello.aggiungiElemento(request, (short)3, 3);
		carrello.aggiungiElemento(request, (short)4, 2);
		
		carrello.eliminaElemento(request, (short)3);
		JSONArray arr = carrello.leggi(request);
		for(int i = 0; i < arr.length(); i++) {
			JSONObject ob = new JSONObject(arr.getString(i));
			System.out.print("\n");
			System.out.print(ob);
		}
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
