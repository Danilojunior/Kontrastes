package fafica.pi.projeto.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fafica.pi.projeto.entidades.Profissional;

public class ProfissionalDao {
	
private Connection con = Conexao.getConnection();
	
	public void cadastrar(Profissional profissional){
		
String sql = "insert into profissional (nome,especialidade) VALUES(?, ?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1,profissional.getNome());
			preparador.setString(2,profissional.getEspecialidade());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Cadastrado");		
		} catch (SQLException e) {
			//System.out.println("Não cadastrado");
			e.printStackTrace();
		}
	}
		public void alterar(Profissional profissional){
			
			String sql = "update usuario_adm set nome=?, nomeSalao=?, endereco=?, telefone=?, login=?, senha=? where id_UsuarioAdm =?";
					try {
						PreparedStatement preparador = con.prepareStatement(sql);
						preparador.setString(1,profissional.getNome());
						preparador.setString(2,profissional.getEspecialidade());
						
						preparador.execute();
						preparador.close();
						
						
						System.out.println("ALTERADO COM SUCESSO!");
					} catch (SQLException e) {
					
						e.printStackTrace();
		}
						
	}
			public void excluir(Profissional profissional){
			
			String sql = "delete from usuario_adm where id_UsuarioAdm =?";
					
					try {
						PreparedStatement preparador = con.prepareStatement(sql);
						
						preparador.setInt(1, profissional.getId_profissional());
						
									
						preparador.execute();
						preparador.close();
						System.out.println("EXCLUIDO COM SUCESSO!");
					} catch (SQLException e) {
					
						e.printStackTrace();
					}		
					
			}
			public ArrayList<Profissional> listarTodos(){
				
				String sql = "select * from usuario_adm";
				ArrayList<Profissional> lista = new ArrayList<>();
				try {
					
					PreparedStatement preparador = con.prepareStatement(sql);
				
					ResultSet resultado= preparador.executeQuery();
					
					
					while(resultado.next()){
						Profissional profis = new Profissional();
								
						 
						profis.setId_profissional(resultado.getInt("id_profissional"));
						profis.setNome(resultado.getString("nome"));
						profis.setEspecialidade(resultado.getString("especialidade"));
						lista.add(profis);
					}
					preparador.close();
					System.out.println("RETORNANDO LISTA COM SUCESSO!");
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				return lista;
				
				
				
			

		}

						

}
