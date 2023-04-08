package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.ProdutoDAO;
import modelo.Produto;

public class TestaInsercaoEListagemComProduto {
	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("Cômoda", "Cômoda Vertical");
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()) {
		ProdutoDAO produtoDao = new ProdutoDAO(connection);
		produtoDao.salvar(comoda);
		List<Produto> listaDeProdutos = produtoDao.listar();
		listaDeProdutos.stream().forEach(lp -> System.out.println(lp) );	
		}
		
	}
}
