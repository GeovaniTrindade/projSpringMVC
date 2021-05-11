package br.com.sulamerica.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import br.com.sulamerica.entity.Usuario;

import br.com.sulamerica.interfaces.IUsuarioRepository;

public class UsuarioRepository implements IUsuarioRepository {

	// atributo..
	private JdbcTemplate jdbcTemplate;

	// construtor..

	public UsuarioRepository(DataSource dataSource) {
		// inicializando o jdbcTemplate com o Datasource
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(Usuario usuario) throws Exception {
		String sql = "INSERT INTO USUARIO(NOME, CPF, DATA_NASCIMENTO, CARGO, PERFIL) VALUES(NULL, ?,?,?,?,?)";
		Object[] params = { usuario.getNome(), usuario.getCpf(), usuario.getData_nascimento(), usuario.getCargo(),
				usuario.getPerfil() };
		jdbcTemplate.update(sql, params);
	}

	@Override
	public void update(Usuario usuario) throws Exception {
		String sql = "UPDATE USUARIO SET NOME = ?, CPF = ?, DATA_NASCIMENTO = ?, CARGO = ?, PERFIL = ? WHERE IDUSUARIO";
		Object[] params = { usuario.getNome(), usuario.getCpf(), usuario.getData_nascimento(), usuario.getCargo(),
				usuario.getPerfil(), usuario.getIdUsuario() };
		jdbcTemplate.update(sql, params);
	}

	@Override
	public void delete(Usuario usuario) throws Exception {
		String sql = "DELETE FROM USUARIO WHERE IDUSUARIO = ?";
		Object[] params = { usuario.getIdUsuario() };
		jdbcTemplate.update(sql, params);
	}

	@Override
	public Usuario findByCpf(String cpf) throws Exception {

		String sql = "SELECT * FROM USUARIO WHERE CPF = ?";
		Object[] params = { cpf };

		List<Usuario> lista = jdbcTemplate.query(sql, params, new RowMapper<Usuario>() {

			@Override
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {

				Usuario usuario = new Usuario();

				return new Usuario(rs.getInt("IDUSUARIO"), rs.getString("nome"), rs.getString("CPF"),
						rs.getDate("DATA_NASCIMENTO"), usuario.getCargo(), usuario.getPerfil());
			}
		});

		if (lista.size() == 1) {
			return lista.get(0);

		} else {
			return null;
		}
	}

	@Override
	public Usuario findByNome(String nome) throws Exception {
		String sql = "SELECT * FROM USUARIO WHERE NOME = ?";
		Object[] params = { nome };

		List<Usuario> lista = jdbcTemplate.query(sql, params, new RowMapper<Usuario>() {

			@Override
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {

				Usuario usuario = new Usuario();
				return new Usuario(rs.getInt("IDUSUARIO"), rs.getString("nome"), rs.getString("CPF"),
						rs.getDate("DATA_NASCIMENTO"), usuario.getCargo(), usuario.getPerfil());

			}
		});

		// verificar se a lista contem 1 usuario
		if (lista.size() == 1) {
			return lista.get(0);
		} else {
			return null;
		}

	}

	@Override
	public List<Usuario> findAll() throws Exception {

		String sql = "SELECT * FROM USUARIO ORDER BY NOME ASC";

		List<Usuario> lista = jdbcTemplate.query(sql, new RowMapper<Usuario>() {

			@Override
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
				Usuario usuario = new Usuario();
				return new Usuario(rs.getInt("IDUSUARIO"), rs.getString("NOME"), rs.getString("CPF"),
						rs.getDate("DATA_NASCIMENTO"), usuario.getCargo(), usuario.getPerfil());

			}
		});

		return lista;
	}

}
