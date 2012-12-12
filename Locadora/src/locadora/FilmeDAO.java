package locadora;



	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
	import java.util.Vector;
	import javax.swing.JOptionPane;



	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
import java.sql.ResultSet;

	public class FilmeDAO {

		
		private static final String selectFindFilme = "select * from filme where id = ?";
		private static final String insertFilme = "insert into filme(titulo, categoria,duracao) values (?, ?, ?)";
		private static final String deleteFilme = "delete  from filme where id = ?";
		private static final String updateFilme = "update filme  set titulo = ?,categoria = ?, duracao = ? where id = ?";
		private static final String selectFilme = "select * from filme";

		// Configura essas variáveis de acordo com o seu banco


		public Filme findFilme(int id) {
			if (id == 0) {
				throw new IllegalArgumentException("O titulo não pode ser null.");
			}

			Filme f = null;

			try {
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/videolocadora", "postgres",
						"senacrs");
				
				
				PreparedStatement stmt = con.prepareStatement(selectFindFilme);
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
			    	int id2 = rs.getInt("id");
					String titulo = rs.getString("titulo");
					String categoria = rs.getString("categoria");
					int duracao = rs.getInt("duracao");
					 f = new Filme(id2, titulo, categoria, duracao);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// FIXME: comunicar erro ao programa
			}
			// FIXME: fechar conexões

			return f;
			
		}
		
		public void inserir(Filme fl) {
			if (fl == null) {
				throw new IllegalArgumentException("O cliente não pode ser null!");
			}
			

			try {
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/videolocadora", "postgres",
						"senacrs");

				PreparedStatement stmt = con.prepareStatement(insertFilme);
				stmt.setString(1, fl.getTitulo());
				stmt.setString(2, fl.getCategoria());
				stmt.setInt(3, fl.getDuracao());
				int r = stmt.executeUpdate();
				if (r != 1) {
					throw new RuntimeException("Erro ao inserir operação");
				}
			} catch (Exception e) {
				// FIXME: comunicar erro ao programa
				e.printStackTrace();
			}
			// FIXME: fechar conexões
		}
		
		public void deletar(Filme fil) {
			if (fil == null) {
				throw new IllegalArgumentException("O filme não pode ser null!");
			}
			

			try {
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/videolocadora", "postgres",
						"senacrs");

				PreparedStatement stmt = con.prepareStatement(deleteFilme);
		
				stmt.setInt(1, fil.getId());			
				int r = stmt.executeUpdate();
				if (r != 1) {
					throw new RuntimeException("Erro ao deletar");
				}
			} catch (Exception e) {
				// FIXME: comunicar erro ao programa
				e.printStackTrace();
			}
			// FIXME: fechar conexões
		}
		
		
		public void editar(Filme fi) {
			if (fi == null) {
				throw new IllegalArgumentException("O filme não pode ser null!");
			}

			try {
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/videolocadora", "postgres",
						"senacrs");

				PreparedStatement stmt = con.prepareStatement(updateFilme);
				
				stmt.setString(1, fi.getTitulo());
				stmt.setString(2, fi.getCategoria());
				stmt.setInt(3, fi.getDuracao());				
				stmt.setInt(4, fi.getId());
				int r = stmt.executeUpdate();
				if (r != 1) {
					throw new RuntimeException("Erro ao inserir operação");
				}
			} catch (Exception e) {
				// FIXME: comunicar erro ao programa
				e.printStackTrace();
			}
			// FIXME: fechar conexões

		}

		

		public List<Filme> consultarFilme() {
		
			List<Filme> ops = new ArrayList<Filme>();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Connection con = null;
			try {
				con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/videolocadora", "postgres",
						"senacrs");

				stmt = con.prepareStatement(selectFilme);
				rs = stmt.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String titulo  = rs.getString("titulo");
					String categoria  = rs.getString("categoria");
					int duracao = rs.getInt("duracao");
					
					Filme op = new Filme(id, titulo,categoria,duracao);
					ops.add(op);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// FIXME: comunicar erro ao programa cliente
			} finally {
				try {
					if (stmt != null) {
						stmt.close();
					}
					if (rs != null) {
						stmt.close();
					}
					if (con != null) {
						stmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					// FIXME: comunicar erro ao programa cliente
				}
			}
			return ops;
		}
		
	}

	

