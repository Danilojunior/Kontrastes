package fafica.pi.projeto.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fafica.pi.projeto.entidades.AgendarAtendimento;

public class AgendarAtendimentoDao {
	
	private Connection con = Conexao.getConnection();
	
	public void cadastrar(AgendarAtendimento agendarAtendimento){
		
	String sql="insert into agendarAtendimento(dataAtendimento, horarioAtendimento, id_profissional, id_cliente) values(?,?,?,?)";
	
	try {
		PreparedStatement preparador= con.prepareStatement(sql);
		
		preparador.setString(1,agendarAtendimento.getDataAtendimento());
		preparador.setString(2,agendarAtendimento.getHorarioAtendimento());
		preparador.setInt(3, agendarAtendimento.getId_profissional());
		preparador.setInt(4, agendarAtendimento.getId_cliente());
		
		preparador.execute();
		preparador.close();
		System.out.println("Atendimento agendado com SUCESSO.");
		
	} catch (SQLException e) {
		e.printStackTrace();
	}	
	}
	public void salvar(AgendarAtendimento agendarAtendimento){
		if(agendarAtendimento.getId_agendamento()!=null && agendarAtendimento.getId_agendamento()!=0){
			alterar(agendarAtendimento);
			
		}else{
			cadastrar(agendarAtendimento);
		}
	}
	public void alterar(AgendarAtendimento agendarAtendimento){
		
		String sql="UPDATE agendarAtendimento SET nome=?,login=?,senha=? WHERE id=?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setInt(1,agendarAtendimento.getId_agendamento());
			preparador.setInt(2,agendarAtendimento.getId_cliente());
			
			preparador.execute();
			preparador.close();
			System.out.println("Atendimento alterado com SUCESSO");
			
		} catch (SQLException e) {
			System.out.println("Não alterar "+e.getMessage());
		}
	}	
public void excluir(AgendarAtendimento agendarServico){
		
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
public List<AgendarAtendimento>listaTodos(){
	
	String sql="SELECT * FROM agendarServico";
	List<AgendarAtendimento>lista=new ArrayList<>();		
	
	try {
		PreparedStatement preparador = con.prepareStatement(sql);		
		ResultSet resultado = preparador.executeQuery();
		
		
		while(resultado.next()){
			AgendarAtendimento usu = new AgendarAtendimento();
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



