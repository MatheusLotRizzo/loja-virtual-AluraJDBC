package br.com.alura.testeConexoes;

import java.sql.Connection;
import java.util.List;

import br.com.alura.dao.CategoriaDAO;
import br.com.alura.factory.ConnectionFactory;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;

public class ManipulacoesCategoria {

	public static void main(String[] args) {
		
		try(Connection con = new ConnectionFactory().recuperaConexao()){
			CategoriaDAO categoriaDao = new CategoriaDAO(con);
			List<Categoria> listaCategorias = categoriaDao.listarComProduto();
			System.out.println("Categorias:");
			listaCategorias.stream().forEach(lc -> {
				for(Produto produto : lc.getProdutos()) {
					System.out.println(lc.getNome());
					System.out.println("  " + produto.getNome());
				}
			});
					
		}catch (Exception e) {
			System.out.println("Erro de Execução: " + e);
		}
	}

}
