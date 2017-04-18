package fafica.pi.projeto.teste;

import fafica.pi.projeto.entidades.Usuario_ADM;
import fafica.pi.projeto.jdbc.Usuario_Adm_Dao;

public class TesteUsuarioAdmDao {

	public static void main(String[] args) {
	
		
		Usuario_ADM adm = new Usuario_ADM();
		adm.setNome("Luciana");
		adm.setNomeSalao("Moda");
		adm.setEndereco("Rua Escada");
		adm.setTelefone("(81)3741-0987");
		adm.setLogin("erernn98");
		adm.setSenha("09871rre");
		
		
		Usuario_Adm_Dao usu = new Usuario_Adm_Dao();
		usu.cadastrar(adm);
	}

}
