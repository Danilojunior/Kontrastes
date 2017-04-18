package fafica.pi.projeto.entidades;

import java.sql.Date;

public class AgendarServico {
	
	private Integer id_agendamento;
	private Integer id_profissional;
	private String data;
	private Integer id_cliente;
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
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Integer getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	
	

}
