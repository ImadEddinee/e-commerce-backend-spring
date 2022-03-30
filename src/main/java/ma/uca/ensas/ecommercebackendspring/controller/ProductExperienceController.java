package ma.uca.ensas.ecommercebackendspring.controller;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.entities.ProductExperience;
import ma.uca.ensas.ecommercebackendspring.service.ProductExperienceService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/v1/productExperience")
@RequiredArgsConstructor
public class ProductExperienceController {

    private final ProductExperienceService productExperienceService;

    @GetMapping
    public List<ProductExperience> getAllProductExperience(){
        return productExperienceService.getAllProductExperience();
    }

    @PostMapping
    public ProductExperience saveProductExperience(@RequestBody @Valid ProductExperience productExperience){
        return productExperienceService.saveProductExperience(productExperience);
    }

    @DeleteMapping("/{id}")
    public void deleteProductExperience(@PathVariable("id") Long id){
        productExperienceService.deleteProductExperienceById(id);
    }
}
