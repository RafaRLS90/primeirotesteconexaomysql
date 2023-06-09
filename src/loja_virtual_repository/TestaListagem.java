package loja_virtual_repository;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
				ConnectionFactory connectionFactory = new ConnectionFactory();
				Connection connection = connectionFactory.recuperarConexao();
		
				PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");//Faz comandos do mysql, para modificar banco de dados
				stm.execute();//executando banco de dados
				
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
