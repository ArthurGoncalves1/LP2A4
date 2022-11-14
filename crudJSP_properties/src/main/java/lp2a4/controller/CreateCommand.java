package lp2a4.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lp2a4.modelo.AlunoDAO;
import lp2a4.modelo.AlunoPOJO;

public class CreateCommand implements Command {
	public CreateCommand() {
		System.out.println("Comando Criado");
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Método execute Create");
		
		final AlunoPOJO aluno = ControllerUtil.transform(request); // tranforma os dados do request em uma instancia aluno
		
		final AlunoDAO dao = AlunoDAO.getInstance();
		
		if ( dao.create(aluno) ) {
			response.getWriter().append("Aluno foi incluido com sucesso!!!");
		} else {
			response.getWriter().append("Inclusão não funcionou!!!");			
		}
	}

}
