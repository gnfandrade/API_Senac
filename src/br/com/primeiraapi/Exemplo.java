package br.com.primeiraapi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String saida = "{";
		List<Produtos> produtos = pr.listarProdutos();
		for(int i = 0; i < produtos.size(); i++) {
			
			saida += "{\n";
			
			saida += "\"id:\""+produtos.get(i).getIdProduto()+"\n";
			saida += "\"nome:\""+produtos.get(i).getNomeProduto()+"\n";
			saida += "\"descricao:\""+produtos.get(i).getDescricao()+"\n";
			saida += "\"categoria:\""+produtos.get(i).getCategoria()+"\n";
			saida += "\"pre�o:\""+produtos.get(i).getPreco()+"\n";
			
			saida += "},\n";
		}
		saida += "}";
		
		response.getWriter().print(saida);
		
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("Voc� enviou os dados pelo m�todo POST");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("Voc� enviou dados para o PUT");
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("Voc� enviou dados ao DELETE");
	}

}
