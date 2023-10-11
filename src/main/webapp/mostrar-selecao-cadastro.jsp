<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/resources/css/estilo.css"%></style>
	<title>Seleção de Cadastro</title>
</head>
<body>
	<main>
		<div class="container-selecao-cadastro">
			<h1>Seleção de cadastro de Usuário</h1>
			<a href="<%=request.getContextPath()%>/nova-ong"><button class="botao-primario">Cadastrar ONG</button></a>
			<a href="<%=request.getContextPath()%>/novo-tutor"><button class="botao-primario">Cadastrar Tutor</button></a>
		</div>
	</main>
</body>
</html>