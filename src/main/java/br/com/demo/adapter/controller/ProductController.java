package br.com.demo.adapter.controller;

import br.com.demo.models.Product;
import br.com.demo.models.request.ProductRequiredDTO;
import br.com.demo.models.response.ProductResponseDTO;
import br.com.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> getProducts(){ return repository.findAll();}

    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@PathVariable Long id){
        ProductRequiredDTO productRequiredDTO = new ProductRequiredDTO(id);
        var product = repository.findById(productRequiredDTO.getId()).orElse(null);
        ProductResponseDTO productResponseDTO = new ProductResponseDTO(
                product.getId(), product.getName(), product.getPrice()
        );
        return productResponseDTO;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return repository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        repository.deleteById(id);
    }
}
