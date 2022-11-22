package program;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Aluno;
import entities.AlunoDisciplina;
import entities.Disciplina;

public class Application {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("test");
		EntityManager em = emfactory.createEntityManager();

		Aluno aluno1 = new Aluno();
		aluno1.setMatricula("SP12345");
		aluno1.setNome("Tomas");
		aluno1.setEndereco("Rua 1");
		aluno1.setDataConclusao("2022-10-10");
		aluno1.setDataIngresso("2020-10-10");
		
		Aluno aluno2 = new Aluno();
		aluno2.setMatricula("SP5678");
		aluno2.setNome("Ana Clara");
		aluno2.setEndereco("Rua 2");
		aluno2.setDataConclusao("2022-09-05");
		aluno2.setDataIngresso("2020-08-10");
		
		Disciplina disc = new Disciplina();
		disc.setCodigo("123");
		disc.setNome("Linguagem de Programação 2");

		AlunoDisciplina notaAluno1 = new AlunoDisciplina();
		notaAluno1.setAluno(aluno1);
		notaAluno1.setDisciplina(disc);
		notaAluno1.setNota(8);
		
		AlunoDisciplina notaAluno2 = new AlunoDisciplina();
		notaAluno2.setAluno(aluno2);
		notaAluno2.setDisciplina(disc);
		notaAluno2.setNota(8);
		
		em.getTransaction().begin();

		em.persist(aluno1);
		em.persist(aluno2);
		em.persist(disc);
		em.persist(notaAluno1);
		em.persist(notaAluno2);


		em.getTransaction().commit();

		
		List<AlunoDisciplina> findNotas = em.createQuery("FROM AlunoDisciplina", AlunoDisciplina.class).getResultList();
		System.out.println(findNotas);
	}

}
