<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/resources/css/estilo.css"%></style>
	<title>Perfil Pet</title>
</head>

<body>
	
	<main>
		<c:if test="${pet != null}">
			<h1><c:out value='${pet.nome}' /></h1>
		</c:if>
		
		<c:if test="${pet == null}">
			<h1>nenhum pet encontrado</h1>
		</c:if>
		
		<div>
			<table>
				<thead>
					<tr>
						<th>Vacinas</th>
						<th>Descrição</th>
						<th>Data de nascimento</th>
						<th>Idade</th>
						<th>Ong responsavel</th>
						<th>Porte</th>
						<th>Especie</th>
						<th>Sexo</th>
						<th>Pelagem</th>
					</tr>
				</thead>
				
				<c:if test="${pet != null && ong != null}">
					<tbody>
						<tr>
							<td><c:out value='${pet.vacinas}'></c:out></td>
							<td><c:out value='${pet.descricao}'></c:out></td>
							<td><c:out value='${pet.dataNascimento}'></c:out></td>
							<td><c:out value='${pet.idade}'></c:out></td>
							<td><c:out value='${ong.nome}'></c:out></td>
							<td><c:out value='${pet.portePet}'></c:out></td>
							<td><c:out value='${pet.especiePet}'></c:out></td>
							<td><c:out value='${pet.sexoPet}'></c:out></td>
							<td><c:out value='${pet.pelagemPet}'></c:out></td>
						</tr>
					</tbody>
				</c:if>
			</table>
		</div>
		
		<div>
		<c:if test="${not empty fotos}">
			<h2>Fotos do pet</h2>
			<c:forEach var="foto" items="${fotos}">
				<img src='<c:out value="${foto.urlImagem}"></c:out>' alt="Foto do Pet">
			</c:forEach>
		</c:if>	
		</div>
				
	</main>
	
</body>
</html>