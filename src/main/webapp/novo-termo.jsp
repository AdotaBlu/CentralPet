<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<title>Termo</title>
</head>
<body>
	<main>
		<c:if test="${ong != null}">
			<h1>
				<c:out value='${ong.nome}' />
			</h1>
		</c:if>

		<c:if test="${ong == null}">
			<h1>ong = null</h1>
		</c:if>

		<form method="post" action="cadastro-termo">
			<label for="termo">Termo da ONG</label> <input type="text" id="termo"
				name="termo">

			<div class="container-botao">
				<button type="reset" class="botao-secundario">Limpar</button>
				<button type="submit" class="botao-primario">Salvar</button>
			</div>
		</form>

	</main>


</body>
</html>