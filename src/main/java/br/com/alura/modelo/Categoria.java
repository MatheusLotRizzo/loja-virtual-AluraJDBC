package br.com.alura.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<Produto>();
	private Integer categoriaId;

	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void adicionar(Produto produto) {
		produtos.add(produto);
	}
	
	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
}
