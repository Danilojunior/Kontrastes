package fafica.pi.projeto.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.net.httpserver.Authenticator.Result;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import fafica.pi.projeto.entidades.Cliente;

public class ClienteDAO {
	
	//Ponteiro para uma coneção com o banco 
	private Connection con = Conexao.getConnection();
	
	public void cadastrar(Cliente cliente){
		//Montando sql
		String sql = "insert into cliente(nome, login, senha) values(?,?,?)";
		//Constroe o PreparedStatement passando o sql
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			//Substituindo as interogações pelos dados do objeto
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getLogin());
			preparador.setString(3, cliente.getSenha());
			
			//Executa o comando no banco
			preparador.execute();
			preparador.close();
			System.out.println("CADASTRADO COM SUCESSO!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
	}
	public void alterar(Cliente cliente){
		//Montando sql
		String sql = "update cliente set nome=?, login=?, senha=? where id_cliente=?";
		//Constroe o PreparedStatement passando o sql
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			//Substituindo as interogações pelos dados do objeto
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getLogin());
			preparador.setString(3, cliente.getSenha());
			preparador.setInt(4, cliente.getId_cliente());
			
			
			//Executa o comando no banco
			preparador.execute();
			preparador.close();
			System.out.println("ALTERADO COM SUCESSO!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
	}
	public void excluir(Cliente cliente){
		//Montando sql
		String sql = "delete from cliente where id_cliente=?";
		//Constroe o PreparedStatement passando o sql
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			//Substituindo as interogações pelos dados do objeto
			preparador.setInt(1, cliente.getId_cliente());
			
			
			//Executa o comando no banco
			preparador.execute();
			preparador.close();
			System.out.println("EXCLUIDO COM SUCESSO!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
	}
	
	public ArrayList<Cliente> listarTodos(){
		//Montando a consulta SQL
		String sql = "select * from cliente";
		
		//Constroe o PreparedStatement passando o sql
		ArrayList<Cliente> lista = new ArrayList<>();
		try {
			//Executando a consulta SQL
			PreparedStatement preparador = con.prepareStatement(sql);
			
			//Executa uma consulta atravez do executeQuery...E em seguida guarda essa consulta dentro do resultSet
			
			ResultSet resultado= preparador.executeQuery();
			/*Faz uma varredura em todas as linhas retornadas 
			E captura seus dados.*/
			
			
			while(resultado.next()){
				/*Para cada linha retornada um novo objeto será criado
				para armazenar esses dados.*/
				Cliente cliente = new Cliente();
				
				/*Capturando os valores dos resultados
				 * e os atribui para cada objeto*/
				 
				cliente.setId_cliente(resultado.getInt("id_cliente"));//Pega o valor da coluna
				cliente.setNome(resultado.getString("nome"));
				cliente.setLogin(resultado.getString("login"));
				cliente.setSenha(resultado.getString("senha"));
				lista.add(cliente);
			}
			preparador.close();
			System.out.println("RETORNANDO LISTA COM SUCESSO!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return lista;	
	}
	//Primeiro pegamos o ID
	public Cliente buscaPorID(int id){
		//Segundo, montamos o SQL
		String sql= "select * from cliente where id_cliente=?";
		Cliente cliente=null;
		try {
			//Terceiro, preparamos o sql e colocando o ID dentro do SQL
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);
			
			//Terceiro executar no banco com o comando a seguir
			//Armazena o resultado da consulta
			//executeQuery = executar consulta
			ResultSet resultado = preparador.executeQuery();
			//Quarto pegamos o resultado e colocamos
			
			//Quinto colocar esse resultado em uma variavel do tipocliente
			//Sexto retornar esse objeto
			
			if(resultado.next()){//Se houver um próximo
				
				cliente = new Cliente();
				cliente.setId_cliente(resultado.getInt("id_cliente"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setLogin(resultado.getString("login"));
				cliente.setSenha(resultado.getString("senha"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
		
	}
	public Cliente autenticar(Cliente cliente){
		
		String sql= "select * from cliente where login=? and senha=?";
		Cliente clienteRetorno=null;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cliente.getLogin());
			preparador.setString(2, cliente.getSenha());
			
			ResultSet resultado = preparador.executeQuery();
				
			if(resultado.next()){//Se houver um próximo
				
				cliente = new Cliente();
				cliente.setId_cliente(resultado.getInt("id_cliente"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setLogin(resultado.getString("login"));
				cliente.setSenha(resultado.getString("senha"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
		
	}
	
	
	

}
