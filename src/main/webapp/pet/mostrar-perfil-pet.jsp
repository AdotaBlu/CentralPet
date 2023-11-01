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
			<h1><c:out value='${pet.nome}'/></h1>
			
			<div class ="container-info-pet">
				<div class="container-fotos-pet">
				<c:if test="${not empty fotos}">
					<h2>Fotos do pet</h2>
					<c:forEach var="foto" items="${fotos}">
						<img class="imagem-perfil-pet" src='<c:out value="${foto.urlImagem}"></c:out>' alt="Foto do Pet">
					</c:forEach>
				</c:if>
			</div>
				
			<table>
				<thead>
					<tr>
						<th>Vacinas</th>
						<th>Descrição</th>
						<th>Data de nascimento</th>
						<th>Idade</th>
						<th>Peso</th>
						<th>ONG responsavel</th>
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
							<td><c:out value='${pet.peso}'></c:out></td>
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
			<c:if test="${ongSessao != null}">
				<form method="post" action="editar-pet">
					<input type="hidden" id="id-pet" name="id-pet" value="<c:out value='${pet.id}' />">
					<input type="hidden" id="id-ong" name="id-ong" value="<c:out value='${ongSessao.id}' />">
					<button type="submit" class="btn-adotar-card">Editar Pet</button>
				</form>
				<form method="post" action="excluir-pet">
					<input type="hidden" id="id-pet" name="id-pet" value="<c:out value='${pet.id}' />">
					<button type="submit" class="btn-adotar-card">Deletar Pet</button>
				</form>
			</c:if>
		</div>
		<div>
			<c:if test="${tutor != null }">
				<form method = "post" action = "favoritar-pet">
					<input type = "hidden" id = "id-pet" name = "id-pet" value = "<c:out value = '${pet.id}'/>">
					<button type="submit">Favoritar Pet</button>
				</form>
				<form method = "post" action = "excluir-pet-favoritado">
					<input type = "hidden" id = "id-pet" name = "id-pet" value = "<c:out value = '${pet.id}'/>">
					<button type="submit">Excluir Pet Favoritado</button>
				</form>
			</c:if>
		</div>
		<div>
			<c:if test="${tutor != null }">
				<form method = "post" action = "nova-adocao">
					<input type = "hidden" id = "id-pet" name = "id-pet" value = "<c:out value = '${pet.id}'/>">
					<button type="submit">Adotar Pet</button>
				</form>
			</c:if>
		</div>
		</c:if>
		
		<c:if test="${pet == null}">
			<h1>Nenhum pet encontrado :p</h1>
		</c:if>
		
		
	</main>
	
</body>
</html>