package fafica.pi.projeto.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fafica.pi.projeto.entidades.AgendarServico;

public class AgendarServicoDao {
	
	private Connection con = Conexao.getConnection();
	
	public void cadastrar(AgendarServico agendarServico){
		
	String sql="INSERT INTO agendarServico (data) values(?)";
	
	try {
		PreparedStatement preparador= con.prepareStatement(sql);
		
		preparador.setString(1,agendarServico.getData());
		
		preparador.execute();
		preparador.close();
		System.out.println("Cadastrado com sucesso");
		
	} catch (SQLException e) {
		System.out.println("Não cadastrado"+e.getMessage());
	}	
	}
	public void salvar(AgendarServico agendarServico){
		if(agendarServico.getId_agendamento()!=null && agendarServico.getId_agendamento()!=0){
			alterar(agendarServico);
			
		}else{
			cadastrar(agendarServico);
		}
	}
	public void alterar(AgendarServico agendarServico){
		
		String sql="UPDATE agendaeServico SET nome=?,login=?,senha=? WHERE id=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setInt(1,agendarServico.getId_agendamento());
			preparador.setInt(2,agendarServico.getId_cliente());
			
			preparador.execute();
			preparador.close();
			System.out.println("Alterador com sucesso");
			
		} catch (SQLException e) {
			System.out.println("Não alterar "+e.getMessage());
		}
	}	
public void excluir(AgendarServico agendarServico){
		
		String sql="DELETE FROM agendarServico WHERE id=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);			
			
			preparador.setInt(1,agendarServico.getId_agendamento());
			
			preparador.execute();
			preparador.close();
			System.out.println("excluir com sucesso");
			
		} catch (SQLException e) {
			System.out.println("Não excluir"+e.getMessage());
		}
	}
public List<AgendarServico>listaTodos(){
	
	String sql="SELECT * FROM agendarServico";
	List<AgendarServico>lista=new ArrayList<>();		
	
	try {
		PreparedStatement preparador = con.prepareStatement(sql);		
		ResultSet resultado = preparador.executeQuery();
		
		
		while(resultado.next()){
			AgendarServico usu = new AgendarServico();
		usu.setId_agendamento(resultado.getInt("id_agenda"));
		lista.add(usu);
		
		}
		preparador.execute();
		preparador.close();
		System.out.println("Lista com sucesso");
		
	} catch (SQLException e) {
		System.out.println("Não listado"+e.getMessage());
	}
	return lista;	
	}


}	



