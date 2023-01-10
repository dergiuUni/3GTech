package dispatcher;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrdineBean;

@WebServlet("/DispatcherPagamento")
public class DispatcherPagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherPagamento() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ArrayList<OrdineBean> list=(ArrayList<OrdineBean>)request.getAttribute("list");
		request.getRequestDispatcher("WEB-INF/pagamento.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
