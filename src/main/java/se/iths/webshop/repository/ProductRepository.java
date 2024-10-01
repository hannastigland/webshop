package se.iths.webshop.repository;

import org.springframework.data.repository.ListCrudRepository;
import se.iths.webshop.entity.Product;

public interface ProductRepository extends ListCrudRepository<Product, Long> {

}
