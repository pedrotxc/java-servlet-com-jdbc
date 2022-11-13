package br.com.loja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection recuperarConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/loja_jdbc?useTimezone=true&serverTimezone=UTC", "root", "1234");
	}
}
