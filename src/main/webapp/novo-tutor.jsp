<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style><%@include file="/resources/css/estilo.css"%></style>
<c:choose>
	<c:when test="${tutor == null}">
		<title>Cadastro Tutor</title>
	</c:when>
	<c:otherwise>
		<title>Editar Tutor</title>
	</c:otherwise>
</c:choose>
</head>
<body>
	<main>
		<div class="container-endereco">
			<c:if test="${contato == null && endereco == null && tutor == null}">
				<form method="post" action="cadastro-tutor"
					enctype="multipart/form-data">
			</c:if>
			<c:if test="${contato != null && endereco != null && tutor != null}">
				<form method="post" action="atualizar-tutor"
					enctype="multipart/form-data">
			</c:if>
			<c:if test="${endereco != null}">
				<input type="hidden" id="id-endereco" name="id-endereco"
					value="<c:out value='${endereco.id}' />">
			</c:if>
			<label for="logradouro">Logradouro</label> <input type="text"
				id="logradouro" name="logradouro"
				value="<c:out value='${endereco.logradouro}' />"> <label
				for="numero">Número</label> <input type="number" id="numero"
				name="numero" value="<c:out value='${endereco.numero}' />">
			<label for="bairro">Bairro</label> <input type="text" id="bairro"
				name="bairro" value="<c:out value='${endereco.bairro}' />">
			<label for="cep">CEP</label> <input type="text" id="cep" name="cep"
				value="<c:out value='${endereco.cep}' />"> <label
				for="pontoReferencia">Ponto de Referência</label> <input type="text"
				id="pontoReferencia" name="ponto-referencia"
				value="<c:out value='${endereco.pontoReferencia}' />">
		</div>
		<div class="container-cadastro">
			<h1>Informações tutor</h1>
			<c:if test="${tutor != null}">
				<input type="hidden" id="id-tutor" name="id-tutor"
					value="<c:out value='${tutor.id}' />">
			</c:if>
			<div class="input-cadastro">
				<label for="nome">Nome</label> 
				<input type="text" id="nome"name="nome" value="<c:out value='${tutor.nome}' />">
			</div>
			<div class="input-cadastro">
				<label for="cpf">CPF</label> 
				<input type="text" id="cpf" name="cpf"value="<c:out value='${tutor.cpf}' />">
			</div>
			<div class="input-cadastro">
				<label for="dataNascimento">Data de Nascimento</label> 
				<input type="date" id="dataNascimento" name="data-nascimento"value="<c:out value='${tutor.dataNascimento}' />" />
			</div>
			<div class="select-cadastro">
				<label for="drop_down_genero">Gênero</label> <select
					name="genero-tutor" id="drop_down_genero">
					<option value="MASCULINO">Masculino</option>
					<option value="FEMININO">Feminino</option>
					<option value="OUTROS">Outros</option>
				</select>
			</div>
			<c:if test="${contato != null}">
				<input type="hidden" id="id-contato" name="id-contato"
					value="<c:out value='${contato.id}' />">
			</c:if>
			<div class="input-cadastro">
				<label for="telefone">Telefone</label> 
				<input type="tel"id="telefone" name="telefone"value="<c:out value='${contato.telefone}' />">
			</div>
			<div class="input-cadastro">
				<label for="email">Email</label> 
				<input type="email" id="email"name="email" value="<c:out value='${contato.email}' />">
			</div>
			<div class="input-cadastro">
				<label for="senha">Senha</label> 
				<input type="password" id="senha"name="senha" value="<c:out value='${tutor.senha}' />">
			</div>
			<div class="input-cadastro">
				<label for="fotoPerfil">Escolha uma foto de perfil</label> 
				<input type="file" name="foto-perfil" id="fotoPerfil" accept="image/*">
			</div>
			<div class="container-botao">
				<button type="reset" class="botao-secundario">Limpar</button>
				<button type="submit" class="botao-primario">Salvar</button>
			</div>
		</div>
		</form>
	</main>
</body>
</html>
