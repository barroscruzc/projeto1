package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@SuppressWarnings("unused")
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/read", "/select", "/editPage", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans produto = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			principal(request, response);
		} else if (action.equals("/insert")) {
			novoProduto(request, response);
		} else if (action.equals("/read")) {
			listarProdutos(request, response);
		} else if (action.equals("/select")) {
			selecionarProduto(request, response);
		} else if (action.equals("/editPage")) {
			editPage(request, response);
		} else if (action.equals("/update")) {
			editarProduto(request, response);
		} else if (action.equals("/delete")) {
			deletarProduto(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Redireciona ao menu com opcoes de cadastrar, alterar, visualizar ou excluir
	// produtos
	protected void principal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("menu.jsp");
	}

	// Cadastrar novo produto
	protected void novoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// editar as variaveis JavaBeans
		produto.setStrCodigo(request.getParameter("codigo"));
		produto.setNome(request.getParameter("nome"));
		produto.setCategoria(request.getParameter("categoria"));
		produto.setStrValor(request.getParameter("valor"));
		produto.setStrQuantidade(request.getParameter("quantidade"));

		// invocar o metodo inserirProduto passando o objeto produto
		try {
			dao.inserirProduto(produto);

		} catch (Exception e) {
			System.out.println(e);
		}

		// redirecionar para a pagina inicial - menu.jsp
		response.sendRedirect("main");
	}

	// metodo para exibir a listagem completa dos produtos cadastrados
	protected void listarProdutos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que ira receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarByName();
		request.setAttribute("listarProdutos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("listarProdutos.jsp");
		rd.forward(request, response);
	}

	protected void editPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que ira receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarByName();
		request.setAttribute("editPage", lista);
		RequestDispatcher rd = request.getRequestDispatcher("editPage.jsp");
		rd.forward(request, response);
	}

	protected void selecionarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento do id do produto a ser alterado
		String id = request.getParameter("id");
		// configurar a variavel JavaBeans
		produto.setStrId(id);
		// Executar o metodo selecionarContato(DAO)
		dao.selecionarProduto(produto);
		// configurar os atributos do formulario frmUpdate com o conteudo JavaBeans
		request.setAttribute("id", produto.getId());
		request.setAttribute("codigo", produto.getCodigo());
		request.setAttribute("nome", produto.getNome());
		request.setAttribute("categoria", produto.getCategoria());
		request.setAttribute("valor", produto.getValor());
		request.setAttribute("quantidade", produto.getQuantidade());

		// Encaminhar ao documento updateProduto.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editarProduto.jsp");
		rd.forward(request, response);
	}

	protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		produto.setStrCodigo(request.getParameter("codigo"));
		produto.setNome(request.getParameter("nome"));
		produto.setCategoria(request.getParameter("categoria"));
		produto.setStrValor(request.getParameter("valor"));
		produto.setStrQuantidade(request.getParameter("quantidade"));

		try {
			// invocar o metodo inserirProduto passando o objeto produto
			dao.editarProduto(produto);
		} catch (Exception e) {
			System.out.println(e);
		}

		// redirecionar para a pagina de edicao - editPage.jsp, atualizando as
		// alteracoes
		response.sendRedirect("editPage");
	}

	// Deletar um produto do banco de dados
	protected void deletarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			// invocar o método inserirProduto passando o objeto produto
			produto.setStrId(id);
			// executar o médoto deletarProduto usando o objeto Produto como parametro
			dao.deletarProduto(produto);
		} catch (Exception e) {
			System.out.println(e);
		}
		// redirecionar para a pagina de ediçao - editPage.jsp, atualizando as
		// alteracoes
		response.sendRedirect("editPage");

	}
}
