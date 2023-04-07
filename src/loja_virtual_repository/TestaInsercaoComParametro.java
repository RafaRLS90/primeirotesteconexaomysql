package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {
		String nome = "Mouse'";
		String descricao = "Mouse sem fio. Bugado";
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();	
		
		PreparedStatement stm = 
		connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (? , ?)" , Statement.RETURN_GENERATED_KEYS);
		
		adicionarVariavel("Smart TV", "Toshiba", stm);
		adicionarVariavel("Radio", "Multilaser", stm);
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1,nome);
		stm.setString(2, descricao);
		
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("o id criado foi: " + id);
	
		}
		rst.close();
	}
}
