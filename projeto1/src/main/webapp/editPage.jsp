<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%-- Criando o vetor dinamico (ArrayList) para receber o objeto lista --%>

<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("editPage");
%>
<!DOCTYPE html>
<html>
<head lang="pt-br">
<meta charset="UTF-8">
<title>Estoque de Produtos</title>
<link rel="icon" href="imagens/icone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Lista de Produtos em Estoque</h1>
	
	<div>
	<table id="tabela">
		<thead>
			<tr>
				<th>Nome</th>
				<th>ID</th>
				<th>Código</th>
				<th>Categoria</th>
				<th>Valor</th>
				<th>Quantidade</th>
				<th style="text-align: center">Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getId()%></td>
				<td><%=lista.get(i).getCodigo()%></td>
				<td><%=lista.get(i).getCategoria()%></td>
				<td>R$ <%=lista.get(i).getValor()%></td>
				<td><%=lista.get(i).getQuantidade()%></td>
				<td><a href="select?id=<%=lista.get(i).getId()%>"
					class="Botao2">Editar</a> <a
					href="javascript: confirmar(<%=lista.get(i).getId()%>, '<%=lista.get(i).getNome()%>')"
					class="Botao3">Excluir</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	</div>
	<a href="main" class="Botao1">Voltar ao Início</a>
	<script src="scripts/confirmador.js"></script>
</body>
<footer>
<p><strong>Projeto 1</strong> - Academia Java (Atos) - Desenvolvido pela aluna Cristhiane Barros da Cruz<p>
</footer>
</html>