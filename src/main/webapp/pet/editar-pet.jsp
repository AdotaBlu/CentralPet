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

<title>Editar Pet</title>

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

		<form method="post" action="atualizar-pet"enctype="multipart/form-data" class="container-grid-pet">
			
			<div class="container-cadastro-pet-foto">
				<p class="label-adicionar-foto">Adicionar fotos</p>
				<label for="fotoPerfil" class="input-adicionar-foto">
					<img alt="icone-adicionar-foto" id="icone-adicionar-foto" src="<c:out value='${pet.fotoPrincipalPet()}'/>">
				</label> 
				
				<input type="file" name="foto-perfil" id="fotoPerfil" accept="image/*" onchange="adicionarFoto(this)" multiple="multiple">
			
			</div>
		
			<div class="container-cadastro-infos">
				<div class="input-cadastro">
					<label for="nome">Nome</label> 
					<input type="text" id="nome" name="nome" value="<c:out value='${pet.nome}' />">
					<input type="hidden" id="id" name="id-pet" value="<c:out value='${pet.id}' />">
				</div>

				<div class="input-cadastro">
					<label for="peso">Peso</label> 
					<input type="text" id="peso" name="peso" value="<c:out value='${pet.peso}' />">
				</div>

				<div class="input-cadastro">
					<input type="hidden" id="estadoPet" name="estado-pet" value="ATIVO">
				</div>
				
				<div class="container-select-pet">
				
					<div class="input-cadastro">
						<label for="vacinas">Vacinas</label>
						<input type="text" id="vacinas" name="vacinas" value="<c:out value='${pet.vacinas}' />">
					</div>
					
					<div class="cadastro-direita-pet">
						<label for="dataNascimento">Data de Nascimento</label> 
						<input type="date" id="dataNascimentoPet" name="data-nascimento-pet" value="<c:out value='${pet.dataNascimento}' />">
					</div>
					
					<div class="select-cadastro">
						<label for="drop_down_pelagem">Pelagem</label> 
							<select name="pelagem-pet" id="drop_down_pelagem">
							<option value="CURTO">Curto</option>
							<option value="MEDIO">Medio</option>
							<option value="LONGO">Longo</option>
						</select>
					</div>
					
					<div class="cadastro-direita-pet">
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
					
					<div class="cadastro-direita-pet">
						<label for="drop_down_especie">Espécie</label> 
					<select name="especie-pet" id="drop_down_especie">
							<option value="GATO">Gato</option>
							<option value="CACHORRO">Cachorro</option>
						</select>
					</div>
					
				</div>
					
				<div class="input-castrado-pet">
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
					<textarea name="descricao" id="descricao"><c:out value='${pet.descricao}'/></textarea>
				</div>
				
				<div class="container-botao-pet">
					<button type="button" class="botao-cadastro-pet-voltar" onclick="voltar()">Voltar</button>	
        			<button type="submit" class="botao-cadastro-pet">Atualizar</button>		
           		</div>
				
			</div>
			

            
		</form>

	</main>

</body>

</html>