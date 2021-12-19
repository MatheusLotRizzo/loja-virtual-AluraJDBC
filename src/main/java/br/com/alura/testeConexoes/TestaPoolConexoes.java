package br.com.alura.testeConexoes;

import java.sql.SQLException;

import br.com.alura.factory.ConnectionFactory;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {
		 ConnectionFactory con =  new ConnectionFactory();
		 
		 for(int i = 0; i < 20; i++) {
			 con.recuperaConexao();
			 System.out.println("Conexão de nº " + i);
		 }

	}

}
