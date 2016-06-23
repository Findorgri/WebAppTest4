package pl.edu.agh.wat.repository;

/**
 * Created by User on 2016-06-04.
 */


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.edu.agh.wat.configuration.RepositoryConfiguration;
import pl.edu.agh.wat.domain.model.Product;
import pl.edu.agh.wat.domain.repository.ProductRepository;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})

public class ProductRepositoryTest {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Test
    public void testSaveProduct(){
        //setup product
        Product product = new Product();
        product.setDescription("Wat Class Shirt");
        product.setPrice(new BigDecimal("18.95"));
        product.setProductId("12345");

        //save product, verify has ID value after save
        assertNull(product.getId()); //null before save
        productRepository.save(product);
        assertNotNull(product.getId()); //not null after save

        //fetch from DB
        Product fetchedProduct = productRepository.findOne(product.getId());

        //should not be null
        assertNotNull(fetchedProduct);

        //should equal
        assertEquals(product.getId(), fetchedProduct.getId());
        assertEquals(product.getDescription(), fetchedProduct.getDescription());

        //update description and save
        fetchedProduct.setDescription("New Description");
        productRepository.save(fetchedProduct);

        //get from DB, should be updated
        Product fetchedUpdatedProduct = productRepository.findOne(fetchedProduct.getId());
        assertEquals(fetchedProduct.getDescription(), fetchedUpdatedProduct.getDescription());

        //verify count of products in DB
        long productCount = productRepository.count();
        assertEquals(productCount, 1);

        //get all products, list should only have one
        Iterable<Product> products = productRepository.findAll();

        int count = 0;

        for(Product p : products){
            count++;
        }

        assertEquals(count, 1);
    }
}