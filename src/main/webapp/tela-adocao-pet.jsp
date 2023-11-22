<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Adoção responsável</title>
		<style><%@include file="/resources/css/estilo.css"%></style>
		<script><%@include file="/resources/javaScript/JavaScript.js"%></script>
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
		
		<div class="principal">
		
			<h2>Adotar Pet</h2>
			
			<div class="adocao-pet-bloco-direita">
			
				<div class="bloco-direita-texto">
					O que é Adoção Responsável? De maneira simples, a adoção responsável é aquisição da guarda de animal e
					o cumprimento das suas responsabilidades de tutor, sem negligências. Desse modo, fazer uma adoção
					responsável é zelar pela saúde,
					segurança e bem-estar do bichano, respeitando suas necessidades, características e particularidades.
				</div>
				
				<div class="bloco-direita-texto-dois">
						<h3>Quais são as responsabilidades do tutor adotante?</h3>
						
					-Em primeiro, todos os membros da casa tem que estar de acordo com a adoção responsavel, Assim evitando
					 mals-tratos e o abandono desse animal. 
					
					-Outro fator crucial é o tutor ter um espaço adequado para o pet, pois o pet deve ter um espaço amplo
					 para brincar e correr, garantindo o seu lazer e sua segurança, Assim sendo um local coberto para se
					  proteger da chuva e do frio. 
					
					-Um pet demanda tempo, então pense se com a sua rotina poderá ter tempo para o seu novo amigo, animais
					 precisam de atenção, cuidados, carinho e a prática regular de exercícios físicos. Sendo assim será
					  preciso tirar um tempo do seu dia para dedicar ao seu pet.
					
					-Além disso, terá que ter um planejamento financeiro, pois os pets causam despesas bascicas como:
					 Alimentação, medicamentos, consultas veterinárias e lazer. Além de possivéis emêrgencias que possam ocorrer.
				</div>
					
				
					
				<form action="mostrar-tela-responder-termo" method="post">
					<input type="hidden" name="id-pet" value='<c:out value="${pet.id}"></c:out>'>
					<input type="hidden" name="id-ong" value='<c:out value="${ong.id}"></c:out>'>
					
					<div class="container-botao">
						<button type="button" class="btn-perfil-ong" onclick="voltar()">Voltar</button>	
						<button type="submit" class="btn-perfil-ong">Avançar</button>
					</div>
				</form>
					
			</div>
		</div>
		
	</body>
</html>