package dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProdottoBean;
import implementazione.ProdottoImplementazioneDAO;

@WebServlet("/DispatcherProdottoServlet")
public class DispatcherProdottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherProdottoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdottoBean prodotto = new ProdottoBean();
		ProdottoImplementazioneDAO dao = new ProdottoImplementazioneDAO();
		
		prodotto.setCodice(Short.valueOf((String)request.getParameter("id")));
		dao.leggiSingoloProdotto(prodotto);
		
		request.setAttribute("prodotto", prodotto);
		request.setAttribute("prodottiRandom", dao.random().toString());
		request.getRequestDispatcher("WEB-INF/prodotto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
