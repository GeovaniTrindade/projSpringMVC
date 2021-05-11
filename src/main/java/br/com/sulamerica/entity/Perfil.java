
package br.com.sulamerica.entity;

public class Perfil {

	private Integer idPerfil;
	private String administrador;
	private String comum;
	private Usuario usuario;

	public Perfil() {
	}

	public Perfil(Integer idPerfil, String administrador, String comum) {
		super();
		this.idPerfil = idPerfil;
		this.administrador = administrador;
		this.comum = comum;
	}

	public Perfil(Integer idPerfil, String administrador, String comum, Usuario usuario) {
		super();
		this.idPerfil = idPerfil;
		this.administrador = administrador;
		this.comum = comum;
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", administrador=" + administrador + ", comum=" + comum + "]";
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getAdministrador() {
		return administrador;
	}

	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}

	public String getComum() {
		return comum;
	}

	public void setComum(String comum) {
		this.comum = comum;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}