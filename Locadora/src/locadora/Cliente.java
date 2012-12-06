package locadora;

public class Cliente {

	private int id;
	private String nome;
    private String sobrenome;
    private int telefone;
    private String endereco;
	
    
    
    public Cliente(int id,String nome, String sobrenome, int telefone,String endereco) {
		super();
		
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.endereco = endereco;
	}


	public int getId() {
		return id;
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



	public String getSobrenome() {
		return sobrenome;
	}



	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}



	public int getTelefone() {
		return telefone;
	}



	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
    
    
	public String toString() {
		return String.format("Cliente id = %s,nome=%s, sobrenome=%s, telefone=%s,endereco=%s",
				id,nome, sobrenome, telefone,endereco);
	}
	
    


}
