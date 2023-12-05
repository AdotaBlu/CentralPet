<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<style><%@include file="/resources/css/estilo.css"%></style>
		<title>Avaliar ONG</title>
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
	
			<form action="registrar-avaliacao" method="post" class="container-grid">
				
					
				
				<div class="container-depoimento-avaliacao">
		        	
		        	<div class="titulo-depoimento-avaliacao">
		        		<h2>Adicionar Depoimento</h2>
		        	</div>
		        	
		        	<div class="depoimento-avaliacao">
		        		<label for="depoimento">Depoimento*</label>
		        		<textarea rows="" cols="" name="depoimento" placeholder="Digite um depoimento sobre a adoção"></textarea>
		        	</div>
		        	
		        	<div class="nota-avaliacao">
		        		<label for="nota">Nota:</label>
		        		<input type="number" id="nota" name="nota" placeholder="De uma nota de 1 a 5">
		        	</div>	
		        	
		        	<input type="hidden" id="id-tutor" name="id-tutor"  value="<c:out value='${tutorSessao.id}' />">
					<input type="hidden" id="id-ong" name="idong"  value="<c:out value='${ong.id}' />">
		        	
		        	
		        	
		        	<div class="container-botao-avaliacao">
		        		<button type="reset" class= "botao-avaliacao-limpar">Limpar</button>
	        			<button type="submit" class="botao-avaliacao">Salvar</button>
        			</div>
     
        		</div>	
			</form>
		
	</body>
</html>