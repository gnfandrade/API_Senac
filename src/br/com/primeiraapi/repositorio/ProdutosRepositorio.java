package br.com.primeiraapi.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.primeiraapi.dominio.Produtos;

public class ProdutosRepositorio {
	
	public List<Produtos> listarProdutos(){
		List<Produtos> lst = new ArrayList<Produtos>();
		
		//Criando os produtos para serem aramzenados na lista
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja","root","");
			
			String consulta = "select * from produtos";
			
			pst = con.prepareStatement(consulta);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Produtos pd = new Produtos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
				lst.add(pd);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lst;
	}
		
	

}
