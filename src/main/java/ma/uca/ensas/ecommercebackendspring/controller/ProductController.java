package ma.uca.ensas.ecommercebackendspring.controller;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.entities.Product;
import ma.uca.ensas.ecommercebackendspring.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProductById(id);
    }
}
