<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Solicitação de Adoção</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<style><%@include file="/resources/css/estilo.css"%></style>
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"rel="stylesheet">
	</head>
	
	<body>
	
		<c:if test="${tutorSessao == null && ongSessao == null}">
		<%@ include file="../nav-bar/nav-usuario-deslogado.jsp" %>
		</c:if>
		
		<c:if test="${tutorSessao != null}">
		<%@ include file="../nav-bar/nav-tutor-logado.jsp" %>
		</c:if>
		
		<c:if test="${ongSessao != null}">
		<%@ include file="../nav-bar/nav-ong-logada.jsp" %>
		</c:if>
	
		teste tutor:
		<c:out value="${adocao.tutor.nome}"></c:out>
		teste pet:
		<c:out value="${adocao.pet.nome}"></c:out>
		
		<form action="aceitar-adocao" method="post">
		<input type="hidden" name="id-adocao" value='<c:out value="${adocao.id}"></c:out>'>
		
		<button type="submit">Aceitar</button>
		</form>
		
		<form action="recusar-adocao" method="post">
		<input type="hidden" name="id-adocao" value='<c:out value="${adocao.id}"></c:out>'>
		
		<button type="submit">Recusar</button>
		</form>
	
	</body>
</html>