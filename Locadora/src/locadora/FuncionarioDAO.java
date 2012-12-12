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

	public class FuncionarioDAO {

		private static final String selectFindFuncionario = "select * from funcionario where id = ?";
		private static final String insertFuncionario = "insert into funcionario(nome, telefone,cpf,usuario,senha) values (?, ?, ?, ?,?)";
    	private static final String deleteFuncionario = "delete from funcionario where id = ?";
    	private static final String updateFuncionario = "update funcionario  set nome = ?,telefone = ?, cpf = ?,usuario = ?,senha = ? where id = ?";
    	private static final String selectFuncionario = "select * from funcionario";


		public Funcionario findFuncionario(int id) {
			if (id == 0) {
				throw new IllegalArgumentException("O nome não pode ser 0.");
			}

			Funcionario func = null;

			try {
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/videolocadora", "postgres",
						"senacrs");
				
				
				PreparedStatement stmt = con.prepareStatement(selectFindFuncionario);
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
			    	int id2 = rs.getInt("id");
					String nome = rs.getString("nome");
					int telefone = rs.getInt("telefone");
					String cpf = rs.getString("cpf");
					String usuario= rs.getString("usuario");
					String senha = rs.getString("senha");
					 func = new Funcionario(id2, nome,telefone,cpf,usuario,senha);
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
		
		public void deletar(Funcionario d) {
			if (d == null) {
				throw new IllegalArgumentException("O cliente não pode ser null!");
			}
			

			try {
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/videolocadora", "postgres",
						"senacrs");

				PreparedStatement stmt = con.prepareStatement(deleteFuncionario);
		
				stmt.setInt(1, d.getId());			
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

		public void editar(Funcionario ed) {
			if (ed == null) {
				throw new IllegalArgumentException("O cliente não pode ser null!");
			}

			try {
				Connection con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/videolocadora", "postgres",
						"senacrs");

				PreparedStatement stmt = con.prepareStatement(updateFuncionario);
				
				stmt.setString(1, ed.getNome());
				stmt.setInt(2, ed.getTelefone());
				stmt.setString(3, ed.getCpf());
				stmt.setString(4, ed.getUsuario());
				stmt.setString(5, ed.getSenha());
				stmt.setInt(6, ed.getId());
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


		public List<Funcionario> consultarFuncionario() {
			
			List<Funcionario> ops = new ArrayList<Funcionario>();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Connection con = null;
			try {
				con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/videolocadora", "postgres",
						"senacrs");

				stmt = con.prepareStatement(selectFuncionario);
				rs = stmt.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String nome  = rs.getString("nome");
					int telefone = rs.getInt("telefone");
					String cpf  = rs.getString("cpf");
					String usuario  = rs.getString("usuario");
					String senha  = rs.getString("senha");
					
					
					
					Funcionario op = new Funcionario(id, nome,telefone,cpf,usuario,senha);
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

