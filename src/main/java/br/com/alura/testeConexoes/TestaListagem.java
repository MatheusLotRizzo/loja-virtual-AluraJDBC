package br.com.alura.testeConexoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.factory.ConnectionFactory;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection con = criaConexao.recuperaConexao();
		
		String sql = "select id, nome, descricao from produto";
		
		PreparedStatement stm = con.prepareStatement(sql);
		stm.execute();
		ResultSet rs = stm.getResultSet();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String descricao = rs.getString("descricao");
			
			System.out.println("Id: " + id + " Nome: " + nome + " Descrição: " + descricao);
		}
		
		System.out.println("Fechando Conexão");
		con.close();
	}
}
