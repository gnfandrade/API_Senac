package br.com.primeiraapi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.primeiraapi.dominio.Produtos;
import br.com.primeiraapi.repositorio.ProdutosRepositorio;

/**
 * Servlet implementation class Exemplo
 */
@WebServlet("/Exemplo")
public class Exemplo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exemplo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    ProdutosRepositorio pr = new ProdutosRepositorio();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Produtos> pd = pr.listarProdutos();
		
		//Instancia da classe Gson.
		Gson gs = new Gson();
		String saida = gs.toJson(pd);
		
		response.setContentType("UTF-8");
		response.getWriter().print(saida);
				
		
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("Você enviou os dados pelo método POST");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("Você enviou dados para o PUT");
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("Você enviou dados ao DELETE");
	}

}
