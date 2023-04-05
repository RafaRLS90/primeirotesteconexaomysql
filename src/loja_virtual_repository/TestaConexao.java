package loja_virtual_repository;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		CriarConexao criaConexao = new CriarConexao();
		Connection connection = criaConexao.recuperarConexao();
		
		//"jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimezone=UTC", "root"
		System.out.println("Fechando a conexão!");
		
		connection.close();
		
	}

}
