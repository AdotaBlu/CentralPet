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
<title>Pets</title>
</head>
<body>
	<%@include file="nav-usuario-deslogado.jsp"%>
	<main>
	<%@include file="filtro-pet.jsp"%>
		<div class="container-cards">
			<c:forEach var="pet" items="${pets}">
				<div class="pet-card">
					<div class="fotos-pet">
						<img src="<c:out value='${pet.fotoPrincipalPet}'></c:out>" alt="foto-pet">
					</div>
					<div class="info-card">
						<div class="info-ong">
							<p>
								ONG:
							</p>
						</div>
						<div class="info">
							<div class="pet-nome">
								<p>
									<c:out value='${pet.nome}'></c:out>
								</p>
							</div>
							<div class="pet-sexo">
								<c:if test="${pet.sexo == MACHO}">
									<p>M</p>
								</c:if>
								<c:if test="${pet.sexo == FEMEA}">
									<p>F</p>
								</c:if>
							</div>
							<div class="pet-favorito">
								<p>bf</p>
							</div>
							<div class="pet-info">
								<div><p>Idade: <c:out value='${pet.idade}'></c:out></p></div>
								<div><<p>Porte: <c:out value='${pet.portePet}'></c:out></p></div>
								<div><<p>Pelagem: <c:out value='${pet.pelagemPet}'></c:out></p></div>
								<div><<p>Peso: <c:out value='${pet.peso}'></c:out></p></div>
							</div>
							<div class="btn-card">
								<a class="btn-adotar-card">Adotar</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</main>
</body>
</html>