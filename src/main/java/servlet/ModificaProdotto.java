package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProdottoBean;
import implementazione.ProdottoImplementazioneDAO;

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
        int id=Integer.parseInt(request.getParameter("codice"));
        short shortId=(short) id;
        boolean b=dao.exists(shortId);

        dao.modificaDescrizione(p);
        dao.modificaPrezzo(p);

        if(b) 
            request.getRequestDispatcher("DispatcherGestisciCatalogo").forward(request, response);
        else request.getRequestDispatcher("DispatcherGestisciCatalogoError").forward(request, response);
	}

}
