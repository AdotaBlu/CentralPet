<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"rel="stylesheet">

<style><%@include file="/resources/css/estilo.css"%></style>
<c:choose>
	<c:when test="${tutorSessao == null}">
		<title>Cadastro Tutor</title>
	</c:when>
	<c:otherwise>
		<title>Editar Tutor</title>
	</c:otherwise>
</c:choose>
</head>
<body>

	<c:if test="${tutorSessao == null && ongSessao == null}">
	<%@ include file="../nav-bar/nav-usuario-deslogado.jsp" %>
	</c:if>

	<main>
		<div class="container-endereco">
				<form method="post" action="cadastrar-tutor"enctype="multipart/form-data">
			
			<label for="logradouro">Logradouro</label> 
			<input type="text"id="logradouro" name="logradouro" > 
			<label for="numero">Número</label> 
			<input type="number" id="numero"name="numero" >
			<%@include file="../opcao-bairro.jsp"%>
			<label for="cep">CEP</label> 
			<input type="text" id="cep" name="cep"> 
			<label for="pontoReferencia">Ponto de Referência</label> 
			<input type="text"id="pontoReferencia" name="ponto-referencia">
		</div>
		<div class="container-cadastro">
			<h1>Informações tutor</h1>
			
			<div class="input-cadastro">
				<label for="nome">Nome</label> 
				<input type="text" id="nome"name="nome" >
			</div>
			<div class="input-cadastro">
				<label for="cpf">CPF</label> 
				<input type="text" id="cpf" name="cpf">
			</div>
			<div class="input-cadastro">
				<label for="dataNascimento">Data de Nascimento</label> 
				<input type="date" id="dataNascimento" name="data-nascimento"/>
			</div>
			<div class="select-cadastro">
				<label for="drop_down_genero">Gênero</label> <select
					name="genero-tutor" id="drop_down_genero">
					<option value="MASCULINO">Masculino</option>
					<option value="FEMININO">Feminino</option>
					<option value="OUTROS">Outros</option>
				</select>
			</div>
			<div class="input-cadastro">
				<label for="telefone">Telefone</label> 
				<input type="tel"id="telefone" name="telefone">
			</div>
			<div class="input-cadastro">
				<label for="email">E-mail</label> 
				<input type="email" id="email"name="email" >
			</div>
			<div class="input-cadastro">
				<label for="senha">Senha</label> 
				<input type="password" id="senha"name="senha" >
			</div>
			<div class="input-cadastro">
				<label for="fotoPerfil">Escolha uma foto de perfil</label> 
				<input type="file" name="foto-perfil" id="fotoPerfil" accept="image/*">
			</div>
			<div class="container-botao">
				<button type="reset" class="botao-secundario">Limpar</button>
				<button type="submit" class="botao-primario">Salvar</button>
			</div>
			</form>
		</div>
		
	</main>
</body>
</html>
