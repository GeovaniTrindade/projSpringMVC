
package br.com.sulamerica.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.sulamerica.Utils.DateUtil;
import br.com.sulamerica.dto.UsuarioDTO;
import br.com.sulamerica.entity.Cargo;
import br.com.sulamerica.entity.Perfil;
import br.com.sulamerica.entity.Usuario;
import br.com.sulamerica.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired // inicialização automática
	private UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/cadastro-usuario")
	public ModelAndView cadastro() throws IOException {

		// declaro um objeto para enviar dados para pag
		ModelAndView modelAndView = new ModelAndView("cadastro-usuario");

		// envio um objeto Usuario para a pag e capturo os campos do formulário
		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}

	// recebo os dados do formulário de cadadstro de usuario, após a execução do
	// submit(fizer o post do formulário)
	@RequestMapping(value = "/cadastrarUsuario")
	public ModelAndView cadastrarUsuario(UsuarioDTO dto, HttpServletRequest request) throws IOException {
		ModelAndView modelAndView = new ModelAndView("cadastro-usuario");
		modelAndView.addObject("dto", new UsuarioDTO());

		try {
			Usuario usuario = new Usuario();
			usuario.setNome(dto.getNome());
			usuario.setCpf(dto.getCpf());
			usuario.setData_nascimento(DateUtil.convertDate(dto.getData_nascimento()));
			usuario.setCargo((Cargo) request.getAttribute(dto.getCargo()));
			usuario.setPerfil((Perfil) request.getAttribute(dto.getPerfil()));

			// TODO: conferir se o nome também ja existe

			if (usuarioRepository.findByCpf(dto.getCpf()) != null) {
				// redireciona para o catch
				throw new Exception("O CPF ja encontra-se cadastrado");
			}

			// gravar usuario no banco
			usuarioRepository.create(usuario);

			modelAndView.addObject("mensagem", "Usuario cadastrado com sucesso.");

		} catch (Exception e) {

			modelAndView.addObject("mensagem", e.getMessage());
		}

		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}

	@RequestMapping(value = "/consulta-usuario")
	public ModelAndView consulta(HttpServletResponse response) throws IOException {
		ModelAndView modelAndView = new ModelAndView("consulta-usuario");

		try {
			modelAndView.addObject("listausuarios", usuarioRepository.findAll());

		} catch (Exception e) {
			modelAndView.addObject("mensagem", e.getMessage());
		}

		return modelAndView;
	}

	@RequestMapping(value = "/edicao-usuario")
	public ModelAndView edicao(String cpf) throws Exception {
		ModelAndView modelAndView = new ModelAndView("edicao-usuario");

		try {
			// busca no banco de dados o usuario do cpf informado
			Usuario usuario = usuarioRepository.findByCpf(cpf);

			// exclui o usuario
			usuarioRepository.delete(usuario);

			// executa a consulta novamente
			modelAndView.addObject("listausuarios", usuarioRepository.findAll());

			// mensagem de sucesso
			modelAndView.addObject("mensagem", "Usuario" + usuario.getNome() + "Excluido com Sucesso");
		} catch (Exception e) {
			modelAndView.addObject("mensagem", e.getMessage());

		}

		return modelAndView;
	}

	// Método para receber os dados do formulário de atualização de cliente
	// após a execução do SUBMIT (fizer o POST do formulário)
	@RequestMapping(value = "/atualizarCliente", method = RequestMethod.POST)
	public ModelAndView atualizarCliente(Usuario usuario) throws IOException {

		ModelAndView modelAndView = new ModelAndView("consulta-usuario");

		try {

			usuarioRepository.update(usuario);

			modelAndView.addObject("mensagem", "Usuario atualizado com sucesso.");
			modelAndView.addObject("listaclientes", usuarioRepository.findAll());

		} catch (Exception e) {
			modelAndView.addObject("mensagem", e.getMessage());
		}

		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}

	@RequestMapping(value = "excluir-usuario")
	public ModelAndView exclusao(String cpf) throws Exception {
		ModelAndView modelAndView = new ModelAndView("consulta-usuario");

		try {
			// busca no banco de dados o usuario do cpf informado
			Usuario usuario = usuarioRepository.findByCpf(cpf);

			// exclui o usuario
			usuarioRepository.delete(usuario);

			// executa a consulta novamente
			modelAndView.addObject("listausuarios", usuarioRepository.findAll());

			// mensagem de sucesso
			modelAndView.addObject("mensagem", "Usuario" + usuario.getNome() + "Excluido com Sucesso");
		} catch (Exception e) {
			modelAndView.addObject("mensagem", e.getMessage());

		}

		return modelAndView;
	}

}
