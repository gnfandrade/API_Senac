package br.com.primeiraapi.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.com.primeiraapi.dominio.Produtos;

public class ProdutosRepositorio {
	
	public List<Produtos> listarProdutos(){
		List<Produtos> lst = new ArrayList<Produtos>();
		
		//Criando os produtos para serem aramzenados na lista
		Produtos p1 = new Produtos(1,"Mouse","Mouse Microsoft","Informática",20.56);
		Produtos p2 = new Produtos(2,"Teclado","Teclado sem Fio","Informática",25.00);
		Produtos p3 = new Produtos(3,"Processador","Intel Core I7","Informática",450.45);
		Produtos p4 = new Produtos(4,"Placa Mãe","Placa Mãe Asus","Informática",390.99);
		Produtos p5 = new Produtos(5,"Cabo de Rede","CAT5 Furukawa","Telecomunicação",120.99);
		
		lst.add(p1);
		lst.add(p2);
		lst.add(p3);
		lst.add(p4);
		lst.add(p5);
		
		return lst;
	}
		
	

}
