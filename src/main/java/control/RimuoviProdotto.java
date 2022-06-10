package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProdottoBean;
import model.ProdottoImplementazioneDAO;

@WebServlet("/RimuoviProdotto")
public class RimuoviProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdottoBean p=new ProdottoBean();
		p.setCodice(Short.parseShort(request.getParameter("codice")));
		
		ProdottoImplementazioneDAO dao=new ProdottoImplementazioneDAO();
		dao.rimuoviProdotto(p);
		request.getRequestDispatcher("DispatcherGestisciCatalogo").forward(request, response);

	}

}
