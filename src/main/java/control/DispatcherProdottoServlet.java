package control;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.ProdottoBean;
import model.ProdottoImplementazioneDAO;

/**
 * Servlet implementation class DispatcherProdottoServlet
 */
@WebServlet("/DispatcherProdottoServlet")
public class DispatcherProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherProdottoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//mi serve il codice del prodotto cosi riaccedo al db per ricavare le info da passare alla jsp
		ProdottoBean prodotto = new ProdottoBean();
		ProdottoImplementazioneDAO dao = new ProdottoImplementazioneDAO();
		prodotto.setCodice(Short.valueOf((String)request.getParameter("id")));
		dao.leggiSingoloProdotto(prodotto);
		request.setAttribute("prodotto", prodotto);
		request.getRequestDispatcher("WEB-INF/prodotto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
