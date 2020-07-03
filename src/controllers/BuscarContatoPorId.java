package controllers;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import modelo.Contato;

public class BuscarContatoPorId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("PESQUISAR..");
		System.out.println("INFORME O ID DO CONTATO QUE DESEJA PROCURAR:");
		String id = sc.nextLine();
		
		Contato contato = manager.find(Contato.class, Long.parseLong(id));
		System.out.println("\n=== CONTATO ===");
		System.out.println(contato.toString());
		
		manager.close();
		sc.close();
	}
}
