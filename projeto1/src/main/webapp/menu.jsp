<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Estoque de Produtos</title>
<link rel="icon" href="imagens/icone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Sistema de Estoque de Produtos</h1>
	<div class="box" style="width: 35%; height: 300px; left:20%; right: 20%">
	<img src="imagens/warehouse1.png" style="width: 120px">
	<div style="text-align: center; padding: 30px">
			<a href="novoProduto.html" class="Botao1">Novo Cadastro</a>
			</div> <div style="text-align: center; padding: 30px">
			<%-- <a href="read" class="Botao1">Visualizar Estoque</a></div><div style="text-align: center; padding: 30px">--%>
			<a href="editPage" class="Botao1">Visualizar Produtos</a></div>
	</div>
	<a href="Controller" class="Botao1" style="background-color: #808080">Sair</a>
</body>
</html>