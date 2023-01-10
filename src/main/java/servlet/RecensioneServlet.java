package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProdottoBean;
import bean.RecensioneBEAN;
import implementazione.RecensioneImplementazioneDAO;
import bean.UtenteBean;
import implementazione.UtenteImplementazioneDAO;

@WebServlet("/Recensione")
public class RecensioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecensioneBEAN r=new RecensioneBEAN();
		RecensioneImplementazioneDAO dao=new RecensioneImplementazioneDAO();
		ProdottoBean p=(ProdottoBean)request.getSession().getAttribute("prodotto");
		String email=((String)request.getSession().getAttribute("email"));
		UtenteBean u=new UtenteBean();
		u.setEmail(email);
		UtenteImplementazioneDAO dao2=new UtenteImplementazioneDAO();
		dao2.leggiSingoloUtente(u);
		
		r.setTesto((String)request.getParameter("recensione"));
		r.setProdotto(p);
		r.setUtente(u);
		r.setStelle((Integer.parseInt(request.getParameter("voto"))));
		System.out.println(r.getTesto());
		System.out.println(r.getStelle());
		System.out.println(r.getProdotto());
		System.out.println(r.getUtente());
		dao.aggiungiRecensione(r);
		request.getRequestDispatcher("DispatcherProdottoServlet?id="+p.getCodice()).forward(request, response);
	}

}
