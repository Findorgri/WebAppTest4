package pl.edu.agh.wat.domain.service;

import pl.edu.agh.wat.domain.model.Product;

/**
 * Service for product
 */


public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}