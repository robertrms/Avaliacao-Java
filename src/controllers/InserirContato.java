package controllers;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Contato;

public class InserirContato {
	public static void main(String[] args) {
		Contato contato = new Contato();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("CADASTRO CONTATO\n");
		
		System.out.println("NOME CONTATO: ");
		String nome = sc.nextLine();
		
		System.out.println("NUMERO TELEFONE: ");
		String tel = sc.nextLine();
		
		System.out.println("NUMERO CELULAR: ");
		String cel = sc.nextLine();
		
		contato.setNome(nome);
		contato.setTel(tel);
		contato.setCel(cel);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(contato);
		manager.getTransaction().commit();

		System.out.println("Dados do contato foi cadastrado com sucesso!");

		manager.close();
		sc.close();
	}
}
