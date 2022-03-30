package ma.uca.ensas.ecommercebackendspring.service;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.entities.DeliveryMan;
import ma.uca.ensas.ecommercebackendspring.repositories.DeliveryManRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryManService {

    private DeliveryManRepository deliveryManRepository;

    public DeliveryMan saveDeliveryMan(DeliveryMan deliveryMan){
        return deliveryManRepository.save(deliveryMan);
    }

    public List<DeliveryMan> getAllDeliveryMen(){
        return deliveryManRepository.findAll();
    }

    public void deleteDeliveryManById(Long id){
        deliveryManRepository.deleteById(id);
    }
}
