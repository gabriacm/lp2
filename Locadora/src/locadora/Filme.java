package locadora;

public class Filme {

	private int id;
	private String titulo;
	private String categoria;
	private int duracao;
	
	
	public Filme(int id,String titulo, String categoria,int duracao) {
		super();
		this.id=id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.duracao = duracao;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public int getDuracao() {
		return duracao;
	}


	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}



	@Override
	public String toString() {
		return "Filme [id=" + id + ", titulo=" + titulo + ", categoria="
				+ categoria + ", duracao=" + duracao + "]";
	}

	
	
}
