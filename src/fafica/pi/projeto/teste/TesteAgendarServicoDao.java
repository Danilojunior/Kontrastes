package fafica.pi.projeto.teste;

import fafica.pi.projeto.entidades.AgendarServico;
import fafica.pi.projeto.jdbc.AgendarServicoDao;

public class TesteAgendarServicoDao {

	public static void main(String[] args) {
		
		AgendarServico agenda = new AgendarServico();
		
		agenda.setData("23/09/2016");
		
		
		AgendarServicoDao agendaDao = new AgendarServicoDao();
		agendaDao.cadastrar(agenda);
	}

}
