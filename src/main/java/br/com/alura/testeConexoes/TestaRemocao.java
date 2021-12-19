package br.com.alura.testeConexoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.factory.ConnectionFactory;

public class TestaRemocao {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection con = criaConexao.recuperaConexao();
		
		String sql = "delete from produto where id > 2";
		
		PreparedStatement stm = con.prepareStatement(sql);
		stm.execute();
		
		int linhasModificadas = stm.getUpdateCount();
		System.out.println("Total de produtos romovidos: " + linhasModificadas);
		
		System.out.println("Fechando Conexão");
		con.close();
	}
}
