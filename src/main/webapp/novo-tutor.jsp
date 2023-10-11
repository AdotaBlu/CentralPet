<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        <%@ include file="/resources/css/estilo.css" %>
    </style>
    <c:choose>
        <c:when test="${tutor == null}">
            <title>Cadastro Tutor</title>
        </c:when>
        <c:otherwise>
            <title>Editar Tutor</title>
        </c:otherwise>
    </c:choose>
</head>
<body>
    <main>
        <div class="container-endereco">
        <!-- Semelhante ao Swicth Case -->
            <c:choose>
                <c:when test="${tutor == null}">
                    <form method="post" action="cadastro-tutor" enctype="multipart/form-data">
                </c:when>
                <c:otherwise>
                    <form method="post" action="editar-tutor" enctype="multipart/form-data">
                </c:otherwise>
            </c:choose>
            <c:if test="${endereco != null}">
            <label for="logradouro">Logradouro</label>
            <input type="text" id="logradouro" name="logradouro">
            <label for="numero">Número</label>
            <input type="number" id="numero" name="numero">
            <label for="bairro">Bairro</label>
            <input type="text" id="bairro" name="bairro">
            <label for="cep">CEP</label>
            <input type="text" id="cep" name="cep">
            <label for="pontoReferencia">Ponto de Referência</label>
            <input type="text" id="pontoReferencia" name="pontoReferencia">
            </c:if>
        </div>
        <div class="container-cadastro">
            <h1>Informações tutor</h1>
            <label for="nome">Nome</label>
            <input type="text" id="nome" name="nome">
            <label for="cpf">CPF</label>
            <input type="text" value="${tutor.cpf}" id="cpf" name="cpf">
            <label for="dataNascimento">Data de Nascimento</label>
            <input type="date" id="dataNascimento" name="dataNascimento"/>
            <label for="drop_down_genero">Gênero</label>
            <select name="generoTutor" id="drop_down_genero">
                <option value="MASCULINO">Masculino</option>
                <option value="FEMININO">Feminino</option>
                <option value="OUTROS">Outros</option>
            </select>
            <label for="telefone">Telefone</label>
            <input type="tel" id="telefone" name="telefone">
            <label for="email">Email</label>
            <input type="email" id="email" name="email">
            <label for="senha">Senha</label>
            <input type="password" id="senha" name="senha">
            <label for="fotoPerfil">Escolha uma foto de perfil</label>
            <input type="file" name="fotoPerfil" id="fotoPerfil" accept="image/*">
            <div class="container-botao">
                <button type="reset" class="botao-secundario">Limpar</button>
                <button type="submit" class="botao-primario">Salvar</button>
            </div>
            </form>
        </div>
    </main>
</body>
</html>
