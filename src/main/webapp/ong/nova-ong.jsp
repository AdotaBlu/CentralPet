<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script><%@include file="/resources/javaScript/JavaScript.js"%></script>


<title>Cadastro ONG</title>
</head>

<c:if test="${tutorSessao == null && ongSessao == null}">
	<%@ include file="../nav-bar/nav-usuario-deslogado.jsp"%>
</c:if>
	
<body>

	<main>
		<form method="post" action="cadastrar-ong" enctype="multipart/form-data">
		<div class="container-endereco">
			<input type="hidden" id="id-endereco" name="id-endereco" value="<c:out value='${endereco.id}' />">
			<div class="container-cep-numero">
				<div class="input-endereco">
					<label for="cep">CEP</label> 
					<input type="text" id="cep" name="cep">
				</div>
				<div class="input-endereco">
					<label for="numero">Número</label>
					<input type="number" id="numero" name="numero">
				</div>
			</div>
			<div class="input-endereco">
				<label for="logradouro">Logradouro</label> 
				<input type="text" id="logradouro" name="logradouro"> 
			</div>
			<div class="select-endereco">
				<%@include file="../opcao-bairro.jsp"%>
			</div>
			<div class="input-endereco">
				<label for="pontoReferencia">Ponto de Referência</label> 
				<input type="text" id="pontoReferencia" name="ponto-referencia">
			</div>
		</div>
		<div class="container-cadastro">

			<div class="input-cadastro">
				<label for="nome">Nome</label> 
				<input type="text" id="nome"name="nome">
			</div>
			<div class="input-cadastro">
				<label for="cpf">CPF</label> 
				<input type="text" id="cpf" name="cpf">
			</div>
			<div class="container-data-genero">	
				<div class="input-cadastro">
					<label for="dataNascimento">Data de Nascimento</label> 
					<input type="date" id="dataNascimento" name="data-nascimento" />
				</div>
				<div class="select-cadastro">
					<label for="drop_down_genero">Gênero</label> 
					<select name="genero-tutor" id="drop_down_genero">
						<option value="MASCULINO">Masculino</option>
						<option value="FEMININO">Feminino</option>
						<option value="OUTROS">Outros</option>
					</select>
				</div>
			</div>
			<div class="input-cadastro">
				<label for="telefone">Telefone</label> 
				<input type="tel" id="telefone" name="telefone">
			</div>
			<div class="input-cadastro">
				<label for="email">E-mail</label> 
				<input type="email" id="email"name="email">
			</div>
			<div class="container-senha-cadastro">
				<div class="input-cadastro">
					<label for="senha-um">Senha</label> 
					<input type="password" id="senha-um" name="senha" oninput="confirmarSenha()">
				</div>
				<div class="input-cadastro">
					<label for="senha-dois">Confirmar Senha</label> 
					<input type="password" id="senha-dois" name="confirmar-senha" oninput="confirmarSenha()">
				</div>
			</div>
			<div class="input-foto-cadastro">
				<p class="label-adicionar-foto">Adicionar foto</p>
				<label for="fotoPerfil" class="input-adicionar-foto">
					<img alt="icone-adicionar-foto" id="icone-adicionar-foto" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAA+gAAAPoCAYAAABNo9TkAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAADDvSURBVHgB7d0NjN93fdjxz//hznZsxyZPxKHY1bYYWEcCuFWpUAKapiVSDaLRBqEkUjcRQwuVgOFIq2kRNE5V2AxTTdckdF1nh3hMSkfstE6rVokNtFvjgM1DwBTGmcQ2sQl2zg/E9t1/v+/PNgmU2Hfne/jc7/96Rf/cOVCV+EH3f9/n8/t+W1F5Vfzaz7Y6J/8kovWqiN7iAAAAAKZcK3r/e3Rk8H1fiv/+ndbpOD/1xdvW/Mrit73nhli4eH4AAAAAU2v40NHYsmF7rLt946HeyMCrO1d1/vmfvP9jt7zq1z7wxpgzdzAAAACAqVca/JW/+M/Kp3Mf+9xXX9V6deftvb/Zd5fJOQAAAMyA4cPH4l9euepQu/xAnAMAAMDMWLjoovJhcTsAAACAGSfQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AQAAwMwT6AAAAJCAQAcAAIAEBDoAAAAkINABAAAgAYEOAAAACQh0AAAASECgAwAAQAICHQAAABIQ6AAAAJCAQAcAAIAEBDoAAAAkINABAAAgAYEOAAAACQh0AAAASECgAwAAQAICHQAAABIQ6AAAAJCAQAcAAIAEBDoAAAAkINABAAAgAYEOAAAACQh0AAAASECgAwAAQAICHQAAABIQ6AAAAJCAQAcAAIAEBDoAAAAkINABAAAgAYEOAAAACQh0AAAASECgAwAAQAICHQAAABIQ6AAAAJCAQAcAAIAEBDoAAAAkINABAAAgAYEOAAAACQh0AAAASECgAwAAQAICHQAAABIQ6AAAAJCAQAcAAIAEBDoAAAAkINABAAAgAYEOAAAACQh0AAAASECgAwAAQAICHQAAABIQ6AAAAJCAQAcAAIAEBDoAAAAkINABAAAgAYEOAAAACQh0AAAASECgAwAAQAICHQAAABIQ6AAAAJCAQAcAAIAEBDoAAAAkINABAAAgAYEOAAAACQh0AAAASECgAwAAQAICHQAAABIQ6AAAAJCAQAcAAIAEBDoAAAAkINABAAAgAYEOAAAACQh0AAAASECgAwAAQAICHQAAABIQ6AAAAJCAQAcAAIAEBDoAAAAkINABAAAgAYEOAAAACQh0AAAASECgAwAAQAICHQAAABIQ6AAAAJCAQAcAAIAEBDoAAAAkINABAAAgAYEOAAAACQh0AAAASECgAwAAQAICHQAAABIQ6AAAAJCAQAcAAIAEBDoAAAAkINABAAAgAYEOAAAACQh0AAAASECgAwAAQAICHQAAABIQ6AAAAJCAQAcAAIAEBDoAAAAkINABAAAgAYEOAAAACQh0AAAASECgAwAAQAICHQAAABIQ6AAAAJCAQAcAAIAEBDoAAAAkINABAAAgAYEOAAAACQh0AAAASECgAwAAQAICHQAAABIQ6AAAAJCAQAcAAIAEBDoAAAAkINABAAAgAYEOAAAACQh0AAAASECgAwAAQAICHQAAABIQ6AAAAJCAQAcAAIAEBDoAAAAkINABAAAgAYEOAAAACQh0AAAASECgAwAAQAICHQAAABIQ6AAAAJCAQAcAAIAEBDoAAAAkINABAAAgAYEOAAAACQh0AAAASECgAwAAQAICHQAAABIQ6AAAAJCAQAcAAIAEBDoAAAAkINABAAAgAYEOAAAACQh0AAAASECgAwAAQAICHQAAABIQ6AAAAJCAQAcAAIAEBDoAAAAk0A0AYFbYO3Qwjhw6Wn08EEcOH4vh8jp07B/99xYuvigWLrooFlSvhYvnx5Jll8dVyy4LACA3gQ4AyezeORS7dw3FN6rX/irKy8d91cdWqxut+q/y5fv0Elz5Zz+pF6PV36pX9bFXv0ai1ztVhfplVahfHldfszReds2yWF5e1y4LACAHgQ4AM2zHtsfjse2P1x9LmB85fKLK7znRbg9WBd6pPh+MuQNL40I9/eSJ+P6TT8euz++P0dFtVbifitHeyVhx/SviNde9ov5YXgDAzGi9uvP23t8f3xgAwPQYPnS0CvE9sWXD9nhky6Nx9PDJahI+twryKspjbvX59B0R0+uVCfvJGBk9Vn1+IuYv6sSKKtZf/8YV9ausyAMAU+8X5t0i0AFgupQJ+cObH40HN26vonwkOu2Lot2aP61Bfj5lFX6092w1YT8WI73jsfLW62LlLdebrAPAFCuBbsUdAKZQmZZv+uRD8fADO+Ifvrz/TJRfEoPdnBeplGfaO+XVnh/dKtYf+vTX4s83/l28eOmiWLXmpnhNFerlOXYAYPIJdACYAmfD/L71W6tpeS+6nYVVlL84ZpPnx3p5fv2Od90bI6NH66n6bVWsC3UAmFxW3AFgEj0X5n8Zx4c7VeAuTLXCfqHKCvyp3nCMjhyPX771l4Q6AEwSK+4AMEn+cZgvjm67OWF+VpmqD7ReFL3qGw9bP70rHtzwubj5N/913PzuG4U6AFwggQ4AF+jhBx6NdbdvjKe+e7yK8kXVq/lfXkuod1uLqm9EzI/PfPJz9TP25Rn1lbdeHwDAxDTvW/sAME32DR2Id92wNm5/6x/G959sx0Dn0jpc+0k9Ua/+vZ9+cjA+suq/xdtf+1uxt/p5AQDGT6ADwARsWr+1itHfjp2f3xtzBq6Mdmtu9LMS6nMGropvf2U43vzy98c9a+8PAGB8BDoAjEN51nz1Wz8e61Z/Jk4cubheaec53XY5rX5JfGrt5nq7wDQdAMZOoAPAGO3eNVRNzdfE9i2766l5v62zj1X5eSmRXrYLSqTv2PZ4AADnJ9ABYAzKSvu7bvi9OPhEKwY6LwrOr2wXfP/JTvz6Db9v5R0AxkCgA8B53HPH/bFu9X31SnunPS8Yu3ZrTjVNv6L6OXwg1t2+IQCAFybQAeAcPrzqrmr6u6Ve2bbSPjH1yvvAlfGZ9dvqlffyHD8A8I8JdAD4KUpElpj8i3sfO/O8uS+ZF6JVveUY6F5+5rn0Ox0eBwA/hXcbAPATTsf5nfGlzz1R3/HN5CnPpX/7q4ec8A4AP4VAB4DnORvn3/7KIYfBTZES6QeeOGndHQB+gkAHgOf5yDvvjm995enodtxvPpWei/Q7RToAnCHQAeCMdas3xvYtXzc5nyYl0r/11adj9Vs/EQCAQAeAWrlKbdP6v6miUZxPp4Hq5/uL27/tCjYACIEOALFlw7a4Z+1nY7B7mdPaZ0A53X3TH/x19Q2SrQEA/cy7EAD62r6hA9X0dmMV5y92z/kMKVewDXaviHWr743dO4cCAPqVQAegr73zhrVxfHiOOJ9h5ed/oIr0D7z14w6NA6BvCXQA+lY5FO6p7x6PbnthMPParTnx1BPPxkdW3R0A0I8EOgB9qTx3vmn9X9UniZNH+fXYtmWX59EB6EsCHYC+U1ao7157fwx0L7Xankx5Hn2gc2ncfcf9Vt0B6DsCHYC+c8/aP6tX29utuUE+rdZgHD8yYNUdgL4j0AHoK+XUdqvt+XXaC+ORzTtjx7bHAwD6hUAHoK98uJrKdjuLrLYnV6+6dy+tD/IDgH4h0AHoG+VguMe27a6mswuC/Mqp7v/w5f31rxsA9AOBDkDfKAfDlek5s0e3s7ieojswDoB+INAB6AtlCrt/6Aem57NMmaIffWYk7vvkQwEATSfQAegLpuezV5miW3MHoB8IdAAar5wEbno+e5Up+vf2DMfDmx8NAGgygQ5A423ZuM30fJYrU/RN6625A9BsAh2ARiv3nj+44QvRbl8UzF5liv7Ytq+7Fx2ARhPoADTaw5t3VHE+t75Xm9mt07nYmjsAjebdCgCNdt/6rdFpzQ9mv/Lr+OCG7QEATSXQAWis3TuH6sPhygSd2a/V6tZXrllzB6CpBDoAjbV543bPnjdMp/r1tOYOQFMJdAAaq0xaO615QXO0q19Pa+4ANJVAB6CRyunt39z1XevtDVPW3I88c6J+fAEAmkagA9BI39i1p76ai+YpU/Qd2z2HDkDzCHQAGumRzY9WIWd63kTt1mA85qA4ABpIoAPQSN/YWSboA0HzlM0IJ7kD0EQCHYBG+uauIc+fN1T9HPrh47F36GAAQJMIdAAap0xXTc+brdWaG7t3fScAoEkEOgCNM3z4WPX3btBcZYq+zwQdgIYR6AA0TrmCqxwkRnOVX9/dO/cEADSJQAegcXaX58+tuDdbqx179xwIAGgSgQ5A4xypV9x9iWuydgzEviGBDkCzePcCQOPsrcKtPKNMg1UT9COHjgUANIlAB6Bx6gl6y5e4JmtVb2FOHwYIAM3h3QsAjTNcTVZbvsQ1XtmScBc6AE3i3QsAAAAkINABaJRhB8QBALOUdzAANMqRQ0ej5flzAGAW8g4GgEZZsuzy6PVOBQDAbCPQAQAAIAGBDgDMTr2RWLhoXgBAUwh0ABpnybLLrLn3gV7118LF8wMAmkKgAwCzTi9Gq+n5RQEATSLQAWic5dcsqyboJ4LmKhsSS372sgCAJhHoADROmayW9WeaqxcjsWCR9XYAmkWgA9A4y69dFqMm6M1WTdCXX7M0AKBJBDoAjVNP0B0S12ij1a/vVcsuDwBoEoEOQOOsuP4V0YuTQXOVMwbKWQMA0CQCHYDGWVJNVhcsGqxP+qaZTge6FXcAmkWgA9BI9Unuo55Db6JyvsDV177UHegANI5AB6CRrr6mHBT3bNA8verXdfkrrbcD0DwCHYBGesMbV1SB/sOgeUZGf1ifMwAATSPQAWikctXa/EUdz6E3UK/6xstrBDoADSTQAWikctVaeQ59dPR40BzlsYXy/Lkr1gBoIoEOQGO9vqy5j1pzb5KR0SOx8pbrAwCaSKAD0Fgrb70+RnrHrbk3SJmgl2+8AEATCXQAGqusua+4/mXRG3WaexPU6+3XXGW9HYDGEugANNrN77kxTo0+E8x+Zb39be++MQCgqQQ6AI1WruNymvvs1+udqgL9qNPbAWg0gQ5Ao5U195urqevIyHAwe5X19pW3XGe9HYBGE+gANN7bfrOsuQ+bos9ip0YPx20fvCkAoMkEOgCNV6boK295nSn6LFVW21993dWm5wA0nkAHoC+UK9dM0WenMj1ftcb0HIDmE+gA9IVyWJwp+uxzdnq+wuFwAPQBgQ5A31j1wZtM0WeZMj3/0N2rAgD6gUAHoG8sWXZ53LbmzdUU/XCQX4nzX377L3n2HIC+IdAB6CvlRPd5F4/E6OgPg7zKvefzFp50cjsAfUWgA9BXyonu7//oLXFy9FCQ16mRH8TN77nR9ByAviLQAeg75UT311z3T6sItOqeUTkY7oql853cDkDfEegA9KVy8Ni8i09Gr3ciyKOstp8a/UH80UNrAgD6jUAHoC+VA+PKqvuJkYNOdU/kxMhT8Y41b7baDkBfEugA9K2y6v7Wd/8rp7onUU5tf/3Ka622A9C3BDoAfa3cjf5P/sUlcWpkOJg5I6PDcfnPDMT7PnZLAEC/EugA9LVyqvt/+sx7Y97Fz7p6bYaU587nLjxZP3dutR2AfibQAeh75Xn0Eof18+hVLDJ9ys93ee78d+56hzgHoO8JdACoLL9mWXzo7nfUsSjSp8fZOH/HmjfFG9708wEA/U6gA8AZ5dC4d/zWm0T6NOj1RuuNhRLnDoUDgNMEOgA8Tzk0TqRPrdNxXibnK8U5ADxPNwCAH1MivfjUnQ/EYOeKaLV8uZwsp9faD4pzAPgpvOMAgJ9CpE++5z9znjHO3/Ty98a+oYMxXrdV/y5nf78AwIWw4g4AL6BE1+/c9e/j2VP7XcF2gXq9E3Wcv++jN5ucA8ALEOgAcA7l4Lh7/8/vxqU/MxqnRg4H4zcyeiQGFxyJj256T7ztPTcGAPDTCXQAOI9yBdtdD62Jy186UEX6D6IXo8HYnKx+vi77mXZs/LvfdZUaAJyHQAeAMViy7PJ44OufiH/zG6+LE6f2O+H9PMrPT3k04LpfXh73/t3auKr6+QMAzk2gA8A4/IeP3VI/l37JS05YeX8BI6PDMbjgmXjfR98SH/vM+2Lh4vkBAJyfQAeAcSrPpZeV9xt/9ZpqSrzXNP2M+pT2U9+LV77uynql3fPmADA+Ah0AJqCsvH/onnc+b5r+g74N9V7v9AF6ZWr+3o/+2/qbF1baAWD8BDoAXIDnpumvqq8RGxk9Gv2k/PueGNlbbxOYmgPAhRHoAHCBzk7TP/v4x+KGt/3zeu296aFe7oUv/56vfN0V8V+3/sf639/UHAAuTDcAgElxNtTLVP3utffHF7d/M7rtRdFuzYtWa/Z/T7ysso/2jsap0eF49XVXx6o1t8WK618RAMDkEOgAMMlKtN51/ZrYN3Qg7r7j/njw3r+tIn1OHeut1uz70lvCvJzMPtIrYf6yKsx/Q5gDwBQQ6AAwRc5O1Fd98KY61Hdsfzy+t+f70WkvqIM9c6yfnZaPjB6L+Ys6cfO7b4yVt15njR0AppBAB4ApdjbUix3bHo8tG7bFI1t2xNHDI6djPQai1R6MmVZOoR/tHf9RlF99zbJqWn5TLL9mqbvMAWAaCHQAmEZlNfzsevjDm3fEIw88Wk/W9+85WE/V26250xbsp4P82ep1og7zBYsG4/Urfz5e/6YVseK6l4tyAJhmAh0AZsgb3riifhW7dw3F7p1D9YT9G7v2xDerH5dgLxeutFuD0Sqv8lerO67V+Ppu9rKuHierH1UfR0+c+fxUXLn0kirEfy6WX7u0/qbB8mpiDgDMHIEOAAmUOC6vcgJ8MXzoaBXte+qD5vYOHawDfvjwsfrH+4b21v+dc4f6aP0c+ZJll1WT8flx1bKXxJKll8XLrq3+/1Sv8rkJOQDkItABIKESz6dX4V/4tPQS7i/4f79ongAHgFlGoAPALHVVNR0HAJqjHQAAAMCME+gAAACQgBV3AGDWuW/91vo1mfad45n+c9n0ya2xZeO2mEx/9NAHPcIA0IcEOgAw6wwfOjbhoJ5s5X9LeQHAhbLiDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEAC3QAAmGXe8KYVcdWyy2Iyrbt9YwwfOhbj9YY3rojXV6/JtHDRvACg/wh0AGDWWX7Nsvo1me5ee/+EAv3q6n/HyluvDwC4UFbcAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIIFuAADpDR86GsOHj8eR+uOx+sdHqo8vZMmyy3/s84WL5sXCxfMDAMhLoANAAnuHDsbund+JfXsOVp8fiP1DB+t/Nnz4aOyrPraqv6LVOf0x2tXf23GuRbhenHre5yPV30aqj70q1i+Lq87E+9XXLK0/X7L09D9bfu2yAABmjkAHgGlUJt+7d+2pXkNVkJ/+uG/PgWoafqLK7YEqwrvRbpUvz+3qY/XjGIy5A0tjsjz95Kn4/pNP19G+6/P7Y7R3Knq9E9V/Mlp9fjKWX7OsivXL4jXXv6L+fHkV8SbvADA9BDoATKES5I9s3hHfqEL8sW1fj29Wcd5qDdavdv0qEX5JzOlOz7EwrSr+W2e//FfD+M5P/OdDX3s2/t/XhmL7g7vrcC+vMmlffu3SWHHdK+pwv+p56/MAwOQR6AAwic5OyB/e/Ggd5vuHvl9F+Nxot6tXa07MGXhpZFa+cdCppvadzkU/+md1tH/1a/EXGx+tp+xXLlscK6pQf/3KFfVHE3YAmBwCHQAuUInyLRu310FeVtaPHh6JTvuiWRHkY1FHe3m1T4f400+eiIc+/bX4843/twr2Z+tIX3nLdabrAHCBBDoATMDzo7ysrrdbF52Zkl8Sg91m32L6k8G+6wsH4kufuzdGR5+tIv1qsQ4AEyTQAWAcdmx7PO5Ze381Kf9uPSnvdhZWQf6SKlqbHeXn0qm+OVGvxHcivvyFp8/E+rEq0l9ex/rKW68PAOD8BDoAnEeZlm/65ENx3/qtz1tfX9z4SflElLX+dmdOFeuXxq7PPxVf3P6ncXf1DY2yBn/bmptM1QHgHAQ6ALyAs9PyeoW9vaAK8wVVlM8NxqaswJdXudrtL+59LB7c8Lf1CnwJ9RLsAMCPE+gA8BOeC/Pd0e1c3Pcr7BeqXO02UE3Uywp8mar/+g2/X58Ev6oK9Uzr7297z40xfOhYjJdvNgAwWVqv7ry99/fHNwYA9LstG7bV69jf2zNchfmi+no0pkY5/f3UyKF48dKF6UIdAGbCL8y7RaADgDCfOb3eqTg1ejiueOk8oQ5AXxPoAPS1s6vsX9z+bWE+w0qonxz5QTVRny/UAehLAh2AvrR711CsW72xfsZ8oHupME+krL6fPPX9+hn1P3pojVPfAegbJdCdeANA3yjXpZUwv+UXPxg7P78/5gy8RJwnU65pmzNwVRx8ohdvfvnq+PCqu2Lv0IEAgH7gFHcA+kJ5znzd7Rvj2DMdp7LPAuV6tnZ7Xmz99K76UYRffc+NcXP1AoAm8+4EgEbbV01f33XD2vjdd/5pPHtkQQx0XiTOZ4lW9Tal214UTz85GB+//X/Fm17+XtN0ABrNOxQAGmvT+q3x9tf+dr3OPth9sXX2Warco15+/c6uvZeD/QCgiQQ6AI1zdmpepq4njlxcTWEXBrNfWXsf7F4Rf3znQ6bpADSSQAegUbZs2F5Nzdf8aGpepq80R/n1HOhcemaa/n7TdAAaxbsWABqhnNB+z9o/i03r/6oK88urqflg0Fz1IXKtOXHPHQ/Uk/Tb1tzkSjYAZj0TdABmvbLSXqbmn/nDz1dxvqSasorzflCm6eVKtnLSe3mkYffOoQCA2UygAzCrnV5p/+048MSIE9r7VDnp/eCTEbe89kNW3gGY1ay4AzBr3XPH/VWQfdZKO9FpXRTt7mC98j58+Gi8/6O3BgDMNsYMAMw65Xnz1W/9eHzqzgettPMj9XVsA1fGZ/7wC/H2X1zjlHcAZh2BDsCscvoKtTtj+5bdZ05p96WM57SqtzYD7RfFt796qH4uXaQDMJt4VwPArFHi/J1VdH37K4fq583hhZTn0su5BA6PA2A2EegAzAq7dw3VJ7UffGI0up1FAefTbS+Mp5/sxi2v/WB9mCAAZCfQAUivxNW7bvi9ePbIgui0FwSMVTmfoJxT8JFVfxyb1m8NAMhMoAOQWonzj6y6O05Ucd5uzQ0Yr/rwuO4VsW71JtewAZCaa9YASOt0nH/qzEntvmQxcWcjvVzDVty25qYAgGxM0AFI6bk4f7E4Z1I8P9JN0gHISKADkI44Z6qIdAAyE+gApFJOay/PnA92LxfnTInnR7rT3QHIRKADkEa557yc1n56cj4YMFXORnr5ZtCObY8HAGQg0AFIocT5O29YGz8cHhTnTIvTkf7iWP2W/xK7dw4FAMw0gQ7AjDsb5we+e9I950yr8s2gHx4ZjA+89eOxt/p9CAAzSaADMOM+8JZP1HHe7SwKmG7lm0IHnhiJd1XfJBo+dDQAYKYIdABm1LrVG+NbX3lKnDOjuu2F8dQTz9bPpAPATBHoAMyYTeu3Vq+/quLo0oCZNtB+UWzb8hXXrwEwYwQ6ADOiXKe2bvV9Z05s9+WIHAa6l9fXrz38wKMBANPNOyIApl05FO4Db/l4dDuXuOucVFrVW6PB7mXxkVWfcmgcANNOoAMw7dbdvvHMie3zArIpJ7sfPzIQq9/yCYfGATCtBDoA0+qeO+6PRx74skPhSK0cGvetLz8V99zpeXQApo9AB2DalNX2e9Z+tl4hhuy63Utj0x/8dezY9ngAwHQQ6ABMm3fesLaenHvunNmgPI8+UEX6h1fdZdUdgGkh0AGYFmW1/anvHo9Oe0HAbNFuzXE/OgDTRqADMOXOrrZ32547Z/Ypv28f2bzT1WsATDmBDsCUs9rObHZ21b1M0a26AzCVBDoAU8pqO01QVt2PHek41R2AKSXQAZgyVttpkvL72KnuAEwlgQ7AlLl77f3R6VxstZ1GKKvu3e7iWLd6YwDAVBDoAEyJLRu2xYMbvlBNHRcGNEWndVH8w5f3x6b1WwMAJptAB2BKlOl5t3NJQNMMdF4Ud99xvwPjAJh0Ah2ASVem56cPhpsX0DSt1mB9YNx9n3woAGAyCXQAJlU5GK6enjsYjgY7fWDcX8be6vc7AEwWgQ7ApNqyYXs9PXcwHE1WDow7Xq5dW+vaNQAmj0AHYNKU6fnmjdtMz+kLnfbCeHDD50zRAZg0Ah2ASVNW203P6Rdlil6uETRFB2CyCHQAJkWZnu/Y9rjpOX3FFB2AySTQAZgUnj2nH5miAzCZBDoAk8Kz5/SrMkV/5IEvuhcdgAsm0AG4YGfvPTc9px+dPdHdvegAXCiBDsAFK4fDdVrzA/pV+f2/6Q+2mqIDcEEEOgAXpBwM9709h6PdnhvQr8r2yNFnRmLLxu0BABMl0AG4IPet31o/gwv9rttZHI9s3hEAMFECHYAJK1erbdv8pSrQFwT0u3ZrTjy27ev1VgkATIRAB2DCHq6mhVbb4TnlyrWHNz8aADARAh2ACSvr7d2W9XY4qzzu8eCG7Q6LA2BCBDoAE1LWePcP/SBa7cEATitXrpXD4h7e/FgAwHgJdAAmZMvGbdW08OIAflw5k+HB6s8HAIyXQAdgQsoEvdOeF8CPa1d/LsphcdbcARgvgQ7AuJ2++3y4vvsZ+HFlzb3VGnQnOgDjJtABGLey3t5uXRTAT1fW3N2JDsB4CXQAxs16O5xbWXPfvfO71twBGBeBDsC47N45FN/bc9h6O5zD6dPcT8buXXsCAMZKoAMwLg9v3lHF+dwAzq3Tvqj68/JoAMBYCXQAxuWx7Y9Hp2W9Hc6nXf05eXCDg+IAGDuBDsCYDR8+Vj9/3m6boMP5lMdAjjxzIvYOHQwAGAuBDsCY1XHemhPA2LRjTjxizR2AMRLoAIzZ6UB3vRqMVdk22b3TQXEAjI1AB2DMvrlrqAr0gQDGpmycmKADMFYCHYAx8/w5jE/9HPrh455DB2BMBDoAY+L5c5iYci1h+fMDAOcj0AEYk927hqrQGAxgfDrlOfRd3wkAOB+BDsCYnJ6ge/4cxq3VjW/uclAcAOcn0AEYk/IMbTtM0GG8yqMhu3cOBQCcj0AHYEzKCe6ttkCH8WpVb7ccFAfAWAh0AM6rTP+st8PElYPiPIcOwPkIdADOa++eMvnrBjAx5bq1fSboAJyHQAfgvMoEvQQGMDHt6s/P3qEDAQDnItABOK/hw8eiZYIOE1cF+n4TdADOQ6ADcF7lgDjPoMPEtWMgvrHLSe4AnJtAB+C8njl0rD6JGpigVjuOVH+OAOBcvNsC4Lz27zlQfcWw4g4TdfaqteFDRwMAXohAB+CcyvPnw4d+aIIOF6rVqf48HQ8AeCHebQFwTkeqiV+r5csFXKhWdGKfk9wBOAfvuAA4p71DB+uwAC5MuQlhr5PcATgHgQ4AAAAJCHQAzqms5LoDHS5cq9W14g7AOQl0AAAASECgA3BO5RT3cEgcAMCU844LgHMaPnTMFWswCU6vuDskDoAX5h0XAAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEAC3QCA8xjpHY3RUz8MYOJ6MRIAcC4CHYBzeuOt18WK618RwIVbfs3SAIAXItABOKclyy6vXwAATC3PoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACAh0AAAASEOgAAACQgEAHAACABAQ6AAAAJCDQAQAAIAGBDgAAAAkIdAAAAEhAoAMAAEACJdAPDR86GgAAAMD0Gz58rP5YAv1L933yoQAAAACm34MbtkUvep/tXNn7uUce+9w3fu3ixRfNXbZ8ScyZOxgAAADA1Crb7P/jP2+J9R/8n4didPRXWuUfvipu/tnodD/eit6bAwAAAJh6vTjUa8WXYmTk330pNn3n/wOzGsHSOq0/PgAAAABJRU5ErkJggg==">
				</label> 
				<input type="file" name="foto-perfil" id="fotoPerfil" accept="image/*" onchange="adicionarFoto(this)">
			</div>
			<div class="container-botao">
				<button type="reset" class="botao-secundario">Limpar</button>
				<button type="submit" class="botao-primario">Salvar</button>
			</div>
			</form>
		</div>
	</main>
</body>
</html>
