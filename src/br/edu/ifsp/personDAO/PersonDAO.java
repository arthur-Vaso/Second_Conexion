package br.edu.ifsp.personDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifsp.model.Person;

public class PersonDAO {

	private EntityManager getEmtityManager() {
		EntityManagerFactory emf = null;
		EntityManager em = null;

		emf = Persistence.createEntityManagerFactory("databasePU");
		em = emf.createEntityManager();

		return em;
	}

	public Person savePerson(Person p) {
		EntityManager em = getEmtityManager();
		try {
			em.getTransaction().begin();

			if (p.getId() == null) {
				em.persist(p);
			} else {
				em.merge(p);
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}

		return p;
	}

	public void removePerson(Integer id) {
		EntityManager em = getEmtityManager();
		Person removed = em.find(Person.class, id);

		try {
			em.getTransaction().begin();
			em.remove(removed);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public Person fetchPersonById(Integer id) {
		EntityManager em = getEmtityManager();
		Person recovered = null;

		try {
			recovered = em.find(Person.class, id);
		} finally {
			em.close();
		}

		return recovered;
	}
}
