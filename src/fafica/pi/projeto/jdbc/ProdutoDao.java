package fafica.pi.projeto.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fafica.pi.projeto.entidades.Produto;


public class ProdutoDao {
	
private Connection con = Conexao.getConnection();
	
	public void cadastrar(Produto produto){
	
		String sql = "insert into produto (nome,preco) values(?,?)";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			
			preparador.setString(1, produto.getNome());
			preparador.setDouble(2,produto.getPreco());
			preparador.execute();
			preparador.close();
			System.out.println("CADASTRADO COM SUCESSO!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
	}
	public void alterar(Produto produto){
		
		String sql = "update produto set nome=? where id_produto=?";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
		     preparador.setString(1, produto.getNome());
		     preparador.setDouble(2, produto.getPreco());
			
			
			
			preparador.execute();
			preparador.close();
			System.out.println("ALTERADO COM SUCESSO!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
	}
	public void excluir(Produto produto){
		
		String sql = "delete from produto where id_produto=?";
			try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setInt(1, produto.getId_produto());
			
				
			preparador.execute();
			preparador.close();
			System.out.println("EXCLUIDO COM SUCESSO!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
	}
	
	public ArrayList<Produto> listarTodos(){
		//Montando a consulta SQL
		String sql = "select * from produto";
		//Constroe o PreparedStatement passando o sql
		ArrayList<Produto> lista = new ArrayList<>();
		try {
			//Executando a consulta SQL
			PreparedStatement preparador = con.prepareStatement(sql);
			
			//Executa uma consulta atravez do executeQuery...E em seguida guarda essa consulta dentro do resultSet
			
			ResultSet resultado= preparador.executeQuery();
			/*Faz uma varredura em todas as linhas retornadas 
			E captura seus dados.*/
			
			
			while(resultado.next()){
				
				Produto cliente = new Produto();
				
					 
				cliente.setId_produto(resultado.getInt("id_produto"));
				cliente.setNome(resultado.getString("nome"));
				
				lista.add(cliente);
			}
			preparador.close();
			System.out.println("RETORNANDO LISTA COM SUCESSO!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return lista;
		
		
		
	}



}
