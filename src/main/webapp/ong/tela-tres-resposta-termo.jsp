<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>LEIA</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<style><%@include file="/resources/css/estilo.css"%></style>
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
		
		<c:if test="${ongSessao != null}">
		<%@ include file="../nav-bar/nav-ong-logada.jsp" %>
		</c:if>
		
		<main class="container-grid">
		
			<div class="container-geral-tela-tres-resposta-termo">
			
				<div class="titulo-tela-tres-resposta-termo">
					<h2>Parabéns pela maravilhosa decisão de adotar um pet!</h2>
				</div>
				<div class="texto-tela-tres-resposta-termo">
					<h3>Preparando o Lar</h3>
					<p>Antes da adoção, queremos garantir que sua casa seja um lugar seguro
					e acolhedor para o novo pet. Nossa equipe fornecerá orientações e dicas 
					para preparar seu lar para a chegada do seu amigo peludo.</p>
				</div>
				
				<div class="texto-tela-tres-resposta-termo">
					<h3>Suporte Contínuo</h3>
					<p>Mesmo após a adoção, estamos aqui por você. Oferecemos suporte contínuo 
					para garantir que a transição seja suave e para responder a quaisquer 
					perguntas que você possa ter. Compartilhe suas histórias conosco e juntos 
					celebraremos essa linda jornada de amor.</p>
				</div>
				
				<div class="container-botao-tela-tres-resposta-termo">
					
					
					<form action="inserir-avaliacao" method="post">
					
						<input type="hidden" name="id-adocao" value='<c:out value="${adocao.id}"></c:out>'>
					
						<button type="submit" class="botao-entendi">Entendi</button>
					</form>
			
				</div>
			
			</div>
		</main>
	</body>
</html>