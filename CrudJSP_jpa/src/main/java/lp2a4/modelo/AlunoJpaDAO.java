package lp2a4.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlunoJpaDAO implements AlunoDAO {

	protected EntityManager entityManager;

    public EntityManager getEntityManager() {
     EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
     if (entityManager == null) {
       entityManager = factory.createEntityManager();
     }
     return entityManager;
    }

	@Override
	public boolean create(AlunoPOJO aluno) {
		getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(aluno);
		entityManager.getTransaction().commit();
		return true;
	}

	@Override
	public AlunoPOJO retrieve(String matricula) {
		getEntityManager();
		AlunoPOJO aluno = entityManager.find(AlunoPOJO.class, matricula);
		return aluno;
	}

	@Override
	public boolean update(AlunoPOJO aluno) {
		getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(aluno);
		entityManager.getTransaction().commit();
		return true;
	}

	@Override
	public boolean delete(String matricula) {
		getEntityManager();
		AlunoPOJO aluno = new AlunoPOJO();
		aluno.setMatricula(matricula);
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.merge(aluno));
		entityManager.getTransaction().commit();		
		return true;
	}

}
