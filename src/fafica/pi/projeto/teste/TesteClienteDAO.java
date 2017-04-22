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
		testeAlterar();
		//testeDeletar();
		//testarListarTodos();
		
	}
	//Testar metodo cadastrar
	private static void testeCadastrar() {
		Cliente cliente= new Cliente();
		
		cliente.setNome("Rafinha");
		cliente.setLogin("RafaRafa");
		cliente.setSenha("98746567");
		
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
		 }
	 }




}
