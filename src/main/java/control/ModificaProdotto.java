package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProdottoBean;
import model.ProdottoImplementazioneDAO;

@WebServlet("/ModificaProdotto")
public class ModificaProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdottoBean p=new ProdottoBean();
		p.setCodice(Short.parseShort(request.getParameter("codice")));
		p.setDescrizione(request.getParameter("descrizione"));
		p.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
		
		ProdottoImplementazioneDAO dao=new ProdottoImplementazioneDAO();
		if(p.getDescrizione()!="") dao.modificaDescrizione(p);
		if(p.getPrezzo()!=0) dao.modificaPrezzo(p);
		request.getRequestDispatcher("DispatcherGestisciCatalogo").forward(request, response);
	}

}
