<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	
	<h1>Login</h1>
	
	<form method="post" action="confirmar-login">
			<label for="nome-usuario">Digite seu nome de usuario</label>
        	<input type="text" id="nome-usuario" name="nome-usuario">
        	
        	<label for="senha-usuario">Digite sua senha</label>
        	<input type="text" id="senha-usuario" name="senha-usuario">
        	
        	 <div class="container-botao">
				<button type="reset" class= "botao-secundario">Limpar</button>
        		<button type="submit" class="botao-primario">Salvar</button>		
       		 </div>
       		 
       		 <c:if test="${usuarioInvalido != null}">
       		 	<h1>Usuario ou senha invalidos</h1>
       		 </c:if>
		</form>
</body>
</html>