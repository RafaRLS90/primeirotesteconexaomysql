package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.RuntimeErrorException;



    public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		try(Connection connection = factory.recuperarConexao()){	
		
		connection.setAutoCommit(false);
		
		try(PreparedStatement stm = 
				connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (? , ?)" , Statement.RETURN_GENERATED_KEYS);
				) {
					
					adicionarVariavel("Smart TV", "Toshiba", stm);
					adicionarVariavel("Radio", "Multilaser", stm);
					
					connection.commit();
					
					
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			connection.rollback();//O rollback serve para fazer justamente o contrário do
			//commit, ou seja, ele desfaz as alterações que você fez no banco 
		}
	}
}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1,nome);
		stm.setString(2, descricao);
		
		if(nome.equals(";")) {
			throw new RuntimeException("Não foi possível adicionar o produto");
		}
		
		
		stm.execute();
		
		try(ResultSet rst = stm.getGeneratedKeys()){
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("o id criado foi: " + id);
	
		    }
		}
	}
}
