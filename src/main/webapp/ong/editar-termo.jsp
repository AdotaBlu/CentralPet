<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<style><%@include file="/resources/css/estilo.css"%></style>
		<title>Home</title>
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"rel="stylesheet">
		<title>Editar Termo</title>
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

	<main>
		<c:if test="${ongSessao != null}">
			<h1>
				<c:out value='${ongSessao.nome}' />
			</h1>
		</c:if>

		<c:if test="${ongSessao == null}">
			<h1>ongSessao = null</h1>
		</c:if>

		<form method="post" action="atualizar-termo">
			<c:forEach var="termo" items="${termos}">
			<textarea rows="35" cols="140" name="termo">
			<c:out value='${termo.termo}' />
			</textarea>
			<input type="hidden" name="id-termo" value='<c:out value="${termo.id}"></c:out>'>
			</c:forEach>
			<div class="container-botao">
				<button type="reset" class="botao-secundario">Limpar</button>
				<button type="submit" class="botao-primario">Salvar</button>
			</div>
		</form>

	</main>

	</body>
</html>