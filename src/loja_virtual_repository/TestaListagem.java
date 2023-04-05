package loja_virtual_repository;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "rafadev1990java");
			
				Statement stm = connection.createStatement();//Faz comandos do mysql, para modificar banco de dados
				stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");//executando banco de dados
				
				ResultSet rst = stm.getResultSet();//trazendo resultados do banco
				
				//while fara a busca e trará os itens
				while (rst.next()) {
					Integer id = rst.getInt("ID");
					System.out.println(id);
					String nome = rst.getString("NOME");
					System.out.println(nome);
					String descricao = rst.getString("DESCRICAO");
					System.out.println(descricao);
					
				}
				
		connection.close();
	
	}

}
