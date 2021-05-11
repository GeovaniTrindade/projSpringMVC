<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuario</title>

<!-- Folha de estilos CSS do bootstrap -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />

<style>
label.error {
	color: red
}

input.error {
	border: 1px solid red;
}

select.error {
	border: 1px solid red;
}
</style>

</head>
<body>

	<c:if test="${not empty mensagem}">

		<div class="alert alert-secondary alert-dismissible fade show"	role="alert">
			<strong>${mensagem}</strong>
			<button type="button" class="btn-close" data-bs-dismiss="alert"	aria-label="Close"></button>
		</div>

	</c:if>


	<div class="container mt-4">

		<h5>Formulário de Cadastro de Usuario</h5>
		<a href="/projSpringMVC/" class="btn btn-light">Voltar</a>
		<hr />


		<form id="formCadastro" action="cadastrarUsuario" method="post"
			class="col-md-4">

			<label>Nome do Usuario:</label>
			<form:input path="usuario.nome" type="text" class="form-control" id="nome" name="nome" 
			placeholder="Ex:João da Silva" autocomplete="off" />
			
			<br /> 
			
			<label>CPF:</label>
			<form:input path="usuario.cpf" type="text" class="form-control"	id="cpf" name="cpf"
			 placeholder="999-999-999-00" autocomplete="off" />
			
			<br />
			
			 <label>Data de Nascimento:</label>
			<form:input path="usuario.data_nascimento" class="form-control" id="number"
				name="number" placeholder="dd-MM-YYYY" autocomplete="off" />
			
			<br />		
			
			<label>Cargo:</label>
			<form:select path="usuario.cargo" class="form-select"
				id="cargo" name="cargo">
				<option value="">Escolha uma opção</option>
				<option value="gerente">GERENTE</option>
				<option value="supervisor">SUPERVISOR</option>
				<option value="administrativo">ADMINISTRATIVO</option>
			</form:select>		
			
			<br />
			
			<label>Perfil:</label>
			<form:select path="usuario.perfil" class="form-select"
				id="perfil" name="perfil">
				<option value="">Escolha uma opção</option>
				<option value="administrador">ADMINISTRADOR</option>
				<option value="comum">COMUM</option>			
			</form:select>
			
			<br/>
			
			<input type="submit" class="btn btn-success" value="Cadastrar Usuario">

		</form>

	</div>

	<!-- Referencia dos arquivos JavaScript -->
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<script src="resources/js/jquery-3.5.1.min.js"></script>
	<script src="resources/js/jquery.validate.min.js"></script>
	<script src="resources/js/messages_pt_BR.js"></script>


	<script>
		//inicializando o JQuery
		$(document).ready(function() {

			//aplicando validação ao formulário
			//utilizando a biblioteca do JQuery validate
			$("#formCadastro").validate({

				//regras de validação:
				rules : {
					'nome' : {
						required : true, //campo obrigatório
// 						minlength : 6, //tamanho mínimo
// 						maxlength : 150 //tamanho máximo
					
					},
					'cpf' : {
						required : true, //campo obrigatório
						minlength : 11, //tamanho minimo
						maxlength : 11 //tamanho máximo
					
					},
					'data_nascimento' : {
						required : true, //campo obrigatório
						data_nascimento : true					
					},
					'cargo' : {
						required : true //campo obrigatório
					
					},
					'perfil' : {
						required : true //campo obrigatório
					
					}
				}
			});

		});
	</script>
</body>
</html>