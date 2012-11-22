


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

	public class FuncionarioDAO {

		private static final String selectFindFuncionario = "select * from funcionario where nome = ?";
		private static final String insertFuncionario = "insert into funcionario(nome, telefone,cpf,usuario,senha) values (?, ?, ?, ?,?)";
//		private static final String deleteFuncionario = "delete *from funcionario(nome, telefone,cpf,usuario,senha) values (?, ?, ?, ?,?)";
//		private static final String updateFuncionario = "update into funcionario(nome, telefone,cpf,usuario,senha) values (?, ?, ?, ?,?)";

		// Configura essas variáveis de acordo com o seu banco


		public Funcionario findFuncionario(String nome) {
			if (nome == null) {
				throw new IllegalArgumentException("O nome não pode ser null.");
			}

			Funcionario func = null;

			try {
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/videolocadora", "postgres",
						"senacrs");
				
				
				PreparedStatement stmt = con.prepareStatement(selectFindFuncionario);
				stmt.setString(1, nome);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
			    	int id = rs.getInt("id");
					String nomee = rs.getString("nome");
					int telefone = rs.getInt("telefone");
					String cpf = rs.getString("cpf");
					String usuario= rs.getString("usuario");
					String senha = rs.getString("senha");
					 func = new Funcionario(1, nomee,telefone,cpf,usuario,senha);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// FIXME: comunicar erro ao programa
			}
			// FIXME: fechar conexões

			return func;
			
		}
		
		public void inserir(Funcionario fu) {
			if (fu == null) {
				throw new IllegalArgumentException("O cliente não pode ser null!");
			}
			

			try {
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/videolocadora", "postgres",
						"senacrs");

				PreparedStatement stmt = con.prepareStatement(insertFuncionario);
				stmt.setString(1, fu.getNome());
				stmt.setInt(2, fu.getTelefone());
				stmt.setString(3, fu.getCpf());
				stmt.setString(4, fu.getUsuario());
				stmt.setString(5, fu.getSenha());
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

