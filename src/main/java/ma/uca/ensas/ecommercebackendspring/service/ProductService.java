package ma.uca.ensas.ecommercebackendspring.service;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.entities.Product;
import ma.uca.ensas.ecommercebackendspring.exceptions.ApiRequestException;
import ma.uca.ensas.ecommercebackendspring.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProductById(Long id){
        if (productRepository.findById(id).isEmpty()){
            throw new ApiRequestException("Product with id : " + id + " doesn't exists");
        }
        productRepository.deleteById(id);
    }
}
