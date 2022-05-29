package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrdineBean;
import model.OrdineImplementazioneDAO;
import model.ProdottoBean;
import model.ProdottoImplementazioneDAO;

/**
 * Servlet implementation class IndexGlobalServlet
 */
@WebServlet("/index")
public class IndexGlobalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexGlobalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProdottoBean prodottoBean = new ProdottoBean();
		ProdottoImplementazioneDAO prodottoImplementato = new ProdottoImplementazioneDAO();
		ArrayList<ProdottoBean> prodottiNuovi = new ArrayList<ProdottoBean>();
		ArrayList<ProdottoBean> prodottiOfferta = new ArrayList<ProdottoBean>();
		/*
		for(int i = 0; i < 2; i++) {
			prodottoBean.setCodice((short)(Math.random()*prodottoImplementato.quantitàProdotti()));
			prodottoImplementato.leggiSingoloProdotto(prodottoBean);
			prodottiNuovi.add(prodottoBean);
		}
		*/
		for(short i = 1; i < 3; i++) {
			prodottoBean.setCodice(/*(short)(Math.random()*prodottoImplementato.quantitàProdotti())*/i);
			prodottoImplementato.leggiSingoloProdotto(prodottoBean);
			prodottiOfferta.add(prodottoBean);
		}
		
		//request.setAttribute("nuoviProdotti", prodottiNuovi);
		request.setAttribute("offertaProdotti", prodottiOfferta);
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
