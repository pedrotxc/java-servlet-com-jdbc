package br.com.loja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Banco {
	PreparedStatement stm;
	Connection con;
	ResultSet rst;
	
	Banco () throws SQLException{
		con = ConnectionFactory.recuperarConexao();
	}
	public List<Loja> lsLoja = new ArrayList<>();
	
	public void adiciona(Loja loja) throws SQLException {
		String sql = "INSERT INTO produto(nome, descricao, data_cadastro) VALUES(?, ?, ?)";
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, loja.getNome());
		stm.setString(2, loja.getDescricao());
		stm.setDate(3, loja.getDataCadastro());
		stm.execute(sql);
		lsLoja.add(loja);
	}

	public List<Loja> getLojas() throws SQLException {
		String sql = "SELECT id, nome, descricao, data_cadastro FROM produto";
		stm = con.prepareStatement(sql);
		stm.execute(sql);
		rst = stm.getResultSet();
		
		while(rst.next()) {
			Loja loja = new Loja();
			loja.setId(rst.getInt("id"));
			loja.setNome(rst.getString("nome"));
			loja.setDescricao(rst.getString("descricao"));
			loja.setDataCadastro(rst.getDate("data_cadastro"));
			lsLoja.add(loja);
		}
		return lsLoja;		
	}
	
	public void closeConnection() throws SQLException{
		con.close();
		stm.close();
		rst.close();
	};
}
