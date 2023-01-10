package dispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementazione.ProdottoImplementazioneDAO;

@WebServlet("/DispatcherIndexVideogameServlet")
public class VideogameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VideogameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdottoImplementazioneDAO prodottoImplementato = new ProdottoImplementazioneDAO();
		request.setAttribute("prodottiNuovi", prodottoImplementato.utimiInseritiVideogame().toString());
		request.setAttribute("prodottiRandom", prodottoImplementato.videogameRandom().toString());
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
