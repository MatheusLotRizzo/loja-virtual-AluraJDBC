package br.com.alura.testeConexoes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.dao.ProdutoDAO;
import br.com.alura.factory.ConnectionFactory;
import br.com.alura.modelo.Produto;

public class ManipulacoesProduto {

	public static void main(String[] args) throws SQLException {
		Produto produto = new Produto("Comoda", "Comoda MDF Casas Bahia");
		
		try(Connection con = new ConnectionFactory().recuperaConexao()){
			
			ProdutoDAO produtoDao = new ProdutoDAO(con);
			produtoDao.salvar(produto);
			System.out.println(produto + "\n");
			
			System.out.println("Lista de Produtos:");
			List<Produto> listaProdutos = produtoDao.listar();
			listaProdutos.stream().forEach(lp -> System.out.println(lp));
				
		}catch (Exception e) {
			System.out.println("Erro de Execução: " + e);
		}

	}

}
