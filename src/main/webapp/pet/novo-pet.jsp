<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"
	rel="stylesheet">

<style><%@include file="/resources/css/estilo.css"%></style>
<script><%@include file="/resources/javaScript/JavaScript.js"%></script>

<title>Cadastro de Pet</title>

</head>

<body>

	<c:if test="${tutorSessao == null && ongSessao == null}">
		<%@ include file="../nav-bar/nav-usuario-deslogado.jsp"%>
	</c:if>

	<c:if test="${tutorSessao != null}">
		<%@ include file="../nav-bar/nav-tutor-logado.jsp"%>
	</c:if>

	<c:if test="${ongSessao != null}">
		<%@ include file="../nav-bar/nav-ong-logada.jsp"%>
	</c:if>

	<main>

		<form method="post" action="cadastrar-pet"
			enctype="multipart/form-data">
			<div class="container-cadastro">
				<div class="input-cadastro">
					<label for="nome">Nome</label> 
					<input type="text" id="nome" name="nome">
				</div>

				<div class="input-cadastro">
					<label for="peso">Peso</label> 
					<input type="text" id="peso" name="peso">
				</div>

				<div class="input-cadastro">
					<input type="hidden" id="estadoPet" name="estado-pet" value="ATIVO">
				</div>
				<div class="container-select-pet">
					<div class="input-cadastro">
						<label for="vacinas">Vacinas</label>
						<input type="text" id="vacinas" name="vacinas">
					</div>
					
					<div class="input-cadastro">
						<label for="dataNascimento">Data de Nascimento</label> 
						<input type="date" id="dataNascimentoPet" name="data-nascimento-pet">
					</div>
					
					<div class="select-cadastro">
						<label for="drop_down_pelagem">Pelagem</label> 
							<select name="pelagem-pet" id="drop_down_pelagem">
							<option value="CURTO">Curto</option>
							<option value="MEDIO">Medio</option>
							<option value="LONGO">Longo</option>
						</select>
					</div>
					
					<div class="select-cadastro">
						<label for="drop_down_porte">Porte</label>
							 <select name="porte-pet" id="drop_down_porte">
							<option value="MINI">Mini</option>
							<option value="PEQUENO">Pequeno</option>
							<option value="MEDIO">Médio</option>
							<option value="GRANDE">Grande</option>
							<option value="GIGANTE">Gigante</option>
						</select>
					</div>
					
					<div class="select-cadastro">
						<label for="drop_down_sexo">Sexo</label>
							 <select name="sexo-pet" id="drop_down_sexo">
							<option value="MACHO">Macho</option>
							<option value="FEMEA">Fêmea</option>
						</select>
					</div>
					
					<div class="select-cadastro">
						<label for="drop_down_especie">Espécie</label> 
					<select name="especie-pet" id="drop_down_especie">
							<option value="GATO">Gato</option>
							<option value="CACHORRO">Cachorro</option>
						</select>
					</div>
				</div>
					
				<div class="input-cadastro">
					<label for="castrado">Castrado</label>
					<div class="value-radio">
						<input type="radio" id="input-radio" name="castrado" value="SIM">
						<label for="sim">Sim</label> 	
						<input type="radio" id="input-radio" name="castrado" value="NAO"> 
						<label for="nao">Não</label>
					</div>
				</div>
				
				<div class="input-cadastro">
					<label for="descricao">Descrição</label>
					<textarea name="descricao" id="descricao" rows="10" cols="30"></textarea>
				</div>
					
				<div class="input-cadastro">
					<label for="fotos">Escolha várias fotos:</label> 
					<input type="file" name="fotos" id="fotos" accept="image/*" multiple>
				</div>
			</div>
			<div class="container-cadastro">
				<p class="label-adicionar-foto">Adicionar foto</p>
				<label for="fotoPerfil" class="input-adicionar-foto">
				<img alt="icone-adicionar-foto" id="icone-adicionar-foto" src="data:image/png;base64,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">
				</label> 
				<input type="file" name="foto-perfil" id="fotoPerfil" accept="image/*" onchange="adicionarFoto(this)">
			</div>
		</form>

	</main>

</body>

</html>