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

public class ClienteDAO {

	private static final String selectFindCliente = "select * from cliente where id = ?";
	private static final String insertCliente = "insert into cliente(nome, sobrenome,telefone,endereco) values (?, ?, ?, ?)";
//	private static final String deleteCliente = "delete into cliente(nome, sobrenome,telefone,endereco) values (?, ?, ?, ?)";
//	private static final String updateCliente = "update into cliente(nome, sobrenome,telefone,endereco) values (?, ?, ?, ?)";

	// Configura essas variáveis de acordo com o seu banco


	public Cliente findCliente(String id) {
		if (id == null) {
			throw new IllegalArgumentException("O id não pode ser null.");
		}

		Cliente c = null;

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost/videolocadora", "postgres",
					"senacrs");
			
			
			PreparedStatement stmt = con.prepareStatement(selectFindCliente);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
		    	id = rs.getString("id");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				int telefone = rs.getInt("telefone");
				String endereco = rs.getString("endereco");
				Cliente cliente = new Cliente(1, nome, sobrenome, telefone, endereco);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa
		}
		// FIXME: fechar conexões

		return c;
		
	}
	
	public void inserir(Cliente c) {
		if (c == null) {
			throw new IllegalArgumentException("O cliente não pode ser null!");
		}
		

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost/videolocadora", "postgres",
					"senacrs");

			PreparedStatement stmt = con.prepareStatement(insertCliente);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getSobrenome());
			stmt.setInt(3, c.getTelefone());
			stmt.setString(4, c.getEndereco());
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
