package dispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementazione.ProdottoImplementazioneDAO;

@WebServlet("/DispatcherElenco")
public class DispatcherElenco extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdottoImplementazioneDAO pr = new ProdottoImplementazioneDAO();
		request.setAttribute("elenco", pr.leggiProdotto());
		request.getRequestDispatcher("/WEB-INF/elenco.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/elenco.jsp").forward(request, response);;
	}

}
