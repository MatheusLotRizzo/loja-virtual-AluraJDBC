package br.com.alura.testeConexoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.factory.ConnectionFactory;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory criaConexao = new ConnectionFactory();
		
		try(Connection con = criaConexao.recuperaConexao()){
			con.setAutoCommit(false);
			String sql = "insert into produto (nome, descricao) values (?, ?)";

			try (PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				adicionarProduto("Teclado", "Teclado sem fio", stm);
				adicionarProduto("SmartVT", "SmartVT 45 Polegadas", stm);
				con.commit();

			} catch (Exception e) {
				System.out.println("ERRO AO REALIZAR INSERÇÃO, REALIZANDO ROLLBACK");
				con.rollback();
			}
		}
		
	}

	private static void adicionarProduto(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.execute();

		try (ResultSet rs = stm.getGeneratedKeys()) {
			while (rs.next()) {
				int id = rs.getInt(1);
				System.out.println("Produto Inserido com o Id: " + id + " Nome: " + nome + "\n");
			}
		}catch (Exception e) {
			System.out.println("Erro ao Inserir Produto: " + e);
		}		
	}

}
