package control;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import model.OrdineImplementazioneDAO;
import model.ProdottoImplementazioneDAO;

@WebServlet("/OrdiniData")
public class OrdiniData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String d1=(String)request.getParameter("perData1");
		String d2=(String)request.getParameter("perData2");
		Date data1=Date.valueOf(d1), data2=Date.valueOf(d2);
		OrdineImplementazioneDAO dao=new OrdineImplementazioneDAO();
		JSONArray elenco=dao.selectOrdiniData(data1,data2);
		request.setAttribute("elenco", elenco);
		request.getRequestDispatcher("/WEB-INF/elencoOrdiniADMIN.jsp").forward(request, response);
	}

}
