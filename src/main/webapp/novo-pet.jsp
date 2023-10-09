<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style><%@include file="/resources/css/estilo.css"%></style>
    <title>Cadastro de Pet</title>

</head>

<body>
	<main>
				
			<c:if test="${ong != null}"> 
				<h1><c:out value='${ong.nome}' /></h1>
			</c:if>
			
			<c:if test="${ong == null}"> 
				<h1> ong = null </h1>
			</c:if>
			
   			<form method="post"  action="cadastro-pet">
  
				<h1>Informações do Pet</h1> 
		   
        		<label for="nome">Nome do Pet</label>
        		<input type="text" id="nome" name="nome">
       
        		<label for="vacinas">Vacinas do Pet</label>
        		<input type="text" id="vacinas" name="vacinas">
  
        		<label for="descricao">Descrição do Pet</label>
        		<input type="text" id="descricao" name="descricao">
        
        		<label for="dataNascimento">Data de Nascimento do Pet</label>
        		<input type="date" id="dataNascimento" name="dataNascimento">
        		
        		<label for="idade">Idade do Pet</label>
        		<input type="number" id="idade" name="idade">
        		
        		
        		<input type="hidden" id="statusPet" name="statusPet" value="DISPONIVEL">
        		<input type="hidden" id="estadoPet" name="estadoPet" value="ATIVO">
        		
       			 <label for="drop_down_especie">Especie do Pet</label>
      			  <select name="especiePet" id="drop_down_especie">
            		<option value="GATO">Gato</option>
         			<option value="CACHORRO">Cachorro</option>
       			 </select>
       			 
       			 <label for="drop_down_porte">Porte</label>
      			  <select name="portePet" id="drop_down_porte">
            		<option value="MINI">Mini</option>
         			<option value="PEQUENO">Pequeno</option>
         			<option value="MEDIO">Medio</option>
         			<option value="GRANDE">Grande</option>
         			<option value="GIGANTE">Gigante</option>
       			 </select>
       			 
       			 <label for="drop_down_sexo">Sexo do Pet</label>
      			  <select name="sexoPet" id="drop_down_sexo">
            		<option value="MACHO">Macho</option>
         			<option value="FEMEA">Femea</option>
       			 </select>
       			 
       			 
       			 <label for="drop_down_pelagem">Pelagem</label>
      			  <select name="pelagemPet" id="drop_down_pelagem">
            		<option value="CURTO">Curto</option>
         			<option value="MEDIO">Medio</option>
         			<option value="LONGO">Longo</option>
       			 </select>
       		
        		<div class="container-botao">
					<button type="reset" class= "botao-secundario">Limpar</button>
        			<button type="submit" class="botao-primario">Salvar</button>		
        		</div>
	    	</form>
    
	</main>

</body>

</html>