package controllers;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Contato;

public class ExcluirContato {
	public static void main(String[] args) {
		Contato contato = new Contato();
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("AGENDA CONTATO!");
		
		System.out.println("ID DO CONTATO QUE DESEJA EXCLUIR: ");
		String id = sc.nextLine();
		
		contato.setId(Long.parseLong(id));
		
		contato = manager.find(Contato.class, contato.getId());
		
		manager.getTransaction().begin();
		manager.remove(contato);
		manager.getTransaction().commit();
		
		System.out.println("Contato excluido com sucesso!");
		
		manager.close();
		sc.close();
	}
}
