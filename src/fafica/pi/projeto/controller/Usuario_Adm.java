package fafica.pi.projeto.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fafica.pi.projeto.entidades.*;
import fafica.pi.projeto.jdbc.Usuario_Adm_Dao;


@WebServlet("/usuadm")
public class Usuario_Adm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Usuario_Adm() {
        super();
       
    
    }
//Telefone de Ivan - (81)99413-0177
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			System.out.println("Chamando doGet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Chamando doPOST");
		
		String nome= request.getParameter("txtnome");
		String login= request.getParameter("txtlogin");
		String senha= request.getParameter("txtsenha");
		
		Usuario_ADM usu = new Usuario_ADM();
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);
		
		
		Usuario_Adm_Dao usuario = new Usuario_Adm_Dao();
		usuario.cadastrar(usu);
		
		PrintWriter saida = response.getWriter();
		saida.print("Cadastrado com sucesso");
		
		
		
	
		
		
	
	}

}
