package br.com.sulamerica.entity;

public class Cargo {

	private Integer idCargo;
	private String gerente;
	private String supervisor;
	private String administrativo;
	private Usuario usuario;

	public Cargo() {
	}

	public Cargo(Integer idCargo, String gerente, String supervisor, String administrativo, Usuario usuario) {
		super();
		this.idCargo = idCargo;
		this.gerente = gerente;
		this.supervisor = supervisor;
		this.administrativo = administrativo;
		this.usuario = usuario;
	}
	
	

	public Cargo(String gerente, String supervisor, String administrativo) {
		super();
		this.gerente = gerente;
		this.supervisor = supervisor;
		this.administrativo = administrativo;
	}

	public Cargo(Integer idCargo, String gerente, String supervisor, String administrativo) {
		super();
		this.idCargo = idCargo;
		this.gerente = gerente;
		this.supervisor = supervisor;
		this.administrativo = administrativo;
	}

	@Override
	public String toString() {
		return "Cargo [idCargo=" + idCargo + ", gerente=" + gerente + ", supervisor=" + supervisor + ", administrativo="
				+ administrativo + "]";
	}

	public Integer getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public String getGerente() {
		return gerente;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getAdministrativo() {
		return administrativo;
	}

	public void setAdministrativo(String administrativo) {
		this.administrativo = administrativo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}