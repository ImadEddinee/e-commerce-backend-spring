package ma.uca.ensas.ecommercebackendspring.controller;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.dto.MerchantDto;
import ma.uca.ensas.ecommercebackendspring.entities.Merchant;
import ma.uca.ensas.ecommercebackendspring.service.MerchantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/merchants")
public class MerchantController {

    private final MerchantService merchantService;

    @GetMapping
    public ResponseEntity<List<MerchantDto>> getAllMerchants(){
        return new ResponseEntity<>(merchantService.getAllMerchant(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MerchantDto> saveMerchant(@RequestBody @Valid MerchantDto merchantDto){
        return new ResponseEntity<>(merchantService.saveMerchant(merchantDto), HttpStatus.OK);
    }

}
