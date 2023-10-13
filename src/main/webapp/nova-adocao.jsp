<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Adocao</title>
</head>
<body>

	<main>
		<c:if test="${ong != null}"> 
				<h1>Nome da ong: <c:out value='${ong.nome}' /></h1>
		</c:if>
		
		<c:if test="${tutor != null}"> 
				<h1>Nome do tutor: <c:out value='${tutor.nome}' /></h1>
		</c:if>
		
		<c:if test="${termo != null}"> 
				<h1>Termo: <c:out value='${termo.termo}' /></h1>
		</c:if>
		
		<c:if test="${pet != null}"> 
				<h1>Pet: <c:out value='${pet.nome}' /></h1>
				<form method="post" action="cadastro-adocao" >
					<h1> Adocao requerida</h1>
					 <div class="container-botao">
        			<button type="submit" class="botao-primario">Salvar Adoção</button>		
       				</div>
				</form>
		</c:if>
		
		
		<c:if test="${ong == null}"> 
			<h1>ong nula</h1>
		</c:if>
		
		<c:if test="${tutor == null}"> 
			<h1>tutor nulo</h1>
		</c:if>
		
		<c:if test="${termo == null}"> 
			<h1>termo nulo</h1>
		</c:if>
		
		<c:if test="${pet == null}"> 
			<h1>pet nulo</h1>
		</c:if>
	</main>

</body>
</html>