<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<style><%@include file="/resources/css/estilo.css"%></style>
		<script><%@include file="/resources/javaScript/JavaScript.js"%></script>
		<title>Questionário</title>
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"rel="stylesheet">
		<title>Resposta Termo</title>
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
		<main class="container-grid">
			<div class="container-geral-resposta-termo">
			
				<h2>
					Encontrou um pet que você gosta? Ótimo! 
					Preencha nossa candidatura de adoção para que possamos conhecê-lo melhor. 
					Queremos garantir que todos os pets sejam adotados por famílias amorosas e dedicadas.
				</h2>
				
				<div class="container-perguntas-termo">	
				
					<form action="cadastrar-reposta-termo" method="post">
						
						<div class="container-perguntas">
							<label for="pergunta-um">Você já teve experiência prévia com pets? Se sim, por favor, descreva brevemente. *</label>
							<input type="text" name="pergunta-um" id="">
						</div>
						
						<div class="container-perguntas">
							<label for="pergunta-dois">Como é a sua rotina diária? Horários de trabalho, atividades, etc. *</label>
							<input type="text" name="pergunta-dois" id="">
						</div>
						
						<div class="container-perguntas">
							<label for="pergunta-tres">Você possui crianças em casa? Se sim, qual a idade delas?</label>
							<input type="text" name="pergunta-tres" id="">
						</div>
						
						<div class="container-perguntas">
							<label for="pergunta-quatro">Você mora em casa ou apartamento? *</label>
							<select name="pergunta-quatro">
								<option value="CASA">Casa</option>
								<option value="APARTAMENTO">Apartamento</option>
							</select>
						</div>
						
						<div class="container-perguntas">
							<label for="pergunta-cinco">Existe um espaço ao ar livre onde o pet poderá brincar? *</label>
							<input type="text" name="pergunta-cinco" id="">
						</div>
						
						<div class="container-perguntas">
							<label for="pergunta-seis">Como você planeja cuidar do pet enquanto estiver ausente (trabalho, viagens, etc.)? *</label>
							<input type="text" name="pergunta-seis" id="">
						</div>
						
						<div class="container-perguntas">
							<label for="pergunta-sete">Você compreende que a adoção de um pet é um compromisso de longo prazo, que pode durar muitos anos? *</label>
							
							<div class="check-box-resposta">
								<input type="checkbox" name="pergunta-sete" id="">
							</div>
						
						</div>
						
						<div class="container-perguntas">
							<label for="pergunta-oito">Por que você decidiu adotar um pet e o que você espera da relação com ele? *</label>
							<input type="text" name="pergunta-oito" id="">
						</div>
						
						<input type = "hidden" id = "id-pet" name = "id-ong" value = "<c:out value = '${ong.id}'/>">
						<input type = "hidden" id = "id-pet" name = "id-pet" value = "<c:out value = '${pet.id}'/>">
					
						<div class="container-botao-nova-resposta-termo">
							<button type="reset" class= "botao-cadastro-voltar" onclick="voltar()">Voltar</button>
			        		<button type="submit" class="botao-cadastro">Salvar</button>		
			        	</div>
			        		
				</form>
			</div>
		</div>
	</main>
	</body>
</html>