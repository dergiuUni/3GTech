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
		//request.setAttribute("listaCarrello", carrello.leggi(request));
		//request.getRequestDispatcher("/WEB-INF/carrello.jsp").forward(request, response);
		
		carrello.aggiungiElemento(request, (short)1, 1);
		carrello.aggiungiElemento(request, (short)3, 1);
		carrello.aggiungiElemento(request, (short)2, 3);
		carrello.aggiungiElemento(request, (short)1, 2);
		
		System.out.print(request.getSession().getAttribute("utente"));
		JSONArray arr = carrello.leggi(request);
		//System.out.print(arr);
		
		if(arr.length() != 0) {
			for(int i = 0; i < arr.length(); i++) {
				JSONObject ob = new JSONObject(arr.getString(i));
				System.out.print("\n" + arr.getString(i));
				System.out.print("\n" + ob.getInt("codice"));
				System.out.print("\n" + ob.getInt("quantita"));
				System.out.print("\n" + ob.getString("nome"));
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
