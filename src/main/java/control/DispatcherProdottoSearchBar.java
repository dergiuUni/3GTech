package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProdottoImplementazioneDAO;

/**
 * Servlet implementation class DispatcherProdottoSearchBar
 */
@WebServlet("/DispatcherProdottoSearchBar")
public class DispatcherProdottoSearchBar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdottoImplementazioneDAO dao = new ProdottoImplementazioneDAO();
		Short codice=dao.getProdottoByName(request.getParameter("name"));
		request.getRequestDispatcher("DispatcherProdottoServlet?id="+codice).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
