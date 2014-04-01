package produtos;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.programandojava.entity.Foto;
import com.programandojava.entity.Produto;

public class InsertTest implements Serializable {
	private static final long serialVersionUID = 2866941803816833788L;

	private int counter = 0;
	
	public static void main(String[] args) {
		System.out.println("Teste");
		
		new InsertTest().createProducts(5);
	}
	
	public void createProducts(int amount){
		EntityManager entityManager = Persistence.createEntityManagerFactory("produtos").createEntityManager();
		
		while(this.counter < amount){
			Produto produto = new Produto();
			
			produto.setNome("Teste | " + counter);
			produto.setFoto(new Foto("Teste | " + counter));
			
			entityManager.getTransaction().begin();
			
			entityManager.merge(produto);
			
			entityManager.getTransaction().commit();
			
			counter++;
		}
		
		entityManager.close();
	}
}