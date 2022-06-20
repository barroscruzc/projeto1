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
<link rel="stylesheet" href="//cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css">
<link rel="stylesheet" href="style.css">
</head>
<body>
<div style="margin: 5%">
<div style="margin-top: 40px">
	<h1>Lista de Produtos em Estoque</h1></div>
	<div style="margin: 30px">
<a href="novoProduto.html" class="Botao1" style="background-color: #60bd87">Novo Cadastro</a></div>
	<div id="div_tabela">
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
	
	<a href="Controller" class="Botao1" style="background-color: #808080">Sair</a>
	<a href="main" class="Botao1">Voltar ao Início</a>
	</div>
	<script src="scripts/confirmador.js"></script>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="//cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#tabela').DataTable({
				"language" : {
					"lengthMenu" : 'Exibindo _MENU_ resultados por página',
					"zeroRecords" : 'Nenhum resultado foi encontrado',
					"info" : 'Exibindo página _PAGE_ de _PAGES_',
					"infoEmpty" : 'Nenhum registro disponível',
					"infoFiltered" : '(filtrado de _MAX_ registros)',
					"search": 'Pesquisar',
					"previous": 'Anterior',
					"next": 'Próxima'
				}
			});
		});
	</script>
</body>
<footer>
	<p>
		<strong>Projeto 1</strong> - Academia Java (Atos) - Desenvolvido pela
		aluna Cristhiane Barros da Cruz
	<p>
</footer>
</html>