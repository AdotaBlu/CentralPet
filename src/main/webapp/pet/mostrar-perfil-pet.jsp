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
	<title>Perfil Pet</title>
</head>

<body>

	<c:if test="${tutor == null && ong == null}">
		<%@ include file="../nav-bar/nav-usuario-deslogado.jsp" %>
	</c:if>
	
	<c:if test="${tutor != null}">
		<%@ include file="../nav-bar/nav-tutor-logado.jsp" %>
	</c:if>
	
	<c:if test="${ong != null}">
		<%@ include file="../nav-bar/nav-ong-logada.jsp" %>
	</c:if>

	<main>
		<c:if test="${pet != null}">
		
			
			<div class="container-principal-pet">
				<div class="container-foto-pet">
					<img id="foto-principal-pet" alt="foto-pricipal-pet" src="${pet.fotoPrincipalPet()}">
				</div>
				<div class="container-info">
					<div class="container-nome-fav">
						<div class="nome-pet">
							<h1><c:out value="${pet.nome}"></c:out></h1>
							<img width="22px" height="19px" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAAC4CAYAAAAVMotFAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAABF9SURBVHgB7Z1fchPHFsa/mZEdqPsQswLECgIriP2Sin3rVmAF2CvArAB7BcAKYlYAqVsXp/KCWAGwgigriPKEsa2Ze05rZMuyNJJGM6dPz5xfFeGPTWym5+s+/XX31xEaTPYWW/TT1mUH3SxGl/8sSfB9OsS9W58L9OMhBllEP2IMNs7Rj55gAKMyqD26F5vYoufcTRPXNjfaI07w93CIf/jXUYo+/9y5dO3QR4OJ0BDO/4eH9NPDiH/E+IF+3c1/rAOL8HOW4gu9IH+mF/hCL8VnE2cxN9oiwX3q4fj3XaxBlFE7xOhnQ3yJhvhMIu5v/huf0QCCFSE3NPWiP2YZHtNvuZG3IEePhYkU70yUwMV/sR13qC2Abci2RZ/e4M/cDkmEj9FumCNmUCLkxkaMxzTSPYWs6BbRo97+JOQXYRW4zKey8jFVB7/Qv3sbStqCR8s0w0fqDE5CGiXVi5AbPL2DZ/RgD6FLePMYCfIbfmvSCMntQHPrh1EHLyBfeZShT+1wFELHqFaEPOrlDb6NQKGHezJM8TrkuYsr+2P8ElAneAtuhxg41ipGdSJsgvhm4EbHzh7eIBCa2g7ZJY43/kPtoQg1Imxoo0/jSiTNYmxJO/TIXX2++ZOOCsW7CFvS6NOoE2Mb20FLmepNhM5wuYsXtMRwiPbiXYwt7QRvQCI4SnZxDE94EWHe8L9i/cX0ZhDROleG55I98tdTdDcivMRondWgDjEBdnyMiqIitNGvGO6R4zO8rntpY3hKbRCw21knPkZFMRGe/4GH8RBvYaPfImorUd3OlgQvs8it8xnzER0VRUQ4/J0W2zO8grE0VZoGVoGUYkCd4aHEfL12EZIAX1rjl6ZPZePBxm75dS2uQJJL/GqjXzkkytPaROh63+/wwRp/fcq+CHkFcgSb+60HG2dfcVDXXL0WETrnDfgAm/9VBm9OjiM8WaY85Q5weJfcZ3M+K2OV57/y/xsVYwKslYXlqRlgtVKLYROjQkyAtdOlXvMDLzHM+uDlezwlAdrzr4/ukJ5/dlrt861MhCZAOWg0PGLDa/LPnDAjnMDmf3VTuRArKUdNgH7gecoww0Ec4xn9dh+GJJWVpmuL0ARotBVn1nwjIa7pmq5djm5mZgIY7YSX34Z3bk4LyrCWCN1CvK0DGu1mf55Rtiyly9F8E/ARDMNgt2y/7Ba3UiLM16I+IRwGVL+P4vGINMVfkx8kY+M+jehb9CDZWQwhxChkBu4HtQW1iZtLjduD24F/zngphtoisCprQEbNozJGzcoiDMGIGUffRRF6CTf2ig/GJYvdoY4mwg+eck2bhMtoLdsWrsO/RDcFHlN7/Ajl710Zo2ZlEZ6/xwk9jKfQR48a+l38FW/q2ON3cYptEuS+9hdBAQN6qd7RWtrHjTO8q7otWJTRBfajGL9AYTvQO/gq+RnPV/o7q3zy+Sm9hHAn4vVAwiNxvF7npMGq5M+BO6JtGGNq7QRnwR0jfc1n2vbIUjm9s8r7uLQItZWhGkJ6+JkkGY6UVgYicDtQqfhGshOcRmE79JMzmh8u2RktLUJFZWiPeppjn40+TRvFqKETnMaNjNCRXbRKWbqUCDmFmZwr327ogMyW4809vSf0WyLGHrmAB5qj5UmMR/Rir7V2VwVpgkfLZJsuJcLLU/wJj71LnWe56qChW/nWPuUviZI26HV2sbPokxbumGETAh7/IWy6JHvl1l98cZe+V3r4D2jk5nIk+EthuPznOU4oAmS4Dfh7ZuMO/tjmEnnRJy0cCX2OgvwSay4/l4F7ZN5fG+j2vj6VVE+0xMWXxXN56jrkok8oHAl9joLkuB2ELkDG9cg0kvNogoBwFcjZcnMa7dAIfuTx+Xf5sHXRJxSOhL5GQSfAXXdAtVEEEj3BUX8HnT2vZVwtkMN/GEfrn3ooQeFoOHck9DUKNlWADI8qF3wQNFM7uvBB1UdNFCDDlZWnEbFwNIwLPiBeQ7s5YEMFOEZrecoL7m6BueHXfXsrTaP5yQczy1Ef29PyBfgjtAgt61ltfPb0jp/kWw/FmLedbeZIKP3NEb22vQSM+zdneAKPyxhcfbTy2Z/hUHpaMK/DvTUS5oucf0IOb1dSacGTYTOgErTx5X8R+bvOO8HEjqlRyX9vek/prZGwI31vREYlWYsFyIwNG0DsOQxo/W+nzQJkeH7OWyEhyOXmbX3dEmEUuXNaIvAmYM33t0vCL4SQEEcCbMD6XxXka9E9CBHF7jzqDW6IkO+vg1xJ1I8DW8CuGwEhmgBnQM/8AHLz8ltb2W6IMEsEA2StDJ1JjUI0Ac6Bn3mW4jWkSAtEmEc3SNC3MnQ+E0KsrHc2ARbTOXdlqchoOF2SXomQzwxCqhTNLCpxEc40SCoR4sDtQjIBFsKOpeBouM1hYuPfXI+EkVheio2CS5K7po9QvjTtmwu6PJKj4XDzOhcnnviFTClqo+BKjM8m5lut+kv+tcH4DKCNgMsjORpOlqRXi/WXp/gbAouWtDD/wAyZ8rgthbSMFKXoTp1RdOHG1KA9ycSzpuFuOb7jtFA3VycrnAilMmSod/5tY9eucDZ0QwMSx2Jso2aoUnlAnWXflaPUs3YhQDS6wckwVJNm+A0S3MUP/JMTYSYUYpt8E/rHGcYabHyTMbIuh6MQKCfCKBopsmZ6Nk8xQiB/T3uom3hUgY5EmNVvyJDr9BGGEQhZhi+oGTJkJspRiSSwOJy4PMOIZDZ1d/k/MZ+pggCdM1uvMsLhIpJ5X2lJpBt3LkVEOLD5oBESd0dr2bW/sxf/wlYcJSKnim0UNILD3e5cMxsp7sdpJGDKAP/AMAIjE0g6GA5xL+btT6gZcn8ktgEZRqWkAoMHD4ILL4Sp5Aul+AuGERiRwJyQlwdFRGgYQZLJmIkmQsPwjJQIxXIdDSM0REQYx/gehhEYmdDpopi+UO11L7lM92AYgRFHuI+aYf3FEBDheKOqYYSExMGGmMyfOJZxgLowjMCQKEezGP04zWTyXnijKgwjEPIIUBFDMd44lxHhcFMsUtEw1kYq8oVPF8X56Yb654WxWLq3YawNmYkigWSsv/HJ+j5qJoOlrBnhIHElRJSfWXQiHKL+o/zE1vRtNIahEakrIciPcXuqx4v1Muf9UhsNDf3QCLUPAbJsFKExTlsTESHNC59OXoRhGBqRuij3Rjma579IrBduXXwneAeiYawIXzMAyOYujUbCkUMqMhrShPcZDEMpJIinEIBHwXHu0tUGbsFc0O7le5l/qGGsQn5d/DYESIfXers+RSGZCxrhyOaGhjaiDn6FFDHeXf8yZ2PXiVAqlrB7uYlDGIYSJOeCxCDXm+PGeUKyTMVu0CWn9Fl2avtJDf9wADYJ4QWEiHA9CjLx1EffQY6t1K5KMxSQjG6P7kKIOCoQoXBJ6u7AGP6OlzAMTwxP8YJEIWkU9qOfb14ReCveQurO7quvl+HQ3FLDB+d/4GEGNwqKMeuimVsi7JzjFaSJ8IofCAxDCDcPHMpPh0hwxzP+7CZuATETnRsyW/xAzKgxJGABbsDdS9+FLL1o9/aJpZlpazRXEy1Jc7pDejAmRKNOPAqQj/Mdz/rzaN5fuDx13+g25OmnCZ5s/mQ3ORnV4lOARL+ziwezPjA3d3SeagXgWv2DmTVGlbDnQAL8BF+hY9l8Aygq+Gs+R0MHfXNHya63zsBoCK5Dj3ACf8wdBZnCBO4L4AAeYfvY1hGNdeB1QM8CBE+vij5eKEK+MpjW8XyYNFe4dcTfyTm1Dd/GinAHLr0OOA1VcyeL/I3CcpThl394x2MtfU0/AXZmWbyGMUn+zvIa4Db8MqB39tGid3bhhTD5uuFz+MeWMIyFsAOaDxrb8Eya4XiZQWPhSDiGS0ISo4agJu4UDjp74hsKDOWwA5rvgunCM1GGz8keHi3zuUtfjZZ8dSZNH/7Zoq7jrZtwG0YOO6C8tAUd954M4qjYjJlkaRFyWZp5dksncc6pCdHADQdUh3lHZuIq3sXS5eiYi1McRVD08kd4x6P0ODTHaBfOAc30pDTwasLG3mrfz8oiZHwv4s/AnNOWocgBnaSfnJEbuuKAUOq6bPpCXO/2oQdzTluEJgd0gtFAUKIiKyVC/kIX9AWhT4ifaIJuUfsNJt8DqsWAGTPgXTFlK7FSImR4N02+HUfTXMw5p+fvLcmtiXAHq8gBvSIFnq9z6qe0CBn3hTM9jukYsodfmnPaLMiAecYdLLQ4oDl82mhzd729qaWMmWk4s5HULBecujwnNH99bs5p2GhzQMewADd219+bWokIGa1C5J0LvHBqzml45A4on6LZhzKqEiBTmQgZZ4pETojaTjzYEkZgsAO6meEtx2JCGWlGc8C96gLRKhUh4zlCoAiLzQgExe8Q7xp7MhlhXwVrGTOzYNdU4fIFw7EZn8w51Q3fjOQ1hmI+3InvVC1ApnIRMixE3jkACN70tCTmnOqFHdCo40ZAVdMZdyKCBpa6qqjKy9FpLt7jVaTwYlD6nl4lP6s4J2lgtAnb9yn4mQjsTa5dhIy6Td855pz6R7UDWmIzdhlERMjwXIxLQejDnFNPaHZAq1yCWISYCBlNJ5+nMOdUGM0OqNuGtiuX0FaLMTMPfsnNOTW0O6CSAmRERciMlzB4PgZlmHNaPxxDodEBRT4t8VENiZaj05hz2i7UOqC0lMZnZH3tMfYqQkarcwrPDdM0Lk/ddsZ9KEPKAS3CuwgZc06bCy9BpN/hQ9sd0CJUiJDR7JyaEMthDuhyiBsz89DsnFpsxuoojaFgvDigRagRIaPYObXA4RVQFsQ7iTcHtAhVImRYiPE37FC58AbKsMDhxagL4s1xm7DPFl/O4gM1c8JZqHVOLXB4JlpjKLhDp/JzH0pRLULGnFP9KA3idWhxQItQL0LGYjP0otgBrTyGoi6CECGj2e5u61VtipeVaomhqAt1xsw8FMdmtNI5Ve6APgpFgEwwImSuYjMifaNOm5xT1Q5ogNODYMrRaRTvOW104LBmB3TjDIchPvdgRchYbIYczgG9S+aYjivTbxCCA1pE0CJkzDmtnzYF8fogeBEyFjhcH20L4vVBUMbMPCxwuB40x1CE5oAW0QgRMpqd0xBjM7QH8TZpvt2IcnQai81YjzYH8fqgkSJkzDldHQvi9UNjRcjkdybyS2XO6QLMAfVHo0XIWODwYiyGwi+NMWbmYYHDxVgQr38aL0LGAodno9UBhdIYirpofDk6jTmnIyyIVw+tEyHT9sBhC+LVRStFyLQxNsOCeHXSWhEybXJOzQHVS6tFyCiPzTjs7K0f/Zh3NioNGLsXsiXuaBHKA4dP1nVOJ2IozAFVSutHwknUOqfkYia7OMaKmAMaBibCKZoSOGxBvOFgIpxByM6pBfGGh4lwDjQibtPD4Zc5mM3fqoN4gYM2O6BFmAgLCClwWHMQr9sDagbMXFrvjhYRSuCw9iBeE2AxNhIugea4P6IHhfO/JsY+1oWJcAUU7zlVRchBvD4wEa6ICbEYc0BXx0RYAsWBw15pegxFXZgIS6J5OcADjQni9YGJcA1MiA67sXhNbIliDTQHDkvQxCBeH9hIWBFtM2zMAa0OE2GFtEWI5oBWi4mwYhQHDleCOaDVYyKsAcX7ONfh1n5VoxpMhDXRMOfUYihqxERYI5rvd1gBW4KoGROhAFpjM5bAYigEMBEKEZpz2tYgXh/YYr0QbOmzs4gAcEsQJkAxbCQURrlz2vogXh+YCD2g1Dk1B9QTJkJPKHNOzQH1iInQMwqcU3NAPWMiVIAv59QcUB2YO6oAH86pOaB6sJFQEVKBwxbEqwsToTJqdk4tiFchVo4qo8ar2iyIVykmQoWwEONv2KkqNsNiKHRj5ahy1nVOLYZCPybCAMhP67MQuyv8tQE5rsd2Cl4/JsKAYDEmGZ4t2GXTp+WHN50zvLLRLwxMhAHiHNQMD6MY99Mh7sUJ/h5m+Idc1Z7N+8Lj/5sv3bTzYDE3AAAAAElFTkSuQmCC" alt="fa">
							
						</div>
						<div class="ong-pet">
							<img width=15px height=23px  src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAANAAAAFDCAYAAABLIYAtAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAfWSURBVHgB7d1dTtz2Asbhvync9SyG7IAl5Pa00jldQZsVlO4g3QGRIL1lCekGklkCS+CyUgKuPXwkaYHM8Nrjr+eRkqAoUuZifjLjF9vV4Xc/1AV4lr0CPJuAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCAICAgCAgIAgKCgIAgICAICAgCAoKAgCAgIAgICAICgoCARq26bH67LIyWgMbrot7bP6oPDg7brwujJKBxumjCOVp9PFmt/jpZf11ENEoCGpuqrNbxNOHc/dV9RHVZFUZFQOPypv7+63jurCO6PjiqSn1eGI3q8Lsf6sLgqqr+/f2nt79s8m9f7P94XNf1r4XBOQKNQBPPb5vG03r/6fS4qqrfCoMT0MCqvfKqiee4bKmNqK7Lq8KgBDSY6rKuqqP3H89el2daXZ+9rkv1stiKBiOgYaw3ntWn03cltLo6PbcVDUdAu3e/8ZSO2IqGI6Bdajee/xwcPnSaOmUrGoaAdudm47k86e3zyt1W1P5fhZ2wA+3ANhtPV2xFu+EI1LNtN56u2Ip2Q0A9qvbqn56z8XTFVtQ/AfXibuN5e1IGtt6KmtdSbEW9EFD3mrNh+4ddbDxdaV+LragfAurWxT8vRRgLW1E/BNSVHjeertiKuiegbvS+8XSljejD9Vn77ZytqAMCCrWnqT9cnf1/CvF8qX3NTnPnBBS43XiOy0TZinICeqahN56u2IoyAtraeDaerqy3or26/VxkK9qSgLYzuo2nK6uPb1e2ou0JaHOj3Xi6YivanoA2MYGNpyvriK6aI5GtaCMuZ/i2N+0p37JAzXvjpPnjf4VHOQI94W7jKQtlK/o2AT1i6htPV2xFTxPQA+ay8XRlvRWV+qfCvwjoK83Gs3dwOKeNpyurq7cnt1vRReGegD672Xg6vN3U3NxuRU5zf0FAN2a/8XTFVvQ1AZX6z6VsPF2xFX229B1osRtPV17s//i6ruufy0It9gi09I2nK80Zul+WfJp7kQHZeLq15K1oYQFVlzaefix1K1pQQO3Gsz+r63jGZolb0VICsvHsyNK2ovkH9MBj4+nXkraimQfUbDzfi2cI91tRKe/KjM15B7LxjMSct6JZHoFsPOMy561odgE997Hx9GuuW9GMArrdeILHxtOvL7ai2dw+ayYB2Xim4nYrms0ZujkEZOOZmDltRdMOyMYzWXPZiiYckI1n6u62oqrU52WiJrkDDfHYePo11a1ockegoR4bT7+muhVNKiAbz7xNcSuaSEA2nqW42Yqql2UiW9EUArqw8SzL6ur0fCpb0dgDurndlI1ncaayFY03IBvP4t1vRSO+fdYoA6pKdW7jobWO6PrgaKxb0eh2IBsPjxnjVjSqI5CNh6eMcSsaTUA2HjaxPs1dl1dlJEYQUHVZl+uXNh42tbo+ez2WrWjogNYbz+rqj8n+MCHDGMtWNGRANh4iY9iKhgnIxkNHht6KhgjojY2HLg25Fe10B7Lx0LdmK2rO0tW/lh3Z2RHIxsMu7PqSiJ0EZONhl3a5FfUcULPxVNWRjYdd29VW1GdANxvPp9N3BQaw3ooODnp9XlFfAdl4GIW+b5/VfUDtxuOx8YxIn1tR1wHdbDyXJ7O59zHzcLcVNV++KR3qbAey8TAVXW5FnRyBbDxMSZdbURyQx8YzRV1tRUFAdxuP200xTeutqHkPl2Arem5ANh5moX0PJ1vRcwKy8TAryVa0XUA2HmbquVvRNgHZeJi1NqIP12ftt3Mbb0UbBXT32HjxsATte33T09zfDOh24zkusCCbbkVPBmTjYck22YoeCcjGA631VrRXt5+LHvz48lBAN4+Nt/HA2u3tsx7civ4Z0IXbTcG/PbYVfQ7IxgNPWkd01RyJvtyK2ssZml8nBdhY28z6UqAX+/89LsDW2uuK/gaf1K3V0idAhQAAAABJRU5ErkJggg==" />
							<p id="nome-ong-pet"><c:out value="${pet.ong.nome}"></c:out></p>
						</div>
					</div>
					<div class="container-dados-pet">
						<div class="pet-info">
							<span class="label">Sexo: </span>
							<span class="value"><c:out value='${pet.sexoPet}'></c:out></span>
						</div>
						<div class="pet-info">
							<span class="label-pet">Idade: </span>
							<c:choose>
								<c:when test="${pet.idadeFormatada() > 1.0}">
									<span class="value-pet"><fmt:formatNumber value="${pet.idadeFormatada()}"/> anos</span>
								</c:when>
								<c:when test="${pet.idadeFormatada() == 1.0}">
									<span class="value-pet"><fmt:formatNumber value="${pet.idadeFormatada()}"/> ano</span>
								</c:when>
								<c:when test="${pet.idadeFormatada() < 1.0 and fn:substringAfter(pet.idadeFormatada(), '.') >= '2'}">
									<span class="value-pet"><fmt:formatNumber value="${pet.idadeFormatada() * 10}"/> meses</span>
								</c:when>
								<c:when test="${fn:substringAfter(pet.idadeFormatada(), '.') == '1'}">
									<span class="value-pet"><fmt:formatNumber value="${pet.idadeFormatada() * 10}"/> mês</span>
								</c:when>
							</c:choose>
						</div>
						<div class="pet-info">
							<span class="label">Peso: </span>
							<span class="value"><c:out value='${pet.peso}'></c:out></span>
						</div>
						<div class="pet-info">
							<span class="label">Pelagem: </span>
							<span class="value"><c:out value='${pet.pelagemPet}'></c:out></span>
						</div>
						<div class="pet-info">
							<span class="label">Espécie: </span>
							<span class="value"><c:out value='${pet.especiePet}'></c:out></span>
						</div>
						<div class="pet-info">
							<span class="label">Vacinado: </span>
							<span class="value"><c:out value='${meme}'></c:out></span>
						</div>
					</div>
				</div>
			</div>
		
		<div>
			<c:if test="${ongSessao != null}">
				<form method="post" action="editar-pet">
					<input type="hidden" id="id-pet" name="id-pet" value="<c:out value='${pet.id}' />">
					<input type="hidden" id="id-ong" name="id-ong" value="<c:out value='${ongSessao.id}' />">
					<button type="submit" class="btn-adotar-card">Editar Pet</button>
				</form>
				<form method="post" action="excluir-pet">
					<input type="hidden" id="id-pet" name="id-pet" value="<c:out value='${pet.id}' />">
					<button type="submit" class="btn-adotar-card">Deletar Pet</button>
				</form>
			</c:if>
		</div>
		<div>
			<c:if test="${tutor != null }">
				<form method = "post" action = "favoritar-pet">
					<input type = "hidden" id = "id-pet" name = "id-pet" value = "<c:out value = '${pet.id}'/>">
					<button type="submit">Favoritar Pet</button>
				</form>
				<form method = "post" action = "excluir-pet-favoritado">
					<input type = "hidden" id = "id-pet" name = "id-pet" value = "<c:out value = '${pet.id}'/>">
					<button type="submit">Excluir Pet Favoritado</button>
				</form>
			</c:if>
		</div>
		<div>
			<c:if test="${tutor != null }">
				<form method = "post" action = "nova-adocao">
					<input type = "hidden" id = "id-pet" name = "id-pet" value = "<c:out value = '${pet.id}'/>">
					<button type="submit">Adotar Pet</button>
				</form>
			</c:if>
		</div>
		</c:if>
		
		<c:if test="${pet == null}">
			<h1>Nenhum pet encontrado :p</h1>
		</c:if>
		
		
	</main>
	
</body>
</html>
