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

    <form method="post"  action="cadastro-tutor">
    	
  		<label for="logradouro">Logradouro</label>
        <input type="text" id="logradouro" name="logradouro">
        
        <label for="numero">Número</label>
        <input type="number" id="numero" name="numero">
        
        <label for="bairro">Bairro</label>
        <input type="text" id="bairro" name="bairro">
        
        <label for="cep">CEP</label>
        <input type="text" id="cep" name="cep">
        
        <label for="pontoReferencia">Ponto de Referência</label>
        <input type="text" id="tex" name="pontoReferencia">
        
		<h1>Informações tutor</h1> 
		   
        <label for="nome">Nome</label>
        <input type="text" id="nome" name="nome">
       
        <label for="cpf">CPF</label>
        <input type="text" id="sobrenome" name="cpf">
        
        <label for="dataNasc">Data de Nascimento</label>
        <input type="date" id="dataNascimento" name="dataNascimento"/>
  
        <label for="drop_down_genero">Genero</label>
        <select name="generoTutor" id="drop_down_genero">
            <option value="MASCULINO">Masculino</option>
            <option value="FEMININO">Feminino</option>
            <option value="OUTROS">Outros</option>
        </select>
        
        <label for="telefone">Telefone</label>
        <input type="tel" id="telefone" name="telefone">
        
        <label for="email">Email</label>
        <input type="email" id="email" name="email">
        
        <label for="senha">Senha</label>
        <input type="password" id="senha" name="senha">
        
        <button type="submit">Salvar</button>		
		<button type="reset">Limpar</button>
       
    </form>

</body>

</html>