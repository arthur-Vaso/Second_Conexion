package br.edu.ifsp.main;

import br.edu.ifsp.model.Person;
import br.edu.ifsp.personDAO.PersonDAO;

public class Main {

	public static void main(String[] args) {

		Person p1 = new Person();
		p1.setId(2);
		p1.setName("João Pedro");
		p1.setYearOld(54);
		p1.setAdress("Rua das Flores");

		PersonDAO dao = new PersonDAO();
		//persist
		p1 = dao.savePerson(p1);
		System.out.println(p1.getId() + " -" + p1.getName() + " -" + p1.getYearOld() + " -" + p1.getAdress());
		
		p1.setName("Carlos");
		p1.setYearOld(60);
		p1.setAdress("Rua da Vossa Ovelina");
		//merge
		p1 = dao.savePerson(p1);
		System.out.println(p1.getId() + " -" + p1.getName() + " -" + p1.getYearOld() + " -" + p1.getAdress());
		
		//find
		Person p2 = dao.fetchPersonById(2);
		System.out.println(p2.getId() + " -" + p2.getName() + " -" + p2.getYearOld() + " -" + p2.getAdress());
		dao.removePerson(p2.getId());
	}

}
