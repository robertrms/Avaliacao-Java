package controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Contato;

public class BuscarTodosOsContatos {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos");
		EntityManager manager = factory.createEntityManager();
		
		String sql = "select contato from Contato as contato";
		
		Query query = manager.createQuery(sql);
		
		List<Contato> contatos = query.getResultList();
		
		System.out.println("\n=== LISTA DE CONTATOS ===");
		for (Contato contato : contatos) {
			System.out.println(contato.toString());
		}
		
		manager.close();
	}
}
