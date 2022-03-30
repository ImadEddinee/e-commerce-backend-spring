package ma.uca.ensas.ecommercebackendspring.service;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.entities.ShoppingCart;
import ma.uca.ensas.ecommercebackendspring.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public List<ShoppingCart> getAllShoppingCart(){
        return shoppingCartRepository.findAll();
    }

    public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart){
        return shoppingCartRepository.save(shoppingCart);
    }

    public void deleteShoppingCartById(Long id){
        shoppingCartRepository.deleteById(id);
    }
}
