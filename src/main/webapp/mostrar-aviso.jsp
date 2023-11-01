<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Aviso</title>
		<style><%@include file="/resources/css/estilo.css"%></style>
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
		
		<div class ="tela-aviso">
			<div class ="texto-tela-aviso">
				<h1 id="h1-tela-aviso">PARE</h1>
				<h3>Voce nao pode netrar aqui</h3>
			</div>
		</div>
	</body>
</html>