package fafica.pi.projeto.teste;

import fafica.pi.projeto.entidades.Profissional;
import fafica.pi.projeto.jdbc.ProfissionalDao;

public class TestaProfissionarioDao {

	public static void main(String[] args) {

		Profissional profis = new Profissional();
		profis.setNome("Bruno");
		profis.setEspecialidade("Manicure");
		
		ProfissionalDao pro = new ProfissionalDao();
		pro.cadastrar(profis);
		pro.listarTodos();
		
		
	}

}
