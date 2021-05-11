package br.com.sulamerica.entity;

import java.util.Date;

public class Usuario {

	private Integer idUsuario;
	private String nome;	
	private String cpf;
	private Date data_nascimento;
	private Cargo cargo;
	private Perfil perfil;

	public Usuario() {

	}

	public Usuario(Integer idUsuario, String nome, String cpf, Date data_nascimento, Cargo cargo, Perfil perfil) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.cpf = cpf;
		this.data_nascimento = data_nascimento;
		this.cargo = cargo;
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", cpf=" + cpf + ", data_nascimento="
				+ data_nascimento + ", cargo=" + cargo + ", perfil=" + perfil + "]";
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}