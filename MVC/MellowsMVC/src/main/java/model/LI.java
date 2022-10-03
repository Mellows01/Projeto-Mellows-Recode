package model;

public class LI {
	private int idLi;
	private String nivel;
	private String nome;
	private String genero;

	public LI(int idLi, String nivel, String nome, String genero) {
		this.idLi = idLi;
		this.nivel = nivel;
		this.nome = nome;
		this.genero = genero;
	}

	public LI() {
	}

	public int getIdLi() {
		return idLi;
	}

	public void setIdLi(int idLi) {
		this.idLi = idLi;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
