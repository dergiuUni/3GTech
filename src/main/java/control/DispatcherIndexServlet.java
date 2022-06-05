package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.mysql.cj.xdevapi.JsonArray;

import model.OrdineBean;
import model.OrdineImplementazioneDAO;
import model.ProdottoBean;
import model.ProdottoImplementazioneDAO;

/**
 * Servlet implementation class IndexGlobalServlet
 */
@WebServlet("/index")
public class DispatcherIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProdottoImplementazioneDAO prodottoImplementato = new ProdottoImplementazioneDAO();
		
		request.setAttribute("prodottiNuovi", prodottoImplementato.utimiInseriti());
		request.setAttribute("prodottiRandom", prodottoImplementato.random());
		
		/*
		JSONArray arr = prodottoImplementato.random();
		for(int i = 0; i < arr.length(); i++) {
			JSONObject ob = new JSONObject(arr.getString(i));
			System.out.print("\n" + arr.getString(i));
			System.out.print("\n" + ob.getString("nome"));
			//System.out.print("\n" + ob.getString("descrizione"));
			System.out.print("\n" + ob.getInt("codice"));
		}
		*/
		
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
