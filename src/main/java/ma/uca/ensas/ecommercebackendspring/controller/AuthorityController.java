package ma.uca.ensas.ecommercebackendspring.controller;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.dto.AuthorityDto;
import ma.uca.ensas.ecommercebackendspring.service.AuthorityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authenticate/authorities")
public class AuthorityController {

    private final AuthorityService authorityService;

    @GetMapping
    public ResponseEntity<List<AuthorityDto>> getAllAuthorities(){
        return new ResponseEntity<>(authorityService.getAllAuthorities(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AuthorityDto> saveAuthority(@RequestBody @Valid AuthorityDto authorityDto){
        return new ResponseEntity<>(authorityService.saveAuthority(authorityDto),HttpStatus.CREATED);
    }
}
