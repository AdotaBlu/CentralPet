<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/resources/css/estilo.css"%></style>
	<title>Perfil da ONG</title>
</head>
<body>
	<main>
		<c:if test="${ong != null}">
			<h1><c:out value='${ong.nome}' /></h1>
		</c:if>
		
		<c:if test="${ong == null}">
			<h1>nenhuma ong encontrada</h1>
		</c:if>
		
		<div>
			<table class = "infomacoes">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Email</th>
						<th>Telefone</th>
					</tr>
				</thead>
				
				<c:if test="${ong != null && contato != null}">
					<tbody>
						<tr>							
							<td><c:out value='${ong.nome}'></c:out></td>
							<td><c:out value='${contato.email}'></c:out></td>
							<td><c:out value='${contato.telefone}'></c:out></td>
						</tr>
					</tbody>
				</c:if>
			</table>
				<h1>Endereço</h1>
			<table class = "infomacoes">
				<thead>
					<tr>
						<th>Logradouro</th>
						<th>Número</th>
						<th>Bairro</th>
						<th>Cep</th>
						<th>Ponto de Referencia</th>
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
			
			<h1>Adoções</h1>
			<table class = "infomacoes">
				<thead>
					<tr>
						<th>Pet</th>
						<th>Tutor</th>
						<th>Data da Adoção</th>
					</tr>
				</thead>
				
				<c:if test="${adocao != null}">
					<tbody>
						<tr>						
							<td><c:out value='${adocao.dataAdocao}'></c:out></td>
						</tr>
					</tbody>
				</c:if>
			</table>
			<h1>Termo</h1>
			<table class = "infomacoes">
				<thead>
					<tr>
						<th>O Termo</th>
					</tr>
				</thead>
				
				<c:if test="${termo != null}">
					<tbody>
						<tr>							
							<td><c:out value='${termo.termo}'></c:out></td>
						</tr>
					</tbody>
				</c:if>
			</table>
			
			
		</div>
	</main>

</body>
</html>