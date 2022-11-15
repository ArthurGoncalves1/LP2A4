package application;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Veiculo;

public class Aplicacao {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("1) Iniciar aplicação com problema do N+1");
		System.out.println("2) Iniciar aplicação sem problema do N+1");
		int x = sc.nextInt();

		if (x == 1) {
			nMaisUm();
		} else if (x == 2) {
			 nMaisUmResolvido();
		} else {
			System.out.println("Entrada incorreta!");
		}
		
		sc.close();
	}

	public static void nMaisUm() {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("test");

		EntityManager em = emFactory.createEntityManager();

		List<Veiculo> veiculos = em.createQuery("FROM Veiculo", Veiculo.class).getResultList();
		System.out.println(veiculos);
	}
	
	
	public static void nMaisUmResolvido() {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("test");

		EntityManager em = emFactory.createEntityManager();

		List<Veiculo> veiculos = em.createQuery("FROM Veiculo v join fetch v.proprietario", Veiculo.class).getResultList();
		System.out.println(veiculos);
		
		/*EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("test");

		EntityManager em = emFactory.createEntityManager();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<Veiculo> criteriaQuery = builder.createQuery(Veiculo.class);

		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
		criteriaQuery.select(veiculo);
		
		TypedQuery<Veiculo> query = em.createQuery(criteriaQuery);
		System.out.println(query.getResultList());*/
		
	}
}
