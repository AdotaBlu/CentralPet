<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style><%@include file="/resources/css/estilo.css"%></style>

    <title>Cadastro Tutor</title>

</head>

<body>
	<main>
   		<form method="post"  action="cadastro-ong">
   
  		<label for="logradouro">Logradouro</label>
        <input type="text" id="logradouro" name="logradouro">
        
        <label for="numero">Número</label>
        <input type="number" id="numero" name="numero">
        
        <label for="bairro">Bairro</label>
        <input type="text" id="bairro" name="bairro">
        
        <label for="cep">CEP</label>
        <input type="text" id="cep" name="cep">
        
        <label for="pontoReferencia">Ponto de Referência</label>
        <input type="text" id="pontoReferencia" name="pontoReferencia">
        
		<h1>Informações da ONG</h1> 
		   
        <label for="nome">Razão Social</label>
        <input type="text" id="nome" name="nome">
       
        <label for="cpf">CNPJ</label>
        <input type="number" id="cnpj" name="cnpj">
  
        <label for="telefone">Telefone</label>
        <input type="tel" id="telefone" name="telefone">
        
        <label for="email">Email</label>
        <input type="email" id="email" name="email">
        
        <label for="senha">Senha</label>
        <input type="password" id="senha" name="senha">
        
        <div class="container-botao">
			<button type="reset" class= "botao-secundario">Limpar</button>
        	<button type="submit" class="botao-primario">Salvar</button>		
        </div>
       
	    </form>
	</main>

</body>

</html>