package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.ProdutoDAO;
import modelo.Produto;

public class TestaInsercaoComProduto {
	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Cômoda", "Cômoda Vertical");
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()) {
		ProdutoDAO produtoDao = new ProdutoDAO(connection);
		produtoDao.salvar(comoda);
		//Lista = persistenciaProduto.listar();
			
		}
		System.out.println(comoda);
	}
}
