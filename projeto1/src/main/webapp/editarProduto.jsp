<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Atualizar Cadastro</title>
<link rel="icon" href="imagens/icone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
<div style="margin: 0 auto 0 auto">
<div style="margin: 5%">
	<h1>Atualizar Cadastro</h1>
	<div class="box" style="width: 400px; height: 280px">
		<div style="text-align: left">
			<form name="frmEditarProduto" action="update">

				<table>
					<tr>
						<td>ID* :</td>
						<td><input type="number" name="id" id="caixa3" readonly
							value="<%out.print(request.getAttribute("id"));%>"
							style="color: grey"></td>
					</tr>
					<tr>
						<td>Código*:</td>
						<td><input type="number" name="codigo" class="Caixa2"
							value="<%out.print(request.getAttribute("codigo"));%>"></td>
					</tr>

					<tr>
						<td>Nome*:</td>
						<td><input type="text" name="nome" class="Caixa1"
							value="<%out.print(request.getAttribute("nome"));%>"></td>
					</tr>

					<tr>
						<td>Categoria:</td>
						<td><input type="text" name="categoria" class="Caixa1"
							value="<%out.print(request.getAttribute("categoria"));%>"></td>
					</tr>

					<tr>
						<td>Valor*:</td>
						<td><input type="number" name="valor" class="Caixa2"
							value="<%out.print(request.getAttribute("valor"));%>"></td>
					</tr>

					<tr>
						<td>Quantidade*:</td>
						<td><input type="number" name="quantidade" class="Caixa2"
							value="<%out.print(request.getAttribute("quantidade"));%>"></td>
					</tr>

				</table>
				<div style="text-align: center; margin-bottom: 30px">
					<a href="editPage"><button class="Botao1"
							style="background-color: #cfcfcf">Cancelar</button></a> <input
						type="button" value="Salvar" class="Botao1"
						style="background-color: #60bd87" onclick="validar2()">
				</div>

			</form>
		</div>
	</div>
	<a href="main" class="Botao1">Voltar ao Início</a>
	</div></div>
	<script src="scripts/validador.js"></script>
	
</body>
<footer>
	<p>
		<strong>Projeto 1</strong> - Academia Java (Atos) - Desenvolvido pela
		aluna Cristhiane Barros da Cruz
	<p>
</footer>
</html>
