<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- TagLib do Spring -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- TagLib do Java (JSTL) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Projeto SpringMVC</title>

<!-- Folha de estilos CSS do bootstrap -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />

<!-- escrevendo folha de estilo CSS -->
<style>

/* formatação das mensagens de erro */
label.error {
	color: red;
}

/* formatação nos campos */
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

		<div class="alert alert-secondary alert-dismissible fade show"
			role="alert">
			<strong>${mensagem}</strong>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>

	</c:if>

	<div class="container mt-4">

		<h5>Formulário de Edição de Usuario</h5>
		<a href="/projSpringMVC/" class="btn btn-light">Voltar</a>
		<hr />

		<form id="formCadastro" action="atualizarUsuario" method="post"
			class="col-md-4">

			<!-- campo oculto -->
			<form:input type="hidden" path="usuario.idUsusario" />

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
				id="" name="">
				<option value="">Escolha uma opção</option>
				<option value="gerente">GERENTE</option>
				<option value="supervisor">SUPERVISOR</option>
				<option value="administrativo">ADMINISTRATIVO</option>
			</form:select>		
			
			<br />
			
			<label>Perfil:</label>
			<form:select path="usuario.perfil" class="form-select"
				id="" name="">
				<option value="">Escolha uma opção</option>
				<option value="administrador">ADMINISTRADOR</option>
				<option value="comum">COMUM</option>			
			</form:select>
			
			<br /> 
			
			<input type="submit" class="btn btn-success" value="Atualizar Usuario" />

		</form>

	</div>

	<!-- Referencia dos arquivos JavaScript -->
	<script src="resources/js/bootstrap.bundle.min.js"></script>

	<!-- Referencia do JQuery -->
	<script src="resources/js/jquery-3.5.1.min.js"></script>

	<!-- Referencia do JQuery Validate -->
	<script src="resources/js/jquery.validate.min.js"></script>

	<!-- Referencia do tradutor do JQuery validate -->
	<script src="resources/js/messages_pt_BR.js"></script>	

</body>
</html>



