<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>LEIA</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<style><%@include file="/resources/css/estilo.css"%></style>

		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"rel="stylesheet">
	</head>
	
	<body>
	
		<c:if test="${tutor == null && ong == null}">
		<%@ include file="../nav-bar/nav-usuario-deslogado.jsp" %>
		</c:if>
		
		<c:if test="${tutor != null}">
		<%@ include file="../nav-bar/nav-tutor-logado.jsp" %>
		</c:if>
		
		<c:if test="${ongSessao != null}">
		<%@ include file="../nav-bar/nav-ong-logada.jsp" %>
		</c:if>
		
		<div class="texto-aceitar-termo">
			<c:forEach var="termo" items="${termos}">
			<textarea rows="35" cols="140" name="termo">
			<c:out value='${termo.termo}' />
			</textarea>
			</c:forEach>
			<input type="checkbox"> Concordo com o termo de responsabilidade
		</div>
		
		<form action="mostrar-tela-Tres-resposta-termo" method="post">
			<input type="hidden" name="id-pet" value='<c:out value="${pet.id}"></c:out>'>
			<input type="hidden" name="id-ong" value='<c:out value="${ong.id}"></c:out>'>
		
			<div class="container-botao">
				<button type="submit" class="botao-primario">Avançar</button>
			</div>
		</form>
	</body>
</html>