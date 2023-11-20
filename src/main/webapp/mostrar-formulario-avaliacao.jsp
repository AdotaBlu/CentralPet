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
	
		<h1>Detalhes da Adoção</h1>
		<div>
			<table>
				<thead>
					<tr>
						<th>Pet</th>
						<th>Tutor</th>
						<th>ONG</th>
						<th>Data</th>
					</tr>
				</thead>
				<c:if test="${adocao != null && tutorSessao != null}">
				<tbody>
						<tr>
							<td><c:out value='${adocao.pet.nome}'></c:out></td>
							<td><c:out value='${tutorSessao.nome}'></c:out></td>
							<td><c:out value='${adocao.ong.nome}'></c:out></td>
							<td><c:out value='${adocao.dataAdocao}'></c:out></td>
						</tr>
				</tbody>
				</c:if>
			</table>
		</div>
		<div>
			<form action="registrar-avaliacao" method="post">
				<c:if test="${adocao != null && tutorSessao != null}">
					<input type="hidden" id="id-tutor" name="id-tutor"  value="<c:out value='${tutorSessao.id}' />">
					<input type="hidden" id="id-ong" name="id-ong"  value="<c:out value='${adocao.ong.id}' />">
				</c:if>
				
				<label for="nota">Nota:</label>
	        	<input type="number" id="nota" name="nota" placeholder="De uma nota de 1 a 5">
	        	
	        	<label for="nota">Nota:</label>
	        	<input type="text" id="depoimento" name="depoimento" placeholder="Descreva ligeiramente como foi o seu processo de adoção com esta ong">
	        	
	        	<button type="reset" class= "botao-secundario">Limpar</button>
        		<button type="submit" class="botao-primario">Salvar</button>	
			</form>
		</div>
	</body>
</html>