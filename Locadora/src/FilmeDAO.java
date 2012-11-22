


	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Vector;
	import javax.swing.JOptionPane;



	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	public class FilmeDAO {

		private static final String selectFindFilme = "select * from filme where titulo = ?";
		private static final String insertFilme = "insert into filme(titulo, categoria,duracao) values (?, ?, ?)";
//		private static final String deleteFilme = "delete *from filme(titulo, categoria,duracao) values (?, ?, ?)";
//		private static final String updateFilme = "update into filme(titulo, categoria,duracao) values (?, ?, ?)";

		// Configura essas variáveis de acordo com o seu banco


		public Filme findFilme(String titulo) {
			if (titulo == null) {
				throw new IllegalArgumentException("O titulo não pode ser null.");
			}

			Filme f = null;

			try {
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/videolocadora", "postgres",
						"senacrs");
				
				
				PreparedStatement stmt = con.prepareStatement(selectFindFilme);
				stmt.setString(1, titulo);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
			    	int id = rs.getInt("id");
					String tituloo = rs.getString("titulo");
					String categoria = rs.getString("categoria");
					int duracao = rs.getInt("duracao");
					 f = new Filme(1, tituloo, categoria, duracao);
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
		

	}

	

