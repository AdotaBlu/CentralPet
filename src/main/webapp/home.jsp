<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style><%@include file="/resources/css/estilo.css"%></style>
<title>Home</title>

<link rel="stylesheet" href="">

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
		<a href="<%=request.getContextPath()%>/novo-tutor">Cadastrar Tutor</a>
		<a href="<%=request.getContextPath()%>/editar-tutor">Editar Tutor</a>
		<a href="<%=request.getContextPath()%>/mostrar-perfil-tutor">Perfil Tutor</a>
		<a href="<%=request.getContextPath()%>/nova-ong">Cadastrar Ong</a>
		<a href="<%=request.getContextPath()%>/editar-ong">Editar Ong</a>
		<a href="<%=request.getContextPath()%>/mostrar-perfil-ong">Perfil Ong</a>
		<a href="<%=request.getContextPath()%>/novo-pet">Cadastrar Pet</a>
		<a href="<%=request.getContextPath()%>/editar-pet">Editar Pet</a>
		<a href="<%=request.getContextPath()%>/mostrar-perfil-pet">Perfil Pet</a>
		<a href="<%=request.getContextPath()%>/mostrar-cards-pets">Pets Cadastrados</a>
		<a href="<%=request.getContextPath()%>/mostrar-cards-ongs">Ongs Cadastradas</a>
		<a href="<%=request.getContextPath()%>/mostrar-selecao-cadastro">Seleção Cadastro</a>
		<a href="<%=request.getContextPath()%>/novo-login">Login</a>
		<a href="<%=request.getContextPath()%>/novo-termo">Cadastrar Termo</a>
		<a href="<%=request.getContextPath()%>/nova-adocao">Realizar Adoção</a>
		
	</main>
</body>

</html>
