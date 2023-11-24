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
    <title>Editar Pet</title>

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
				

			
			<c:if test="${ongSessao == null}"> 
				<h1> ong = null </h1>
			</c:if>
			<c:if test="${fotos != null}">
			<div class="container-fotos-pet">
				<c:forEach var="foto" items="${fotos}">
					<div class="foto-pet-editar">
						<img  width=200px height=200px src=<c:out value='${foto.urlFoto()}' />>
					</div>
				</c:forEach>
			</div>
			</c:if>
   			<form method="post"  action="atualizar-pet" enctype="multipart/form-data">
  
				<h1>Informações do Pet</h1> 
		   
        		<label for="nome">Nome do Pet</label>
        		<input type="text" id="nome" name="nome" value="<c:out value='${pet.nome}' />">
       
        		<label for="vacinas">Vacinas do Pet</label>
        		<input type="text" id="vacinas" name="vacinas" value="<c:out value='${pet.vacinas}' />">
  
        		<label for="descricao">Descrição do Pet</label>
        		<input type="text" id="descricao" name="descricao" value="<c:out value='${pet.descricao}' />">
        
        		<label for="dataNascimento">Data de Nascimento do Pet</label>
        		<input type="date" id="dataNascimentoPet" name="data-nascimento-pet" value="<c:out value='${pet.dataNascimento}' />">
        		
        		<label for="peso">Peso do Pet</label>
        		<input type="text" id="peso" name="peso" value="<c:out value='${pet.peso}' />">
  				
        		<label for="castrado">Castrado</label>
				<div class="value-radio">
					<input type="radio" id="input-radio" name="castrado" value="SIM">
  					<label for="sim">Sim</label>
 					<input type="radio" id="input-radio" name="castrado" value="NAO">
  					<label for="nao">Não</label>
				</div>
        		
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
         			<option value="MEDIO">Médio</option>
         			<option value="LONGO">Longo</option>
       			 </select>			
    			 
    			 <input type="hidden" id="id-pet" name="id-pet" value="<c:out value='${pet.id}' />">
       			
        		<div class="container-botao">
					<button type="reset" class= "botao-secundario">Limpar</button>
        			<button type="submit" class="botao-primario">Salvar</button>		
        		</div>
	    	</form>
    
	</main>

</body>

</html>