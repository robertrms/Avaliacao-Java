package controllers;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Contato;

public class AtualizarContato {
	public static void main(String[] args) {
		Contato contato = new Contato();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ATUALIZAÇÃO DE CONTATO");
		
		System.out.println("INFORMA O ID DO CONTATO QUE DESEJA ALTERAR:");
		String id = sc.nextLine();
		System.out.println("INFORMA UM NOVO NOME:");
		String nome = sc.nextLine();
		System.out.println("INFORME UM NOVO TEL:");
		String tel = sc.nextLine();
		System.out.println("INFORME UM NOVO CEL:");
		String cel = sc.nextLine();
		
		
		contato.setId(Long.parseLong(id));
		contato.setNome(nome);
		contato.setTel(tel);
		contato.setCel(cel);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(contato);
		manager.getTransaction().commit();
		
		System.out.println("Novos dados atualizados com sucesso!");
		
		manager.close();
		sc.close();
	}
}
