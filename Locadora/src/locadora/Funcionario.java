package locadora;

public class Funcionario {
	
	private int id;
	private String nome;
	private int telefone;
	private String cpf;
	private String usuario;
	private String senha;
	
	
	public Funcionario(int id,String nome, int telefone, String cpf, String usuario,
			String senha) {
		super();
		this.id=id;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.usuario = usuario;
		this.senha = senha;
	}

	public int getId() {
		return telefone;
	}


	public void setId(int id) {
		this.id = id;
	}

	

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getTelefone() {
		return telefone;
	}


	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	@Override
	public String toString() {
		return "Funcionario [id= + id + ,nome=" + nome + ", telefone=" + telefone
				+ ", cpf=" + cpf + ", usuario=" + usuario + ", senha=" + senha
				+ "]";
	}
	

	
}
