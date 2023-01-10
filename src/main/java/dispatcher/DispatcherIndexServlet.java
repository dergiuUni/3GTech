package dispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementazione.ProdottoImplementazioneDAO;

@WebServlet("/index")
public class DispatcherIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherIndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdottoImplementazioneDAO prodottoImplementato = new ProdottoImplementazioneDAO();
		
		request.setAttribute("prodottiNuovi", prodottoImplementato.utimiInseriti().toString());
		request.setAttribute("prodottiRandom", prodottoImplementato.random().toString());
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
