package fafica.pi.projeto.teste;

import fafica.pi.projeto.entidades.AgendarAtendimento;
import fafica.pi.projeto.jdbc.AgendarAtendimentoDao;


public class TesteAgendarAtendimentoDAO {

	public static void main(String[] args) {
		
		testeCadastrar();
		
	}
	
	private static void testeCadastrar() {
		AgendarAtendimento atendimento = new AgendarAtendimento();
		
		atendimento.setDataAtendimento("11/03/2018");
		atendimento.setHorarioAtendimento("12:45hs");
		atendimento.setId_cliente(1);
		atendimento.setId_profissional(12);
	
		AgendarAtendimentoDao at = new AgendarAtendimentoDao();
		at.cadastrar(atendimento);
		
	}

}
