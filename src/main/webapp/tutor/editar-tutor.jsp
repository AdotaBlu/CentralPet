<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Dados Tutor</title>
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

	<main class="container-grid">
		
	<div class="container-geral">
		
		<form method="post" action="atualizar-tutor" enctype="multipart/form-data" class="form-editar-perfil">
		
			<div class="container-editar">
				
				<div class="editar-foto-perfil">
					<label class="label-editar-foto" for="foto-perfil">Foto de Perfil</label> 
					<img alt="foto-perfil-tutor" class="editar-foto-perfil" src="<c:out value="${tutorSessao.urlFoto()}"></c:out>">
					<input type="file" name="foto-perfil" id="foto-perfil" accept="image/*">
				</div>
				
				<div class="editar-infos-perfil">
				
					<div class="grupo-inputs">
						<label for="nome">Nome</label> 
						<input type="text" id="nome" name="nome" value="<c:out value='${tutorSessao.nome}' />">
					</div>
					
					<div class="grupo-inputs">
						<label for="cpf">CPF</label> 
						<input type="text" id="cpf" name="cpf" value="<c:out value='${tutorSessao.cpf}' />">
					</div>
					
					<div class="grupo-inputs">
						<label for="email">E-mail</label> 
						<input type="text" id="email" name="email" value="<c:out value='${contato.email}' />">
					</div>
					
					<div class="grupo-inputs">
						<label for="telefone">Telefone</label> 
						<input type="tel" id="telefone" name="telefone" value="<c:out value='${contato.telefone}' />">
					</div>
					
					<div class="grupo-inputs">
						<label for="data-nascimento">Data de Nascimento</label> 
						<input type="date" id="data-nascimento" name="data-nascimento" value='${tutor.dataNascimento}'>
					</div>
					
					<input type="hidden" id="senha" name="senha" value="<c:out value='${tutor.senha}' />">
					
					<div class="grupo-inputs">
						<label for="drop_down_genero">Gênero</label> 
						<select name="genero-tutor">
							<option value="MASCULINO">Masculino</option>
							<option value="FEMININO">Feminino</option>
							<option value="OUTROS">Outros</option>
						</select>
					</div>
				</div>
				
				<div class="container-editar-endereco">
				
					<div class="">
    					<label for="logradouro">Logradouro</label>
    					<input type="text" id="logradouro" name="logradouro" value="<c:out value='${endereco.logradouro}' />">
					</div>

					<div class="">
    					<label for="numero">Número</label>
    					<input type="number" id="numero" name="numero" value="<c:out value='${endereco.numero}' />">
					</div>

					<div class="">
   						<label for="bairro">Bairro</label>
    					<input type="text" id="bairro" name="bairro" value="<c:out value='${endereco.bairro}' />">
					</div>

					<div class="">
    					<label for="cep">CEP</label>
   						<input type="text" id="cep" name="cep" value="<c:out value='${endereco.cep}' />">
					</div>

					<div class="">
    					<label for="pontoReferencia">Ponto de Referência</label>
    					<input type="text" id="pontoReferencia" name="ponto-referencia" value="<c:out value='${endereco.pontoReferencia}' />">
					</div>
					
				</div>
			
				<input type="hidden" id="id-tutor" name="id-tutor" value="<c:out value='${tutorSessao.id}' />">
				<input type="hidden" id="id-contato" name="id-contato" value="<c:out value='${contato.id}' />">
				<input type="hidden" id="id-endereco" name="id-endereco" value="<c:out value='${endereco.id}' />">	
		
			</div>
			
			<div class="container-botoes-editar">
				<button type="button" class="botao-voltar">Voltar</button>
				<button type="submit" class="botao-salvar">Salvar</button>
				<button type="button" class="botao-proximo">Continuar</button>	
			</div>
				
		</form>	
		</div>
	</main>

</body>
</html>






