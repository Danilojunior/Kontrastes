package fafica.pi.projeto.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fafica.pi.projeto.entidades.Cliente;
import fafica.pi.projeto.entidades.Usuario_ADM;

public class Usuario_Adm_Dao {
	
	private Connection con = Conexao.getConnection();
	
	public void cadastrar(Usuario_ADM usuario_adm){
		
String sql = "insert into usuario_adm (nome,nomesalao, endereco, telefone, login, senha) VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1,usuario_adm.getNome());
			preparador.setString(2,usuario_adm.getNomeSalao());
			preparador.setString(3,usuario_adm.getEndereco());
			preparador.setString(4,usuario_adm.getTelefone());
			preparador.setString(5,usuario_adm.getLogin());
			preparador.setString(6,usuario_adm.getSenha());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Cadastrado");		
		} catch (SQLException e) {
			//System.out.println("Não cadastrado");
			e.printStackTrace();
		}
	}
		public void alterar(Usuario_ADM usuario_adm){
			
			String sql = "update usuario_adm set nome=?, nomeSalao=?, endereco=?, telefone=?, login=?, senha=? where id_UsuarioAdm =?";
					try {
						PreparedStatement preparador = con.prepareStatement(sql);
						preparador.setString(1,usuario_adm.getNome());
						preparador.setString(2,usuario_adm.getNomeSalao());
						preparador.setString(3,usuario_adm.getEndereco());
						preparador.setString(4,usuario_adm.getTelefone());
						preparador.setString(5,usuario_adm.getLogin());
						preparador.setString(6,usuario_adm.getSenha());
						
						preparador.execute();
						preparador.close();
						
						
						System.out.println("ALTERADO COM SUCESSO!");
					} catch (SQLException e) {
					
						e.printStackTrace();
		}
						
	}
			public void excluir(Usuario_ADM usuario_adm){
			
			String sql = "delete from usuario_adm where id_UsuarioAdm =?";
					
					try {
						PreparedStatement preparador = con.prepareStatement(sql);
						
						preparador.setInt(1, usuario_adm.getId_UsuarioAdm());
						
									
						preparador.execute();
						preparador.close();
						System.out.println("EXCLUIDO COM SUCESSO!");
					} catch (SQLException e) {
					
						e.printStackTrace();
					}		
					
			}
			public ArrayList<Usuario_ADM> listarTodos(){
				
				String sql = "select * from usuario_adm";
				//Constroe o PreparedStatement passando o sql
				ArrayList<Usuario_ADM> lista = new ArrayList<>();
				try {
					
					PreparedStatement preparador = con.prepareStatement(sql);
				
					ResultSet resultado= preparador.executeQuery();
					
					
					while(resultado.next()){
						Usuario_ADM usuario_ADM = new Usuario_ADM();
						
						 
						usuario_ADM.setId_UsuarioAdm(resultado.getInt("id_UsuarioAdm"));//Pega o valor da coluna
						usuario_ADM.setNome(resultado.getString("nome"));
						usuario_ADM.setNomeSalao(resultado.getString("nomeSalao"));
						usuario_ADM.setEndereco(resultado.getString("endereco"));
						usuario_ADM.setTelefone(resultado.getString("telefone"));
						usuario_ADM.setLogin(resultado.getString("login"));
						usuario_ADM.setSenha(resultado.getString("senha"));
						lista.add(usuario_ADM);
					}
					preparador.close();
					System.out.println("RETORNANDO LISTA COM SUCESSO!");
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				return lista;
				
				
				
			}

		}

						

