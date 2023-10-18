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
	<%@ include file="nav-usuario-deslogado.jsp" %>
	</c:if>
	
	<c:if test="${tutor != null}">
	<%@ include file="nav-tutor-logado.jsp" %>
	</c:if>
	
	<c:if test="${ong != null}">
	<%@ include file="nav-ong-logada.jsp" %>
	</c:if>
	
	<main>
		<div class="container-home1">
			<div class="container-home1-1">
				<h1>Entrar</h1>
			</div>
			<div class="container-home-1-2">
				<img src="" alt="logoDaHome">
				<div class="container-paragrafo-home">
					<p><b>Adote</b> e ajude</p>
					<p>um animalzinho</p>
					<p>a encontrar um lar</p>
				</div>
			</div>
		</div>

		<div class="container-home2">
			<div class="container-home2-1">
				<div class="container-card">
					<div class="card"></div>
					<div class="card"></div>
					<div class="card"></div>
				</div>
				<p>Dê o primeiro passo para encontrar seu novo amigo peludo!
					Nesta etapa, explore os pets disponíveis para adoção. Veja suas
					fotos, leia suas histórias e descubra qual deles toca seu coração.</p>
			</div>
			<div class="container-home2-2">
				
				<p><b>Explorar</b></p>
			</div>
		</div>
		<div class="container-home3">
			<div class="container-home3-1">
			</div>
			<div class="container-home3-2">
				<div class="container-contador-pets">
			    	<p>0 0 0 0 0 0</p>
				</div>
				<div class="container-paragrafo-home">
			    	<p>Já foram adotados pela <b>Central Pet</b> até agora</p>
				</div>
			</div>
		</div>
	</main>
</body>

</html>
