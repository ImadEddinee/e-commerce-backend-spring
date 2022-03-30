package ma.uca.ensas.ecommercebackendspring.service;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.entities.ProductExperience;
import ma.uca.ensas.ecommercebackendspring.repositories.ProductExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductExperienceService {

    private final ProductExperienceRepository productExperienceRepository;

    public List<ProductExperience> getAllProductExperience(){
        return productExperienceRepository.findAll();
    }

    public ProductExperience saveProductExperience(ProductExperience productExperience){
        return productExperienceRepository.save(productExperience);
    }

    public void deleteProductExperienceById(Long id){
        productExperienceRepository.deleteById(id);
    }
}
