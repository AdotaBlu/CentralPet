<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Adoção</title>
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
	
	<c:if test="${ongSessaoSessao != null}">
	<%@ include file="../nav-bar/nav-ong-logada.jsp" %>
	</c:if>

	<main>
		<c:if test="${ong != null}"> 
				<h1>Nome da ONG: <c:out value='${ong.nome}' /></h1>
		</c:if>
		
		<c:if test="${tutor != null}"> 
				<h1>Nome do tutor: <c:out value='${tutorSessao.nome}' /></h1>
		</c:if>
		
		<c:if test="${termo != null}"> 
			<div class="texto-aceitar-termo">
				<textarea rows="35" cols="140" name="termo">
				<c:out value='${termo.termo}' />
				</textarea>
			</div>
		</c:if>
		
		<c:if test="${pet != null}"> 
				<h1>Pet: <c:out value='${pet.nome}' /></h1>
				<form method="post" action="cadastrar-adocao" >
					<h1> Adoção requerida</h1>
					<input type="hidden" id="id-pet" name="id-pet"  value="<c:out value='${pet.id}' />">
					<input type="hidden" id="id-ong" name="id-ong"  value="<c:out value='${ong.id}' />">
					 <div class="container-botao">
        			<button type="submit" class="botao-primario">Salvar Adoção</button>		
       				</div>
				</form>
		</c:if>
		
		
		<c:if test="${ong == null}"> 
			<h1>ONG nula</h1>
		</c:if>
		
		<c:if test="${tutor == null}"> 
			<h1>Tutor nulo</h1>
		</c:if>
		
		<c:if test="${termo == null}"> 
			<h1>Termo nulo</h1>
		</c:if>
		
		<c:if test="${pet == null}"> 
			<h1>Pet nulo</h1>
		</c:if>
	</main>

</body>
</html>