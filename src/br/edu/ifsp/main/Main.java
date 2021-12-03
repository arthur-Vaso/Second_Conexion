package br.edu.ifsp.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifsp.model.Person;

public class Main {

	public static void main(String[] args) {

		/*
		 * Criando conex�o com a base de dados a partir das configura��es da unidade de
		 * persist�ncia no persistence.xml
		 */
		/*
		 * Creating connection with database from persistence configuration unity of
		 * persistence.xml
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("databasePU");

		// Criando o gerenciador de entidade para persistir as entidades
		// Creating management unity for persistence entity
		EntityManager em = emf.createEntityManager();

		// Para persist(), merge() e remove(), usam begin() e commit() e para find() n�o
		// For persist(), merge() e remove(), they use begin() and commit(), and for
		// find() don`t

		/*
		 * Bloco de inser��o (insert block)
		 */
		// Person p1 = new Person();
		// p1.setName("Jo�o Pedro Alcantara");
		// p1.setYearOld(54);
		// p1.setAdress("Rua das Flores");

		// Abrindo uma transa��o
		// Opening one transaction
		// em.getTransaction().begin();

		// Executando opera��o com o objeto na base de dados
		// Executing an operation with object in database

		// Inserindo entidade na base de dados
		// Inserting an entity in database
		// em.persist(p1);

		// Executar a transa��o
		// Executing the transaction
		// em.getTransaction().commit();

		/*
		 * Bloco de busca (Fetch block)
		 */
		// Person p1 = new Person();
		// p1.setId(1); p1.setName("Jo�o Pedro Alcantara");
		// p1.setYearOld(54);
		// p1.setAdress("Rua das Flores");

		// Buscar a entidade na base de dados
		// Fetch an entity in database
		// Person p1 = em.find(Person.class, 1);

		/*
		 * Bloco para atualizar (Actualization block)
		 */
		// Opening one transaction
		// em.getTransaction().begin();
		// Atualizar entidade na base de dados
		// Update an entity in database
		// em.merge(p1);
		// em.getTransaction().commit();

		/*
		 * Bloco para exclus�o (Deleting block)
		 */
		// Person p1 = new Person();
		// p1.SetId(1);
		// p1.setName("Jo�o Pedro Alcantara");
		// p1.setYearOld(54);
		// p1.setAdress("Rua das Flores");

		// Usado para a opera��o de exclus�o
		// Used for delete operation
		Person p1 = em.find(Person.class, 1);

		em.getTransaction().begin();
		// Excluir uma entidade
		// Remove an entity from database
		em.remove(p1);
		em.getTransaction().commit();
		System.out.println("Nome pessoa: " + p1.getName());

		// Fechando o gerenciador de entidade
		// Closing the entity management
		em.close();

		// fechando a conex�o
		// Closing connection
		emf.close();

	}

}
