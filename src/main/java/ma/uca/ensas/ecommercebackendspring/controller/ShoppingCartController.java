package ma.uca.ensas.ecommercebackendspring.controller;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.entities.ShoppingCart;
import ma.uca.ensas.ecommercebackendspring.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/shoppingCart")
@RequiredArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @GetMapping
    public List<ShoppingCart> getAllShoppingCart(){
        return shoppingCartService.getAllShoppingCart();
    }

    @PostMapping
    public ShoppingCart saveShoppingCart(@RequestBody ShoppingCart shoppingCart){
        return shoppingCartService.saveShoppingCart(shoppingCart);
    }

    @DeleteMapping("/{id}")
    public void deleteShoppingCart(@PathVariable("id") Long id){
        shoppingCartService.deleteShoppingCartById(id) ;
    }
}
