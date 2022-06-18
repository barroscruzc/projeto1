package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

@SuppressWarnings("unused")
public class DAO {
	/** Módulo de Conexao **/
	// Parametros de conexao
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/projeto1?userTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "root";

	// Metodo de conexao
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver); // le o driver do banco de
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(); // Informa caso ocorra alguma excecao
			return null;
		}

	}

	/** CRUD CREATE **/
	public void inserirProduto(JavaBeans produto) {
		String create = "insert into produto (codigo, nome, categoria, valor, quantidade) values (?, ?, ?, ?, ?)";
		try {
			// abrir a conexao
			Connection con = conectar();
			// preparar a query para execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parâmetros (?) pelo conteúdo das variaveis JavaBeans
			pst.setInt(1, produto.getCodigo());
			pst.setString(2, produto.getNome());
			pst.setString(3, produto.getCategoria());
			pst.setFloat(4, produto.getValor());
			pst.setInt(5, produto.getQuantidade());
			// executar a query
			pst.executeUpdate();
			// encerrar a conexao com o banco de dados
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD READ **/
	public ArrayList<JavaBeans> listarByName() {
		// criando objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> produtos = new ArrayList<>();
		String read = "select * from produto order by nome";
		try {
			// abrir a conexao
			Connection con = conectar();
			// preparar a query para execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// o loop abaixo e repetido enquanto houver produtos
			while (rs.next()) {
				// variaveis de apoio que recebem dados do banco
				String strId = rs.getString(1);
				String strCodigo = rs.getString(2);
				String nome = rs.getString(3);
				String categoria = rs.getString(4);
				String strValor = rs.getString(5);
				String strQuantidade = rs.getString(6);
				int id = Integer.parseInt(strId);
				int codigo = Integer.parseInt(strCodigo);
				Float valor = Float.parseFloat(strValor);
				int quantidade = Integer.parseInt(strQuantidade);
				// armazenar os dados obtidos do banco no ArrayList
				produtos.add(new JavaBeans(id, codigo, nome, categoria, valor, quantidade));
			}
			con.close(); // fechando conexao
			return produtos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD UPDATE **/
	// selecionar produto
	public void selecionarProduto(JavaBeans produto) {
		// criando objeto para acessar a classe JavaBeans
		String selectId = "select * from produto where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(selectId);
			pst.setInt(1, produto.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				produto.setId(rs.getInt(1));
				produto.setCodigo(rs.getInt(2));
				produto.setNome(rs.getString(3));
				produto.setCategoria(rs.getString(4));
				produto.setValor(rs.getFloat(5));
				produto.setQuantidade(rs.getInt(6));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// atualizar produto no banco de dados
	public void editarProduto(JavaBeans produto) {
		String update = "update produto set codigo=?, nome=?, categoria=?, valor=?, quantidade=? where id=?";
		try {
			// abrir a conexao
			Connection con = conectar();
			// preparar a query para execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(update);
			// Substituir os parametros (?) pelo conteudo das variaveis JavaBeans
			pst.setInt(1, produto.getCodigo());
			pst.setString(2, produto.getNome());
			pst.setString(3, produto.getCategoria());
			pst.setFloat(4, produto.getValor());
			pst.setInt(5, produto.getQuantidade());
			pst.setInt(6, produto.getId());
			// executar a query
			pst.executeUpdate();
			// encerrar a conexao com o banco de dados
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD DELETE **/
	public void deletarProduto(JavaBeans produto) {
		String delete = "delete from produto where id=?";
		try {
			// abrir a conexao
			Connection con = conectar();
			// preparar a query para execucao no banco de dados
			PreparedStatement pst = con.prepareStatement(delete);
			// Substituir os parâmetros (?) pelo conteudo das variaveis JavaBeans
			pst.setInt(1, produto.getId());
			// executar a query
			pst.executeUpdate();
			// fechar a conexao
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
