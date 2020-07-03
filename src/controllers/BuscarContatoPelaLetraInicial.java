package controllers;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Contato;

public class BuscarContatoPelaLetraInicial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("PESQUISAR..");
		System.out.println("INFORME A LETRA INCIAL DO CONTATO QUE DESEJA PROCURAR:");
		String inicialNome = sc.nextLine();
		
		String sql = "SELECT CONTATO FROM Contato AS CONTATO WHERE NOME LIKE '" + inicialNome + "%'";
		
		Query query = manager.createQuery(sql);
		
		List<Contato> contatos = query.getResultList();
		
		System.out.println("\n=== CONTATOS ===");
		for (Contato contato : contatos) {
			System.out.println(contato.toString());
		}
		
		
		manager.close();
		sc.close();
	}

}
