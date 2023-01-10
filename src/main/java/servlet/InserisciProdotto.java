package servlet;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProdottoBean;
import bean.ProdottoBean.categoria;
import implementazione.ProdottoImplementazioneDAO;

@WebServlet("/InserisciProdotto")
public class InserisciProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdottoBean p=new ProdottoBean();
		p.setDescrizione(request.getParameter("descrizione"));
		p.setNome(request.getParameter("nome"));
		p.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
		long now=System.currentTimeMillis();
		Date date= new Date(now);
		p.setInserimento(date);
		
		String tipo=request.getParameter("categoria");
		if(tipo.equals("Videogame")) p.setTipo(categoria.Videogame);
		if(tipo.equals("Console")) p.setTipo(categoria.Console);
		if(tipo.equals("Computer")) p.setTipo(categoria.Computer);
		if(tipo.equals("Elettrodomestici")) p.setTipo(categoria.Elettrodomestici);
		if(tipo.equals("Altro")) p.setTipo(categoria.Altro);
		
		//GESTIRE INSERIMENTO IMMAGINI
		
		ProdottoImplementazioneDAO dao=new ProdottoImplementazioneDAO();
		System.out.println(dao.inserisciProdotto(p));
		request.getRequestDispatcher("DispatcherGestisciCatalogo").forward(request, response);
	}

}
