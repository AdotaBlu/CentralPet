<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style><%@include file="/resources/css/estilo.css"%></style>
	<title>Perfil da ONG</title>
</head>
		<c:if test="${tutorSessao == null && ongSessao == null}">
		<%@ include file="../nav-bar/nav-usuario-deslogado.jsp" %>
		</c:if>
	
		<c:if test="${tutorSessao != null}">
		<%@ include file="../nav-bar/nav-tutor-logado.jsp" %>
		</c:if>
	
		<c:if test="${ongSessao != null}">
		<%@ include file="../nav-bar/nav-ong-logada.jsp" %>
		</c:if>
<body>
		
	<main>
		<c:if test="${ong != null}">
			<div class="container-perfil">
				<div class="foto-perfil-ong">
					<img id="foto-perfil-ong" alt="foto-de-perfil" src='<c:out value="${ong.urlFoto()}"></c:out>'>
				</div>
				<div class="container-info-perfil-ong">
					<div class="info-perfil-ong">
					<div class="nome-ong">
						<h2><c:out value='${ong.nome}'></c:out></h2>
					</div>
					<div class="endereco-ong">
						<p><c:out value='${ong.endereco.logradouro}'></c:out> <p>
						<p>, <c:out value='${ong.endereco.numero}'></c:out><p>
					</div>
					<div class="contato-ong">
						<p><c:out value='${contato.telefone}'></c:out> <p>
					</div>
					<div class="contato-tutor">
						<p><c:out value='${contato.email}'></c:out> <p>
					</div>
					</div>
					<div class="container-btn-ong">
						<c:if test="${ongSessao != null}">
						<a href="<%=request.getContextPath()%>/mostrar-tela-confirmar-exclusao"><button type="button" class="btn-perfil-ong">Deletar</button></a>
						
						<a href="<%=request.getContextPath()%>/editar-ong"><button type="button" class="btn-perfil-ong">Editar</button></a>
						</c:if>
					</div>
				</div>
			</div>
				<c:if test="${ongSessao != null}">
				<%@ include file="../ong-filtro-pets.jsp" %>
			</c:if>
				<c:if test="${pets != null}">
			<h2 id="ong-pets-cadastrados">Pets Cadastrados</h2>
			<div class="container-cards">
				<c:forEach var="pet" items="${pets}">
					<div class="pet-card">
						<div class="foto-pet">
							<img class ="foto-pet" src="<c:out value='${pet.fotoPrincipalPet()}'></c:out>" alt="foto-pet" width="220" height="170">
						</div>
						<div class="info-card">
							<div class="info-mid">
								<div class="pet-nome">
									<p id="nome-pet">
										<c:out value='${pet.nome}'></c:out>
									</p> 
								</div>
								<div class="pet-icone">
									<div class="pet-icone-sexo">
										<c:if test="${pet.sexoPet == 'MACHO'}">
											<img width="15px" height="15px" alt="ma" src="data:image/png;base64,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" >
										</c:if>
										<c:if test="${pet.sexoPet == 'FEMEA'}">
											<img width="13px" height="17px" alt="fem" src="data:image/png;base64,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">
										</c:if>
									</div>
								</div>
							</div>
								<div class="info-bottom">
									<div class="pet-info-box">
										<span class="label">Idade: </span>
										<c:if test="${pet.idade > 1}">
											<span class="value"><c:out value='${pet.idade}'></c:out> anos</span>
										</c:if>
										<c:if test="${pet.idade == 1}">
											<span class="value"><c:out value='${pet.idade}'></c:out> ano</span>
										</c:if>
									</div>
									<div class="pet-info-box">
										<span class="label">Porte: </span>
										<span class="value"><c:out value='${pet.portePet}'></c:out></span>
									</div>
									<div class="pet-info-box">
										<span class="label">Pelagem: </span>
										<span class="value"><c:out value='${pet.pelagemPet}'></c:out></span>
									</div>
									<div class="pet-info-box">
										<span class="label">Peso: </span>
										<span class="value"><c:out value='${pet.peso}'></c:out>kg</span>
									</div>
								</div>
								<form method="post" action="mostrar-perfil-pet" enctype="form-data">					
									<div class="btn-card">				
										<input type="hidden" id="id-pet" name="id-pet" value="<c:out value='${pet.id}' />">
										<input type="hidden" id="id-ong" name="id-ong" value="<c:out value='${pet.ong.id}' />">
										<button type="submit" class="btn-adotar-card">Perfil Pet</button>
									</div>
								</form>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:if>
		</c:if>
		
		<c:if test="${ong == null}">
			<h1>Nenhuma ONG encontrada</h1>
		</c:if>
		
	</main>

</body>
</html>