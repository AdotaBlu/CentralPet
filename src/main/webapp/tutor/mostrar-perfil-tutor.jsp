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
		<%@include file="../nav-bar/nav-tutor-logado.jsp"%>
	<main>
		<c:if test="${tutor != null}">
			<h1><c:out value='${tutor.nome}' /></h1>
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
			
			<c:if test="${tutor != null}">
				<form method="post" action="excluir-tutor">
					<button type="submit" class="btn-adotar-card">Deletar Conta</button>
				</form>
			</c:if>
		</div>
		<h1>Pets Favoritados</h1>
			<div class="container-cards">
			<c:forEach var="pet" items="${petsFavoritos}">
				<div class="pet-card">
					<div class="foto-pet">
						<img class ="foto-pet" src="<c:out value='${pet.fotoPrincipalPet()}'></c:out>" alt="foto-pet" width="220" height="170">
					</div>
					<div class="info-card">
						<div class="info-top">
							<span class="label" id="label-ong">ONG: </span>
							<span id="value-ong"><c:out value='${pet.ong.nome}'></c:out></span>
						</div>
						<div class="info-mid">
							<div class="pet-nome">
								<p id="nome-pet">
									<c:out value='${pet.nome}'></c:out>
								</p>
							</div>
							<div class="pet-icone">
								<div class="pet-icone-sexo">
									<c:if test="${pet.sexoPet == 'MACHO'}">
										<img width="15px" height="15px" alt="ma" src="data:image/png;base64,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" >
									</c:if>
									<c:if test="${pet.sexoPet == 'FEMEA'}">
										<img width="13px" height="17px" alt="fem" src="data:image/png;base64,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">
									</c:if>
								</div>
								<div class="pet-icone-favorito">
									<img  width="17px" height="14px" src="data:image/png;base64,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" alt="fa">
								</div>
							</div>
						</div>
							<div class="info-bottom">
								<div class="pet-info-box">
									<span class="label">Idade: </span>
									<c:if test="${pet.idade > 1}">
										<span class="value"><c:out value='${pet.idade}'></c:out> anos</span>
									</c:if>
									<c:if test="${pet.idade == 1}">
										<span class="value"><c:out value='${pet.idade}'></c:out> ano</span>
									</c:if>
								</div>
								<div class="pet-info-box">
									<span class="label">Porte: </span>
									<span class="value"><c:out value='${pet.portePet}'></c:out></span>
								</div>
								<div class="pet-info-box">
									<span class="label">Pelagem: </span>
									<span class="value"><c:out value='${pet.pelagemPet}'></c:out></span>
								</div>
								<div class="pet-info-box">
									<span class="label">Peso: </span>
									<span class="value"><c:out value='${pet.peso}'></c:out>kg</span>
								</div>
							</div>
							<form method="post" action="mostrar-perfil-pet" enctype="form-data">					
								<div class="btn-card">				
									<input type="hidden" id="id-pet" name="id-pet" value="<c:out value='${pet.id}' />">
									<input type="hidden" id="id-ong" name="id-ong" value="<c:out value='${pet.ong.id}' />">
									<button type="submit" class="btn-adotar-card">Adotar</button>
								</div>
							</form>
						</div>
				</div>
			</c:forEach>
		</div>
		
	</main>
	
	
</body>
</html>