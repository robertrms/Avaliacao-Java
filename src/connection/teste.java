package connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class teste {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos");
		factory.close();
	}
}
