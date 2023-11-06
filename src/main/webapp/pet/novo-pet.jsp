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
    <title>Cadastro de Pet</title>

</head>

<body>
	<main>
				
			<c:if test="${ong != null}"> 
				<h1><c:out value='${ong.nome}' /></h1>
				<img alt="foto-de-perfil" src='<c:out value="${foto.urlImagem}"></c:out>' width="100">
			</c:if>
			
			<c:if test="${ong == null}"> 
				<h1> ong = null </h1>
			</c:if>
			
   			<form method="post"  action="cadastrar-pet" enctype="multipart/form-data">
  
				<h1>Informações do Pet</h1> 
		   
        		<label for="nome">Nome do Pet</label>
        		<input type="text" id="nome" name="nome">
       
        		<label for="vacinas">Vacinas do Pet</label>
        		<input type="text" id="vacinas" name="vacinas">
  
        		<label for="descricao">Descrição do Pet</label>
        		<input type="text" id="descricao" name="descricao">
        
        		<label for="dataNascimento">Data de Nascimento do Pet</label>
        		<input type="date" id="dataNascimentoPet" name="data-nascimento-pet">
        		
        		<label for="peso">Peso do Pet</label>
        		<input type="text" id="peso" name="peso">
        		
        		<input type="hidden" id="estadoPet" name="estado-pet" value="ATIVO">
        		
       			 <label for="drop_down_especie">Espécie do Pet</label>
      			  <select name="especie-pet" id="drop_down_especie">
            		<option value="GATO">Gato</option>
         			<option value="CACHORRO">Cachorro</option>
       			 </select>
       			 
       			 <label for="drop_down_porte">Porte</label>
      			  <select name="porte-pet" id="drop_down_porte">
            		<option value="MINI">Mini</option>
         			<option value="PEQUENO">Pequeno</option>
         			<option value="MEDIO">Médio</option>
         			<option value="GRANDE">Grande</option>
         			<option value="GIGANTE">Gigante</option>
       			 </select>
       			 
       			 <label for="drop_down_sexo">Sexo do Pet</label>
      			  <select name="sexo-pet" id="drop_down_sexo">
            		<option value="MACHO">Macho</option>
         			<option value="FEMEA">Fêmea</option>
       			 </select>
       			 
       			 
       			 <label for="drop_down_pelagem">Pelagem</label>
      			  <select name="pelagem-pet" id="drop_down_pelagem">
            		<option value="CURTO">Curto</option>
         			<option value="MEDIO">Medio</option>
         			<option value="LONGO">Longo</option>
       			 </select>
       			 
       			 <label for="fotos">Escolha várias fotos:</label>
    			 <input type="file" name="fotos" id="fotos" accept="image/*" multiple>
    			 
       		
        		<div class="container-botao">
					<button type="reset" class= "botao-secundario">Limpar</button>
        			<button type="submit" class="botao-primario">Salvar</button>		
        		</div>
	    	</form>
    
	</main>

</body>

</html>