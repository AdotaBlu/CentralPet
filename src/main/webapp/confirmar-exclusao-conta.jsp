<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<style><%@include file="/resources/css/estilo.css"%></style>
		<script><%@include file="/resources/javaScript/JavaScript.js"%></script>
		<title>Confirmação</title>
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
	
		<div class="tela-exclusao-conta-texto">
			<h2>Você tem certeza de que deseja excluir sua conta?</h2>
		</div>
		
		<div class="container-btn-ong">
			<button type="button" class="btn-perfil-ong" onclick="goBack()">Voltar</button>
			<a href="<%=request.getContextPath()%>/mostrar-tela-confirmar-exclusao-senha"><button type="button" class="btn-perfil-ong">Confirmar</button></a>
		</div>
		
	</body>
</html>