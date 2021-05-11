<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>Projeto SpringMVC</title>
	 <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
</head>

<body>

        <c:if test="${not empty mensagem}">		
			<div class="alert alert-secondary alert-dismissible fade show" role="alert">
  				<strong>${mensagem}</strong> 
  				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>		
		</c:if>	

		<div class="container mt-4">
		
			<h5>Consulta de Usuario</h5>
			<a href="/projSpringMVC/" class="btn btn-light">Voltar</a>
			<hr/>
			
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>Nome do Usuario</th>
						<th>CPF</th>
						<th>Data de Nascimento</th>
						<th>Categoria</th>
						<th>Cargo</th>
						<th>Perfil</th>
						<th>Operações</th>
					</tr>
				</thead>
				<tbody>
				
				    <c:forEach var="usuario" items="${listausuarios}">
				 
					<tr>
						<td>${usuario.nome}</td>
						<td>${usuario.cpf}</td>
						<td>${usuario.data_nascimento}</td>
						<td>${usuario.cargo}</td>
						<td>${usuario.perfil}</td>
						
						
						<td>
							<a href="/projSpringMVC/edicao-usuario?cpf=${usuario.cpf}" class="btn btn-primary btn-sm">Atualizar</a>							
							<a href="/projSpringMVC/excluir-usuario?cpf=${usuario.cpf}" 
							   onclick="return confirm('Deseja excluir o usuario${usuario.nome}?');"
							   class="btn btn-danger btn-sm">
								Excluir
							</a>
						</td>
					</tr>
					
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">Quantidade de usuarios: ${listausuarios.size()}</td>
					</tr>
				</tfoot>
			</table>
		
		</div>
	
		<!-- Referencia dos arquivos JavaScript -->
		<script src="resources/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>