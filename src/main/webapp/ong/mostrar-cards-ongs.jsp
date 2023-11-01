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
<title>ONGS</title>
</head>
<body>
	<c:if test="${tutor == null && ong == null}">
	<%@ include file="../nav-bar/nav-usuario-deslogado.jsp" %>
	</c:if>
	
	<c:if test="${tutor != null}">
	<%@ include file="../nav-bar/nav-tutor-logado.jsp" %>
	</c:if>
	
	<c:if test="${ong != null}">
	<%@ include file="../nav-bar/nav-ong-logada.jsp" %>
	</c:if>
	
	<main>
		<div class="container-cards">
			<c:forEach var="ong" items="${ongs}">
				<div class="ong-card">
					<div class="foto-pet">
						<img class ="foto-pet" src="<c:out value='${ong.urlFoto()}'></c:out>" alt="foto-pet" width="220" height="170">
					</div>
					<div class="info-card">
						<div class="info-top">
							<span id="ong-nome-card"><c:out value='${ong.nome}'></c:out></span>
						</div>
						</div>
						<form method="post" action="mostrar-perfil-ong" enctype="form-data">					
							<div class="btn-card">				
								<input type="hidden" id="id-ong" name="id-ong" value="<c:out value='${ong.id}' />">
								<button type="submit" class="btn-ong-card">Perfil ONG</button>
							</div>
						</form>
				</div>
			</c:forEach>
		</div>
		
	</main>
</body>
</html>