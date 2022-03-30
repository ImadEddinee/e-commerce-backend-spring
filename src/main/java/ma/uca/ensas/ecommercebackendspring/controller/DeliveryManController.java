package ma.uca.ensas.ecommercebackendspring.controller;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.entities.DeliveryMan;
import ma.uca.ensas.ecommercebackendspring.repositories.DeliveryManRepository;
import ma.uca.ensas.ecommercebackendspring.service.DeliveryManService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/deliveryMen")
@RequiredArgsConstructor
public class DeliveryManController {

    private final DeliveryManService deliveryManService;

    @GetMapping
    public List<DeliveryMan> getAllDeliveryMen() {
        return deliveryManService.getAllDeliveryMen();
    }

    @PostMapping
    public DeliveryMan saveDeliveryMan(@RequestBody @Valid DeliveryMan deliveryMan) {
        return deliveryManService.saveDeliveryMan(deliveryMan);
    }

    @DeleteMapping("/{id}")
    public void deleteDeliveryMan(@PathVariable("id") Long id){
        deliveryManService.deleteDeliveryManById(id);
    }
}
