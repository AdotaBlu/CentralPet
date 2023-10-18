<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
	<style><%@include file="/resources/css/estilo.css"%></style>
	<title>Perfil do Tutor</title>
</head>
<body>
		<%@include file="nav-tutor-logado.jsp"%>
	<main>
		<c:if test="${tutor != null}">
			<h1><c:out value='${tutor.nome}' /></h1>
			<img alt="foto-de-perfil" src='<c:out value="${foto.urlImagem}"></c:out>' width="200px" heigth="200px">
		</c:if>
		
		<c:if test="${tutor == null}">
			<h1>nenhum tutor encontrado</h1>
		</c:if>
		
		<div>
			<table class = "infomacoes">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Email</th>
						<th>Telefone</th>
						<th>CPF</th>
						<th>Gênero</th>
						<th>Data de Nascimento</th>
					</tr>
				</thead>
				
				<c:if test="${tutor != null && contato != null}">
					<tbody>
						<tr>							
							<td><c:out value='${tutor.nome}'></c:out></td>
							<td><c:out value='${contato.email}'></c:out></td>
							<td><c:out value='${contato.telefone}'></c:out></td>
							<td><c:out value='${tutor.cpf}'></c:out></td>
							<td><c:out value='${tutor.generoTutor}'></c:out></td>
							<td><c:out value='${tutor.dataNascimento}'></c:out></td>
						</tr>
					</tbody>
				</c:if>
			</table>
			<table class = "infomacoes">
				<thead>
					<tr>
						<th>Logradouro</th>
						<th>Número</th>
						<th>Bairro</th>
						<th>CEP</th>
						<th>Ponto de Referência</th>
					</tr>
				</thead>
				
				<c:if test="${endereco != null}">
					<tbody>
						<tr>							
							<td><c:out value='${endereco.logradouro}'></c:out></td>
							<td><c:out value='${endereco.numero}'></c:out></td>
							<td><c:out value='${endereco.bairro}'></c:out></td>
							<td><c:out value='${endereco.cep}'></c:out></td>
							<td><c:out value='${endereco.pontoReferencia}'></c:out></td>
						</tr>
					</tbody>
				</c:if>
			</table>
		</div>
	</main>
	
	
</body>
</html>