package ma.uca.ensas.ecommercebackendspring.service;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.dto.ProductExperienceDto;
import ma.uca.ensas.ecommercebackendspring.exceptions.ApiRequestException;
import ma.uca.ensas.ecommercebackendspring.mapper.ProductExpMapper;
import ma.uca.ensas.ecommercebackendspring.repositories.ProductExperienceRepository;
import ma.uca.ensas.ecommercebackendspring.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductExperienceService {

    private final ProductExperienceRepository productExpRepository;
    private final ProductExpMapper productExpMapper;
    private final ProductRepository productRepository;

    public List<ProductExperienceDto> getAllProductExperience(){
        return productExpMapper.productsExpToProductsExpDtos(productExpRepository.findAll());
    }

    public ProductExperienceDto saveProductExperience(ProductExperienceDto productExperienceDto) {
        if (productRepository.findById(productExperienceDto.getProductId()).isEmpty()){
            throw new ApiRequestException("The product with id : " + productExperienceDto.getProductId() + " doesn't exists");
        }
        return productExpMapper
                .productExpToProductExpDto(productExpRepository
                        .save(productExpMapper.productExpDtoToProductExp(productExperienceDto)));
    }

    public void deleteProductExperienceById(Long id){
        if (productExpRepository.findById(id).isEmpty()){
            throw new ApiRequestException("Product Experience id : " + id + " doesn't exists");
        }
        productExpRepository.deleteById(id);
    }
}
