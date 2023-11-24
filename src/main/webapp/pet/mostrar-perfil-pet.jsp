<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"
	rel="stylesheet">

<style><%@include file="/resources/css/estilo.css"%></style>
<title>Perfil Pet</title>
</head>

<body>


	<c:if test="${tutorSessao == null && ongSessao == null}">
		<%@ include file="../nav-bar/nav-usuario-deslogado.jsp"%>
	</c:if>

	<c:if test="${tutorSessao != null}">
		<%@ include file="../nav-bar/nav-tutor-logado.jsp"%>
	</c:if>

	<c:if test="${ongSessao != null}">
		<%@ include file="../nav-bar/nav-ong-logada.jsp"%>

	</c:if>

	<main>
		<c:if test="${pet != null}">

			<div class="container-principal-pet">
				<div class="container-foto-pet">
					<img id="foto-principal-pet" alt="foto-pricipal-pet"
						src="${pet.fotoPrincipalPet()}">

				</div>
				<div class="container-info">
					<div class="container-nome-fav">
						<div class="nome-pet">

							<h1>
								<c:out value="${pet.nome}"></c:out>
							</h1>
							<img width="22px" height="19px"
								src="data:image/png;base64,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"
								alt="fa">

						</div>
						<div class="ong-pet">
							<img width=15px height=23px
								src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAANAAAAFDCAYAAABLIYAtAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAfWSURBVHgB7d1dTtz2Asbhvync9SyG7IAl5Pa00jldQZsVlO4g3QGRIL1lCekGklkCS+CyUgKuPXwkaYHM8Nrjr+eRkqAoUuZifjLjF9vV4Xc/1AV4lr0CPJuAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCARq26bH67LIyWgMbrot7bP6oPDg7brwujJKBxumjCOVp9PFmt/jpZf11ENEoCGpuqrNbxNOHc/dV9RHVZFUZFQOPypv7+63jurCO6PjiqSn1eGI3q8Lsf6sLgqqr+/f2nt79s8m9f7P94XNf1r4XBOQKNQBPPb5vG03r/6fS4qqrfCoMT0MCqvfKqiee4bKmNqK7Lq8KgBDSY6rKuqqP3H89el2daXZ+9rkv1stiKBiOgYaw3ntWn03cltLo6PbcVDUdAu3e/8ZSO2IqGI6Bdajee/xwcPnSaOmUrGoaAdudm47k86e3zyt1W1P5fhZ2wA+3ANhtPV2xFu+EI1LNtN56u2Ip2Q0A9qvbqn56z8XTFVtQ/AfXibuN5e1IGtt6KmtdSbEW9EFD3mrNh+4ddbDxdaV+LragfAurWxT8vRRgLW1E/BNSVHjeertiKuiegbvS+8XSljejD9Vn77ZytqAMCCrWnqT9cnf1/CvF8qX3NTnPnBBS43XiOy0TZinICeqahN56u2IoyAtraeDaerqy3or26/VxkK9qSgLYzuo2nK6uPb1e2ou0JaHOj3Xi6YivanoA2MYGNpyvriK6aI5GtaCMuZ/i2N+0p37JAzXvjpPnjf4VHOQI94W7jKQtlK/o2AT1i6htPV2xFTxPQA+ay8XRlvRWV+qfCvwjoK83Gs3dwOKeNpyurq7cnt1vRReGegD672Xg6vN3U3NxuRU5zf0FAN2a/8XTFVvQ1AZX6z6VsPF2xFX229B1osRtPV17s//i6ruufy0It9gi09I2nK80Zul+WfJp7kQHZeLq15K1oYQFVlzaefix1K1pQQO3Gsz+r63jGZolb0VICsvHsyNK2ovkH9MBj4+nXkraimQfUbDzfi2cI91tRKe/KjM15B7LxjMSct6JZHoFsPOMy561odgE997Hx9GuuW9GMArrdeILHxtOvL7ai2dw+ayYB2Xim4nYrms0ZujkEZOOZmDltRdMOyMYzWXPZiiYckI1n6u62oqrU52WiJrkDDfHYePo11a1ockegoR4bT7+muhVNKiAbz7xNcSuaSEA2nqW42Yqql2UiW9EUArqw8SzL6ur0fCpb0dgDurndlI1ncaayFY03IBvP4t1vRSO+fdYoA6pKdW7jobWO6PrgaKxb0eh2IBsPjxnjVjSqI5CNh6eMcSsaTUA2HjaxPs1dl1dlJEYQUHVZl+uXNh42tbo+ez2WrWjogNYbz+rqj8n+MCHDGMtWNGRANh4iY9iKhgnIxkNHht6KhgjojY2HLg25Fe10B7Lx0LdmK2rO0tW/lh3Z2RHIxsMu7PqSiJ0EZONhl3a5FfUcULPxVNWRjYdd29VW1GdANxvPp9N3BQaw3ooODnp9XlFfAdl4GIW+b5/VfUDtxuOx8YxIn1tR1wHdbDyXJ7O59zHzcLcVNV++KR3qbAey8TAVXW5FnRyBbDxMSZdbURyQx8YzRV1tRUFAdxuP200xTeutqHkPl2Arem5ANh5moX0PJ1vRcwKy8TAryVa0XUA2HmbquVvRNgHZeJi1NqIP12ftt3Mbb0UbBXT32HjxsATte33T09zfDOh24zkusCCbbkVPBmTjYck22YoeCcjGA631VrRXt5+LHvz48lBAN4+Nt/HA2u3tsx7civ4Z0IXbTcG/PbYVfQ7IxgNPWkd01RyJvtyK2ssZml8nBdhY28z6UqAX+/89LsDW2uuK/gaf1K3V0idAhQAAAABJRU5ErkJggg==" />
							<p id="nome-ong-pet">
								ONG:
								<c:out value="${pet.ong.nome}"></c:out>
							</p>
						</div>
					</div>
					<div class="container-dados-pet">
						<div class="pet-info">
							<span class="label-pet">Sexo: </span> <span class="value-pet"><c:out
									value="${fn:replace(pet.sexoPet, 'FEMEA', 'fêmea')}" /></span>
						</div>
						<div class="pet-info">
							<span class="label-pet">Idade: </span>
							<c:choose>
								<c:when test="${pet.idadeFormatada() > 1.0}">
									<span class="value-pet"><fmt:formatNumber
											value="${pet.idadeFormatada()}" /> anos</span>
								</c:when>
								<c:when test="${pet.idadeFormatada() == 1.0}">
									<span class="value-pet"><fmt:formatNumber
											value="${pet.idadeFormatada()}" /> ano</span>
								</c:when>
								<c:when
									test="${pet.idadeFormatada() < 1.0 and fn:substringAfter(pet.idadeFormatada(), '.') >= '2'}">
									<span class="value-pet"><fmt:formatNumber
											value="${pet.idadeFormatada() * 10}" /> meses</span>
								</c:when>
								<c:when
									test="${fn:substringAfter(pet.idadeFormatada(), '.') == '1'}">
									<span class="value-pet"><fmt:formatNumber
											value="${pet.idadeFormatada() * 10}" /> mês</span>
								</c:when>
							</c:choose>
						</div>
						<div class="pet-info">
							<span class="label-pet">Peso: </span> <span class="value-pet"><c:out
									value='${pet.peso}'></c:out>kg</span>
						</div>
						<div class="pet-info">
							<span class="label-pet">Pelagem: </span> <span class="value-pet"><c:out
									value='${pet.pelagemPet}'></c:out></span>
						</div>
						<div class="pet-info">
							<span class="label-pet">Espécie: </span> <span class="value-pet"><c:out
									value='${pet.especiePet}'></c:out></span>
						</div>
						<div class="pet-info">
							<span class="label-pet">Castrado: </span> <span class="value-pet"><c:out
									value="${fn:replace(pet.castrado, 'NAO', 'não')}" /></span>
						</div>
					</div>
					<div class="container-btn-perfil-pet">
						<c:if test="${ongSessao != null}">
							<form method="post" action="editar-pet">
								<input type="hidden" id="id-pet" name="id-pet"
									value="<c:out value='${pet.id}' />"> <input
									type="hidden" id="id-ong" name="id-ong"
									value="<c:out value='${ongSessao.id}' />">
								<button type="submit" class="btn-perfil-pet">Editar</button>
							</form>
							<form method="post" action="excluir-pet">
								<input type="hidden" id="id-pet" name="id-pet"
									value="<c:out value='${pet.id}' />">
								<button type="submit" class="btn-perfil-pet">Deletar</button>
							</form>
						</c:if>
					</div>
					<div class="container-btn-perfil-pet">
						<c:if test="${tutorSessao != null }">
							<form method="post" action="favoritar-pet">
								<input type="hidden" id="id-pet" name="id-pet"
									value="<c:out value = '${pet.id}'/>">
								<button type="submit" class="btn-perfil-pet">Favoritar</button>
							</form>
							<form method="post" action="excluir-pet-favoritado">
								<input type="hidden" id="id-pet" name="id-pet"
									value="<c:out value = '${pet.id}'/>">
								<button type="submit" class="btn-perfil-pet">Desfavoritar</button>
							</form>
							<form method="post" action="tela-adocao-pet">
								<input type="hidden" id="id-pet" name="id-ong"
									value="<c:out value = '${ong.id}'/>"> <input
									type="hidden" id="id-pet" name="id-pet"
									value="<c:out value = '${pet.id}'/>">
								<button type="submit" class="btn-perfil-pet">Adotar</button>
							</form>
						</c:if>
					</div>
				</div>
			</div>
			<div class="barra-nav-perfil-pet">
				<div class="nav-bar-pet-items">
					<img class="nav-bar-pet-icone" width=20px height=16px
						src="data:image/png;base64,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">
					<a class="nav-bar-pet-link">Consumo Mensal Estimado</a>
				</div>
				<div class="nav-bar-pet-items">
					<img class="nav-bar-pet-icone" width=18px height=20px
						src="data:image/png;base64,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">
					<a class="nav-bar-pet-link">Vacinas</a>
				</div>
				<div class="nav-bar-pet-items">
					<img class="nav-bar-pet-icone" width=18pc height=20px
						src="data:image/png;base64,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">
					<a class="nav-bar-pet-link">Observações</a>
				</div>
				<div class="nav-bar-pet-items">
					<img class="nav-bar-pet-icone" width=17px height=17px
						src="data:image/png;base64,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">
					<a class="nav-bar-pet-link">Fotos</a>
				</div>
			</div>
		</c:if>

		<c:if test="${pet == null}">
			<h1>Nenhum pet encontrado :p</h1>
		</c:if>


	</main>

</body>
</html>
