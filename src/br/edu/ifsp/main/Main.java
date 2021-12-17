package br.edu.ifsp.main;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.model.Person;
import br.edu.ifsp.model.Pets;
import br.edu.ifsp.model.Vehicle;
import br.edu.ifsp.personDAO.PersonDAO;

public class Main {

	public static void main(String[] args) {

		Person p1 = new Person();
		p1.setName("João");
		p1.setYearOld(12);
		p1.setAdress("Rua das");
		
		Vehicle v = new Vehicle();
		v.setType("Carro Fusca");
		v.setPerson(p1);
		
		p1.setVehicle(v);
		
		Pets a1 = new Pets();
		a1.setPetName("Totó");
		a1.setPetType("Cão");
		a1.setPerson(p1);
		Pets a2 = new Pets();
		a2.setPetName("Bichano");
		a2.setPetType("Gato");
		a2.setPerson(p1);
				
		List<Pets> lisPet = new ArrayList<Pets>();
		lisPet.add(a1);
		lisPet.add(a2);

		p1.setListPets(lisPet);
		
		PersonDAO dao = new PersonDAO();
		//persist
		p1 = dao.savePerson(p1);
		//System.out.println(p1.getId() + " -" + p1.getName() + " -" + p1.getYearOld() + " -" + p1.getAdress());
		/*
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
		*/
	}

}
