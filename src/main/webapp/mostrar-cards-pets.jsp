<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="centralpet.modelo.entidade.usuario.Usuario"%>

<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
	<style><%@include file="/resources/css/estilo.css"%></style>
<title>Pets</title>
</head>
<body>
	<%@include file="nav-usuario-deslogado.jsp"%>
	<main>
	<%@include file="filtro-pet.jsp"%>
		<div class="container-cards">
			<c:forEach var="pet" items="${pets}">
				<div class="pet-card">
					<div class="foto-pet">
						<img class ="foto-pet" src="<c:out value='${pet.fotoPrincipalPet()}'></c:out>" alt="foto-pet" width="220" height="170">
					</div>
					<div class="info-card">
						<div class="info-top">
							<span class="label" id="label-ong">ONG: </span>
							<span><c:out value='${pet.ong.nome}'></c:out></span>
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
										<img src="CentralPet/src/main/webapp/resources/img/icone-macho.png" width="15px" height="15px" alt="ma">
									</c:if>
									<c:if test="${pet.sexoPet == 'FEMEA'}">
										<img width="13px" height="17px" src="CentralPet/src/main/webapp/resources/img/icone-femea.png" alt="fem">
									</c:if>
								</div>
								<div class="pet-icone-favorito">
									<img  width="17px" height="14px" src="<c:url value='/CentralPet/resources/img/icone-fav-desativado.png'/>" alt="fa">
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
							<div class="btn-card">
								<a href="" class="btn-adotar-card">Adotar</a>
							</div>
						</div>
				</div>
			</c:forEach>
		</div>
	</main>
</body>
</html>