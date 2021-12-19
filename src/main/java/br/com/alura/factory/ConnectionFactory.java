package br.com.alura.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource cbpds = new ComboPooledDataSource();
		cbpds.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		cbpds.setUser("root");
		cbpds.setPassword("root");
		cbpds.setMaxPoolSize(15);
		
		this.dataSource = cbpds;
	}
		
	public Connection recuperaConexao() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
