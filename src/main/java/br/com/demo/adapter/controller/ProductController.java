package br.com.demo.adapter.controller;

import br.com.demo.models.Product;
import br.com.demo.models.request.ProductRequiredDTO;
import br.com.demo.models.response.ProductResponseDTO;
import br.com.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public Page<Product> getProducts(Pageable pageable){
        return repository.findAll(pageable);}

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
        return repository.findById(id)
                .map(product -> ResponseEntity.ok(mapResponseDTO(product)))
                .orElse(ResponseEntity.notFound().build());
    }

    private ProductResponseDTO mapResponseDTO(Product product) {
        return new ProductResponseDTO(product.getId(), product.getName(), product.getPrice());
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return repository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> putProduct(@PathVariable Long id, @RequestBody ProductResponseDTO update) {
        return repository.findById(id)
                .map(existeProduto -> {
                    existeProduto.setName(update.getName());
                    existeProduto.setPrice(update.getPrice());
                    Product saveProduct = repository.save(existeProduto);
                    return ResponseEntity.ok(mapResponseDTO(saveProduct));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
