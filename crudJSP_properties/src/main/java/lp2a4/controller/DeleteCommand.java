package lp2a4.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lp2a4.Logger;
import lp2a4.modelo.AlunoDAO;

public class DeleteCommand implements Command {
	
	private static Logger log = new Logger(Command.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final AlunoDAO dao = AlunoDAO.getInstance();

		if ( dao.delete(request.getParameter("matricula")) ) {
			response.getWriter().append("Aluno removido com sucesso!");
			log.info("Aluno removido com sucesso!");
		} else {
			response.getWriter().append("Remoção não funcionou!");	
			log.error("Remoção não funcionou!");
		}
	}

}
