package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrdineBean;
import model.OrdineImplementazioneDAO;

/**
 * Servlet implementation class DispatcherConfermaPagamento
 */
@WebServlet("/DispatcherConfermaPagamento")
public class DispatcherConfermaPagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherConfermaPagamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<OrdineBean> list=(ArrayList<OrdineBean>)request.getSession().getAttribute("list");
		OrdineImplementazioneDAO orimp = new OrdineImplementazioneDAO();
		for(int i=0; i<list.size(); i++) {
			OrdineBean ob=list.get(i);
			int id=orimp.inserisciOrdine(ob);
			ob.setId(id);
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("WEB-INF/fattura.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
