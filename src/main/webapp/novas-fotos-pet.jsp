<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Cadastro das fotos do pet</title>
</head>

<body>
	<main>
		<c:if test="${pet != null}">
			<h1><c:out value='${pet.nome}'/></h1>
		</c:if>
		
		<c:if test="${pet == null}"> 
			<h1> pet = null </h1>
		</c:if>
	
		<form method="post" action="cadastrar-fotos-pet" enctype="multipart/form-data">
			
			 	 <label for="fotos">Escolha várias fotos:</label>
    			 <input type="file" name="fotos" id="fotos" accept="image/*" multiple formenctype="multipart/form-data">
    			 
    			 <div class="container-botao">
					<button type="reset" class= "botao-secundario">Limpar</button>
        			<button type="submit" class="botao-primario" formenctype="multipart/form-data" >Salvar</button>		
        		 </div>
		</form>
	</main>		
</body>
</html>