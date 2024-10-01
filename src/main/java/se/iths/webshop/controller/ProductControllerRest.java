package se.iths.webshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.webshop.entity.Product;
import se.iths.webshop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductControllerRest {

    ProductRepository productRepository;

    public ProductControllerRest(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Create product
    @PostMapping("/product")
    ResponseEntity<Void> createProduct(@RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    //Read product
    @GetMapping("/product")
    List<Product> productList() {
        return productRepository.findAll();
    }

    //Read product by ID
    @GetMapping("/product/{id}")
    Optional product(@PathVariable("id") Long id) {
        return productRepository.findById(id);
    }

    //Delete product
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
    }

    //Change product
    @PatchMapping("/product/{id}")
    ResponseEntity<Void> updateProduct(@RequestBody Product updatedProduct, @PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();

            // Update the existing user's fields with the data from the updatedUser object
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setStockQuantity(updatedProduct.getStockQuantity());
            existingProduct.setImageUrl(updatedProduct.getImageUrl());
            existingProduct.setDiscountPrice(updatedProduct.getDiscountPrice());

            productRepository.save(existingProduct);

            return ResponseEntity.ok().build();
        } else {
            // If the user with the given ID does not exist, return a response with HTTP status code 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }


}
