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
			<h2>Digite sua senha</h2>
		</div>
		
		<c:if test="${ongSessao != null}">
		<form action="excluir-ong" method="post">
		</c:if>
		
		<c:if test="${tutorSessao != null}">
		<form action="excluir-tutor" method="post">
		</c:if>
		
			<div class="input-login">
				<label for="senha-um">Senha</label> 
				<input type="password" id="senha-um" oninput="confirmarSenha()">
			</div>
			
			<div class="input-login">
				<label for="senha-dois">Confirmar Senha</label> 
				<input type="password" id="senha-dois" name="senha-usuario-confirmar" oninput="confirmarSenha()">
			</div>
			
			<div class="container-btn-ong">
				<a href="<%=request.getContextPath()%>/home"><button type="button" class="btn-perfil-ong">Cancelar</button></a>
				<button type="submit" class="botao-login" id="btn-confirmar" disabled="disabled">Confirmar</button>
			</div>
		</form>
	</body>
</html>