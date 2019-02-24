package springtestingfeatures.server;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import springtestingfeatures.server.configurations.D09_JpaConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {D09_JpaConfiguration.class })
@DataJpaTest
public class D09_JPA {
	
	@Autowired TestEntityManager entityManager;
	@Autowired ProductRepository productRepository;

	@Test
	public void twoProductsRetrieved_afterAddingTwo() {
		Product product1 = new Product("Brie", "France");
		Product product2 = new Product("Parmigiano", "Italy");

		entityManager.persist(product1);
		entityManager.persist(product2);
		entityManager.flush();

		List<Product> products = productRepository.findAll();
		assertEquals(2, products.size());
	}
	
}
