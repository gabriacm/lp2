
public class Filme {
	
	private String titulo;
	private String categoria;
	private int duracao;
	
	
	public Filme(String titulo, String categoria, int duracao) {
		super();
		this.titulo = titulo;
		this.categoria = categoria;
		this.duracao = duracao;
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

	
	
}
