package br.com.loja;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaLojaServlet")
public class ListaLojaServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Loja> lsLojas = null;
		
		try {
			Banco banco = new Banco();
			lsLojas = banco.getLojas();
			banco.closeConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		request.setAttribute("lojas", lsLojas);		
		RequestDispatcher rd = request.getRequestDispatcher("/listaLoja.jsp");
		rd.forward(request, response);
		
	}
	
}
