package br.com.alura.testeConexoes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.factory.ConnectionFactory;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection con = criaConexao.recuperaConexao();
		
		String sql = "insert into produto (nome, descricao) values ('Teclado', 'Teclado sem fio GFallen');";
		Statement stm = con.createStatement();
		stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rs = stm.getGeneratedKeys();
		while(rs.next()) {
			int id = rs.getInt(1);
			System.out.println("Produto Inserido com o Id: " + id + "\n");
		}
		
	}

}
