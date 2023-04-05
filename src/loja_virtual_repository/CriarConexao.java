package loja_virtual_repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriarConexao {
	
	public Connection recuperarConexao() throws SQLException {
		return DriverManager
				.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "rafadev1990java");
			
	}
}
