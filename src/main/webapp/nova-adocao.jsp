<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Adoção</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"rel="stylesheet">

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
		<c:if test="${ong != null}"> 
				<h1>Nome da ONG: <c:out value='${ong.nome}' /></h1>
		</c:if>
		
		<c:if test="${tutor != null}"> 
				<h1>Nome do tutor: <c:out value='${tutor.nome}' /></h1>
		</c:if>
		
		<c:if test="${termos != null}"> 
			<div class="texto-aceitar-termo">
				<c:forEach var="termo" items="${termos}">
				<textarea rows="35" cols="140" name="termo">
				<c:out value='${termo.termo}' />
				</textarea>
				</c:forEach>
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