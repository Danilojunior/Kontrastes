package fafica.pi.projeto.teste;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fafica.pi.projeto.entidades.Cliente;
import fafica.pi.projeto.jdbc.ClienteDAO;

public class TesteClienteDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	      //testeCadastrar();
		//testeAlterar();
		//testeDeletar();
		//testarListarTodos();
		//testarAutenticar();
		testarBuscaPorID();
		
	}
	//Testar metodo cadastrar
	private static void testeCadastrar() {
		Cliente cliente= new Cliente();
		
		cliente.setNome("Paulo");
		cliente.setLogin("PauloCoelho");
		cliente.setSenha("1212");
		
		ClienteDAO usu = new ClienteDAO();
		
		usu.cadastrar(cliente);
	}
	//Testar metodo alterar
	private static void testeAlterar(){
		
		Cliente cliente= new Cliente();
		cliente.setId_cliente(2);
		cliente.setNome("Matheus");
		cliente.setLogin("Rafinha");
		cliente.setSenha("1234");
		
		ClienteDAO usu = new ClienteDAO();
		
		usu.alterar(cliente);
	}
	private static void testeDeletar(){
		Cliente cliente= new Cliente();
		cliente.setId_cliente(4);
		
		ClienteDAO usu = new ClienteDAO();
		usu.excluir(cliente);
	}
	 private static void testarListarTodos(){
		 ClienteDAO usu = new ClienteDAO();
		 //Lista com os valores retornados do banco
		 ArrayList<Cliente> listaResultado = usu.listarTodos();
		 //Varrendo e imprimindo a lista
		 for(Cliente c: listaResultado){
			 System.out.println("NOME: "+c.getNome()+"\nLOGIN: "+c.getLogin()+"\nSENHA: "+c.getSenha()+"\nID: "+c.getId_cliente());
			 System.out.println("");
		 }
	 }
	 
	 public static void testarAutenticar(){
		 Cliente cliente = new Cliente();
		 cliente.setLogin("Rafinha");
		 cliente.setSenha("1234");
		 
		 ClienteDAO clienteDAO = new ClienteDAO();
		 System.out.println(clienteDAO.autenticar(cliente).getNome());
	 }
	 
	 public static void testarBuscaPorID(){
		 
		 ClienteDAO clienteDAO = new ClienteDAO();
		 Cliente cliente = clienteDAO.buscaPorID(2);
		 if(cliente!=null){
		 System.out.println("Nome: "+cliente.getNome());
		 }
	
	 }




}
