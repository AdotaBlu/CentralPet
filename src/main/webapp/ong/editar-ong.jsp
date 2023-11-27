<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Dados ONG</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"rel="stylesheet">
<style><%@include file="/resources/css/estilo.css"%></style>
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

	<main>
		<form method="post" action="atualizar-ong" enctype="multipart/form-data">
		
			<div class="container-editar">
				<h1>Editar Dados ONG</h1>
				<div class="editar-info-tutor">
					<div class="editar-foto-tutor">
						<label class="label-inserir-foto" for="foto-perfil">+</label> 
						<img alt="foto-perfil-tutor" width="150px" height="150px" src="<c:out value="${ongSessao.urlFoto()}"></c:out>">
						<input type="file" name="foto-perfil" id="foto-perfil" accept="image/*">
					</div>
					<div class="editar-dados">
						<div class="input-editar">
							<label for="nome">Nome</label> 
							<input type="text" id="nome" name="nome" value="<c:out value='${ongSessao.nome}' />">
						</div>
						<div class="input-editar">
							<label for="cnpj">CNPJ</label> 
							<input type="text" id="cnpj" name="cnpj" value="<c:out value='${ongSessao.cnpj}' />">
						</div>
						<div class="input-editar">
							<label for="email">E-mail</label> 
							<input type="text" id="email" name="email" value="<c:out value='${contato.email}' />">
						</div>
						<div class="input-editar">
							<label for="telefone">Telefone</label> 
							<input type="tel" id="telefone" name="telefone" value="<c:out value='${contato.telefone}' />">
						</div>
							<input type="hidden" id="senha" name="senha" value="<c:out value='${ongSessao.senha}' />">
					</div>
				</div>
				
				<div class="editar-endereco">
					<div class="input-editar">
    				<label for="logradouro">Logradouro</label>
    				<input type="text" id="logradouro" name="logradouro" value="<c:out value='${endereco.logradouro}' />">
					</div>

					<div class="input-editar">
    				<label for="numero">Número</label>
    				<input type="number" id="numero" name="numero" value="<c:out value='${endereco.numero}' />">
					</div>

					<div class="input-editar">
   					<label for="bairro">Bairro</label>
    				<input type="text" id="bairro" name="bairro" value="<c:out value='${endereco.bairro}' />">
					</div>

					<div class="input-editar">
    				<label for="cep">CEP</label>
   					<input type="text" id="cep" name="cep" value="<c:out value='${endereco.cep}' />">
					</div>

					<div class="input-editar">
    				<label for="pontoReferencia">Ponto de Referência</label>
    				<input type="text" id="pontoReferencia" name="ponto-referencia" value="<c:out value='${endereco.pontoReferencia}' />">
					</div>
				</div>
			</div>
			<input type="hidden" id="id-ong" name="id-ong" value="<c:out value='${ongSessao.id}' />">
			<input type="hidden" id="id-contato" name="id-contato" value="<c:out value='${contato.id}' />">
			<input type="hidden" id="id-endereco" name="id-endereco" value="<c:out value='${endereco.id}' />">		
			<div class="container-botao">
				<button type="reset" class="botao-secundario">Limpar</button>
				<button type="submit" class="botao-primario">Salvar</button>
			</div>
		</form>
			
	</main>
</body>
</html>