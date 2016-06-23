package pl.edu.agh.wat.domain.repository;

/**
 * Created by User on 2016-06-04.
 */

import org.springframework.data.repository.CrudRepository;
import pl.edu.agh.wat.domain.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
}