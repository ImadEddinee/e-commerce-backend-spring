package ma.uca.ensas.ecommercebackendspring.controller;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.dto.AuthenticationRequestDto;
import ma.uca.ensas.ecommercebackendspring.dto.UserDto;
import ma.uca.ensas.ecommercebackendspring.service.AuthenticationService;
import ma.uca.ensas.ecommercebackendspring.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/authenticate")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody @Valid UserDto userDto){
        return new ResponseEntity<>(authenticationService.signUp(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/confirm/{token}")
    public ResponseEntity<String> confirmAccount(@PathVariable("token") String token){
        userService.enableAccount(token);
        return new ResponseEntity<>("Account Activated",HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login( @RequestBody AuthenticationRequestDto requestDto){
        return new ResponseEntity<>(authenticationService.login(requestDto),HttpStatus.OK);
    }
}
