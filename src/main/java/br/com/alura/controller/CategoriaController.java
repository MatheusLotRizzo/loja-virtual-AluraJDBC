package br.com.alura.controller;

import java.sql.Connection;
import java.util.List;

import br.com.alura.dao.CategoriaDAO;
import br.com.alura.factory.ConnectionFactory;
import br.com.alura.modelo.Categoria;

public class CategoriaController {

	private CategoriaDAO categoriaDAO;

	public CategoriaController() {
		Connection connection = new ConnectionFactory().recuperaConexao();
		this.categoriaDAO = new CategoriaDAO(connection);
	}

	public List<Categoria> listar() {
		return this.categoriaDAO.listar();
	}
}
