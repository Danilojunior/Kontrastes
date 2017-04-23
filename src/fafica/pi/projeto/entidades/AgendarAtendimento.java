package fafica.pi.projeto.entidades;

import java.sql.Date;

public class AgendarAtendimento {
	
	private Integer id_agendamento;
	private Integer id_profissional;
	private Integer id_cliente;
	private String dataAtendimento;
	private String horarioAtendimento;
	
	public String getHorarioAtendimento() {
		return horarioAtendimento;
	}
	public void setHorarioAtendimento(String horarioAtendimento) {
		this.horarioAtendimento = horarioAtendimento;
	}
	
	public Integer getId_agendamento() {
		return id_agendamento;
	}
	public void setId_agendamento(Integer id_agendamento) {
		this.id_agendamento = id_agendamento;
	}
	public Integer getId_profissional() {
		return id_profissional;
	}
	public void setId_profissional(Integer id_profissional) {
		this.id_profissional = id_profissional;
	}
	
	public String getDataAtendimento() {
		return dataAtendimento;
	}
	public void setDataAtendimento(String dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}
	public Integer getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	
	

}
