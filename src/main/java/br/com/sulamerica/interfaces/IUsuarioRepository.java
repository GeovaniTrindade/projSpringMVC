package br.com.sulamerica.interfaces;

import java.util.List;

import br.com.sulamerica.entity.Usuario;

public interface IUsuarioRepository {

	void create(Usuario usuario) throws Exception;

	void update(Usuario usuario) throws Exception;

	void delete(Usuario usuario) throws Exception;

	List<Usuario> findAll() throws Exception;
	
	Usuario findByCpf(String cpf) throws Exception;
	
	Usuario findByNome(String cpf) throws Exception;



}
