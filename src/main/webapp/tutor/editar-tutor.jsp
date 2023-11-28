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
<script><%@include file="/resources/javaScript/JavaScript.js"%></script>
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
				
				<div class="editar-foto-perfil" id="etapa-um">
					<label class="label-editar-foto" for="foto-perfil">Foto de Perfil</label> 
					<img alt="foto-perfil-tutor" class="editar-foto-perfil" src="<c:out value="${tutorSessao.urlFoto()}"></c:out>">
					<input type="file" name="foto-perfil" id="foto-perfil" accept="image/*">
				</div>
				
				<div class="editar-infos-perfil" id="etapa-um-parte-dois">
				
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
						<input type="date" id="data-nascimento" name="data-nascimento" value='${tutorSessao.dataNascimento}'>
					</div>
					
					<input type="hidden" id="senha" name="senha" value="<c:out value='${tutorSessao.senha}' />">
					
					<div class="grupo-inputs">
						<label for="drop_down_genero">Gênero</label> 
						<select name="genero-tutor">
							<option value="MASCULINO">Masculino</option>
							<option value="FEMININO">Feminino</option>
							<option value="OUTROS">Outros</option>
						</select>
					</div>
				</div>
				
				<div class="container-editar-endereco" id="etapa-dois">
				
					<div class="grupo-inputs-endereco">
    					<label for="logradouro">Logradouro</label>
    					<input type="text" id="logradouro-editar-endereco" name="logradouro" value="<c:out value='${endereco.logradouro}' />">
					</div>

					<div class="grupo-inputs-endereco">
    					<label for="numero">Número</label>
    					<input type="number" id="numero-editar-endereco" name="numero" value="<c:out value='${endereco.numero}' />">
					</div>

					<div class="grupo-inputs-endereco">
   						<label for="bairro">Bairro</label>
    					<select name="bairro" id="bairro-editar-endereco">
							<option value="BADENFURT">Badenfurt</option>
							<option value="FIDELIS">Fidélis</option>
							<option value="ITOUPAVA_CENTRAL">Itoupava Central</option>
							<option value="ITOUPAVAZINHA">Itoupavazinha</option>
							<option value="SALTO_DO_NORTE">Salto do Norte</option>
							<option value="TESTO_SALTO">Testo Salto</option>
							<option value="VILA_ITOUPAVA">Vila Itoupava</option>
							<option value="FORTALEZA">Fortaleza</option>
							<option value="FORTALEZA_ALTA">Fortaleza Alta</option>
							<option value="ITOUPAVA_NORTE">Itoupava Norte</option>
							<option value="NOVA_ESPERANCA">Nova Esperança</option>
							<option value="PONTA_AGUDA">Ponta Aguda</option>
							<option value="TRIBESS">Tribess</option>
							<option value="VORSTADT">Vorstadt</option>
							<option value="GLORIA">Glória</option>
							<option value="GARCIA">Garcia</option>
							<option value="PROGRESSO">Progresso</option>
							<option value="RIBEIRAO_FRESCO">Ribeirão Fresco</option>
							<option value="VALPARAISO">Valparaíso</option>
							<option value="VILA_FORMOSA">Vila Formosa</option>
							<option value="AGUA_VERDE">Água Verde</option>
							<option value="SALTO">Salto</option>
							<option value="ESCOLA_AGRICOLA">Escola Agrícola</option>
							<option value="PASSO_MANSO">Passo Manso</option>
							<option value="SALTO_WEISSBACH">Salto Weissbach</option>
							<option value="VELHA">Velha</option>
							<option value="VELHA_CENTRAL">Velha Central</option>
							<option value="VELHA_GRANDE">Velha Grande</option>
							<option value="BOA_VISTA">Boa Vista</option>
							<option value="BOM_RETIRO">Bom Retiro</option>
							<option value="CENTRO">Centro</option>
							<option value="ITOUPAVA_SECA">Itoupava Seca</option>
							<option value="JARDIM_BLUMENAU">Jardim Blumenau</option>
							<option value="VICTOR_KONDER">Victor Konder</option>
							<option value="VILA_NOVA">Vila Nova</option>
						</select>
					</div>

					<div class="grupo-inputs-endereco">
    					<label for="cep">CEP</label>
   						<input type="text" id="cep-editar-endereco" name="cep" value="<c:out value='${endereco.cep}' />">
					</div>

					<div class="grupo-inputs-endereco">
    					<label for="pontoReferencia">Ponto de Referência</label>
    					<input type="text" id="referencia-editar-endereco" name="ponto-referencia" value="<c:out value='${endereco.pontoReferencia}' />">
					</div>
					
				</div>
			
				<input type="hidden" id="id-tutor" name="id-tutor" value="<c:out value='${tutorSessao.id}' />">
				<input type="hidden" id="id-contato" name="id-contato" value="<c:out value='${contato.id}' />">
				<input type="hidden" id="id-endereco" name="id-endereco" value="<c:out value='${endereco.id}' />">	
		
			</div>
			
			<div class="container-botoes-editar">
				<button type="button" class="botao-voltar" onclick="voltarEtapa(0)" id="botao-voltar">Voltar</button>
				<button type="submit" class="botao-salvar" id="botao-salvar">Salvar</button>
				<button type="button" class="botao-proximo" id="botao-proximo" onclick="proximaEtapa(1)">Continuar</button>	
			</div>
				
		</form>	
		</div>
	</main>

</body>
</html>






