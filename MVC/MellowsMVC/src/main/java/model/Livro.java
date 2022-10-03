package model;

public class Livro {
	private int idLivro;
	private String nomeLivro;
	private String autor;
	private String genero;
	private Usuario usuario;


	public Livro() {
	}

	public Livro(int idLivro, String nomeLivro, String autor, String genero, Usuario usuario) {
		this.idLivro = idLivro;
		this.nomeLivro = nomeLivro;
		this.autor = autor;
		this.genero = genero;
		this.usuario = usuario;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", nomeLivro=" + nomeLivro + ", autor=" + autor + ", genero=" + genero
				+ "]";
	}

}
