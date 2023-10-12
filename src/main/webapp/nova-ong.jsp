<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style><%@include file="/resources/css/estilo.css"%></style>

	<c:if test="${endereco != null && ong != null && contato != null}">
    	<title>Editar Ong</title>
	</c:if>
	
	<c:if test="${endereco == null && ong == null && contato == null}">
		<title>Cadastrar Ong</title>
	</c:if>
</head>

<body>
	<main>
		<c:if test="${endereco == null && ong == null && contato == null}">
   			<form method="post"  action="cadastro-ong" enctype="multipart/form-data">
   		</c:if>
   		
   		<c:if test="${endereco != null && ong != null && contato != null}">
   			<form method="post"  action="atualizar-ong" enctype="multipart/form-data">
   		</c:if>
   		
   		<c:if test="${endereco != null}">
            <input type="hidden" id="id-endereco" name="id-endereco"  value="<c:out value='${endereco.id}' />">
        </c:if>
  		<label for="logradouro">Logradouro</label>
        <input type="text" id="logradouro" name="logradouro"  value="<c:out value='${endereco.logradouro}' />">
        
        <label for="numero">Número</label>
        <input type="number" id="numero" name="numero" value="<c:out value='${endereco.numero}' />">
            
        <label for="bairro">Bairro</label>
        <input type="text" id="bairro" name="bairro" value="<c:out value='${endereco.bairro}' />">
            
        <label for="cep">CEP</label>
        <input type="text" id="cep" name="cep" value="<c:out value='${endereco.cep}' />">
        
        <label for="pontoReferencia">Ponto de Referência</label>
        <input type="text" id="pontoReferencia" name="pontoReferencia" value="<c:out value='${endereco.pontoReferencia}' />">
        
		<h1>Informações da ONG</h1> 
		 
		<c:if test="${ong != null}">
            <input type="hidden" id="id-ong" name="id-ong"  value="<c:out value='${ong.id}' />">
        </c:if> 
		   
        <label for="nome">Razão Social</label>
        <input type="text" id="nome" name="nome" value="<c:out value='${ong.nome}' />">
       
        <label for="cpf">CNPJ</label>
        <input type="number" id="cnpj" name="cnpj" value="<c:out value='${ong.cnpj}' />">
  		
  		<c:if test="${contato != null}">
            <input type="hidden" id="id-contato" name="id-contato"  value="<c:out value='${contato.id}' />">
        </c:if> 
        
        <label for="telefone">Telefone</label>
        <input type="tel" id="telefone" name="telefone" value="<c:out value='${contato.telefone}' />">
        
        <label for="email">Email</label>
        <input type="email" id="email" name="email" value="<c:out value='${contato.email}' />">
        
        <label for="senha">Senha</label>
        <input type="password" id="senha" name="senha" value="<c:out value='${ong.senha}' />">
        
        <label for="imagem">Escolha uma foto de perfil</label>
    	<input type="file" name="fotoPerfil" id="fotoPerfil" accept="image/*">
        
        <div class="container-botao">
			<button type="reset" class= "botao-secundario">Limpar</button>
        	<button type="submit" class="botao-primario">Salvar</button>		
        </div>
       
	    </form>
	</main>

</body>

</html>