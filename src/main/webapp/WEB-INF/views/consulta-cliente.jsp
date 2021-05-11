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
		
			<h5>Consulta de Clientes</h5>
			<a href="/projetoSpringMVC01/" class="btn btn-light">Voltar</a>
			<hr/>
			
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>Nome do Cliente</th>
						<th>CPF</th>
						<th>Email</th>
						<th>Categoria</th>
						<th>Operações</th>
					</tr>
				</thead>
				<tbody>
				
				    <c:forEach var="cliente" items="${listaclientes}">
				 
					<tr>
						<td>${cliente.nome}</td>
						<td>${cliente.cpf}</td>
						<td>${cliente.email}</td>
						<td>${cliente.categoria}</td>
						
						<td>
							<a href="/projetoSpringMVC01/edicao-cliente?id=${cliente.idCliente}" class="btn btn-primary btn-sm">Atualizar</a>							
							<a href="/projetoSpringMVC01/excluir-cliente?id=${cliente.idCliente}" 
							   onclick="return confirm('Deseja excluir o cliente ${cliente.nome}?');"
							   class="btn btn-danger btn-sm">
								Excluir
							</a>
						</td>
					</tr>
					
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">Quantidade de clientes: ${listaclientes.size()}</td>
					</tr>
				</tfoot>
			</table>
		
		</div>
	
		<!-- Referencia dos arquivos JavaScript -->
		<script src="resources/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>