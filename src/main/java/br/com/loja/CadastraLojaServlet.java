package br.com.loja;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastraLoja")
public class CadastraLojaServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Loja loja = new Loja();
		String nomeLoja = request.getParameter("nomeLoja");
		String descricaoLoja = request.getParameter("descricaoLoja");
		String dataCadastro = request.getParameter("dataCadastro");
		Date dataConvertida = Date.valueOf(dataCadastro);
		
		Banco banco = null;
		try {
			loja.setNome(nomeLoja);
			loja.setDescricao(descricaoLoja);
			loja.setDataCadastro(dataConvertida);
			banco = new Banco();
			banco.adiciona(loja);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		response.sendRedirect("listaLojaServlet");
	}
}
