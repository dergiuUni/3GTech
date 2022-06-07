package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProdottoImplementazioneDAO;

/**
 * Servlet implementation class ElettrodomesticiServlet
 */
@WebServlet("/ElettrodomesticiServlet")
public class ElettrodomesticiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElettrodomesticiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdottoImplementazioneDAO prodottoImplementato = new ProdottoImplementazioneDAO();
		request.setAttribute("prodottiNuovi", prodottoImplementato.utimiInseritiElettrodomestici().toString());
		request.setAttribute("prodottiRandom", prodottoImplementato.elettrodomesticiRandom().toString());
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
