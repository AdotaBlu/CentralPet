<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Aviso</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"rel="stylesheet">
		
		<style><%@include file="/resources/css/estilo.css"%></style>
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
		
		<div class ="tela-aviso">
			<div class ="texto-tela-aviso">
				<h1 id="h1-tela-aviso">PARE</h1>
				<h3>Você não pode entrar aqui</h3>
			</div>
		</div>
	</body>
</html>