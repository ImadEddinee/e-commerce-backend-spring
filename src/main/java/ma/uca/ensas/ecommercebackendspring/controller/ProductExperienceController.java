package ma.uca.ensas.ecommercebackendspring.controller;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.dto.ProductExperienceDto;
import ma.uca.ensas.ecommercebackendspring.entities.ProductExperience;
import ma.uca.ensas.ecommercebackendspring.service.ProductExperienceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/v1/productExperiences")
@RequiredArgsConstructor
public class ProductExperienceController {

    private final ProductExperienceService productExperienceService;

    @GetMapping
    public ResponseEntity<List<ProductExperienceDto>> getAllProductExperience(){
        return new ResponseEntity<>(productExperienceService.getAllProductExperience(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductExperienceDto> saveProductExperience(@RequestBody @Valid ProductExperienceDto productExperienceDto){
        return new ResponseEntity<>(productExperienceService.saveProductExperience(productExperienceDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductExperience(@PathVariable("id") Long id){
        productExperienceService.deleteProductExperienceById(id);
    }
}
