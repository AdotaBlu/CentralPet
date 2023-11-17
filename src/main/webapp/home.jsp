<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style><%@include file="/resources/css/estilo.css"%></style>
<title>Home</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"rel="stylesheet">

<link rel="stylesheet" href="">

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
	
	<div class="conteinerHome">
		<div class="container-secaoHome">
				<img src="/CentralPet/src/main/webapp/resources/img/logo-redonda.png" alt="Logo do CentralPet">
		
				<div>
					<p><b>Adote</b> e ajude um <br>animalzinho a encontrar <br>um lar.</p>
				</div>
				
			</div>
			
			<div class="container-secaoHome">
				<p><b>Fique de olho e escolha um amigo.</b></p>
				<div>
					<span>Cards de pets</span>
				</div>
			</div>
			
			<div class="container_secaoHome">
				<p>Dê o primeiro passo para encontrar seu novo amigo peludo! Nesta etapa, explore os pets disponíveis
				 para adoção. Veja suas fotos, leia suas histórias e descubra qual deles toca seu coração.</p>
				 
				<p>Já foram adotados pela central pet até agora.</p>

			</div>
			
			<div class="container-secaoHome">
					<p><b>Ongs em destaque.</b></p>
				<div>
					<span>CARD DAS ONGS EM DESTAQUE</span>
				</div>
				
				<p>Essa são as ONGs que estão em destaque, deêm uma olhada no 
				perfil delas para poder achar o seu novo amiguinho, e dar um 
				novo lar e uma nova família para eles.</p>
					
			</div>
			
			<div class="container-secaoHome">
			</div>
			
			<div class="container-secaoHome">
		</div>
	</div>
	
	
	<main>
		<a href="<%=request.getContextPath()%>/novo-tutor">Cadastrar Tutor</a>
		<a href="<%=request.getContextPath()%>/editar-tutor">Editar Tutor</a>
		<a href="<%=request.getContextPath()%>/mostrar-perfil-tutor">Perfil Tutor</a>
		<a href="<%=request.getContextPath()%>/nova-ong">Cadastrar ONG</a>
		<a href="<%=request.getContextPath()%>/editar-ong">Editar ONG</a>
		<a href="<%=request.getContextPath()%>/mostrar-perfil-ong">Perfil ONG</a>
		<a href="<%=request.getContextPath()%>/novo-pet">Cadastrar Pet</a>
		<a href="<%=request.getContextPath()%>/editar-pet">Editar Pet</a>
		<a href="<%=request.getContextPath()%>/mostrar-perfil-pet">Perfil Pet</a>
		<a href="<%=request.getContextPath()%>/mostrar-cards-pets">Pets Cadastrados</a>
		<a href="<%=request.getContextPath()%>/mostrar-cards-ongs">ONGs Cadastradas</a>
		<a href="<%=request.getContextPath()%>/mostrar-selecao-cadastro">Seleção Cadastro</a>
		<a href="<%=request.getContextPath()%>/novo-login">Login</a>
		<a href="<%=request.getContextPath()%>/novo-termo">Cadastrar Termo</a>
		<a href="<%=request.getContextPath()%>/editar-termo">Editar Termo</a>
		<a href="<%=request.getContextPath()%>/nova-adocao">Realizar Adoção</a>
		<a href="<%=request.getContextPath()%>/mostrar-tela-aviso">Teste tela aviso</a>
		
		Teste somar pets inseridos
		<c:out value="${soma}"></c:out>
		
	</main>
</body>

</html>
