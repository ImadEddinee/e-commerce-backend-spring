package ma.uca.ensas.ecommercebackendspring.controller;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.dto.AuthenticationRequestDto;
import ma.uca.ensas.ecommercebackendspring.dto.AuthenticationResponseDto;
import ma.uca.ensas.ecommercebackendspring.service.imp.UserServiceImp;
import ma.uca.ensas.ecommercebackendspring.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/v1/users")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserServiceImp userServiceImp;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login( @RequestBody AuthenticationRequestDto requestDto){
       try{
           authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(requestDto.getUsername(),requestDto.getPassword()));
       } catch (Exception ex) {
               ex.printStackTrace();
       }
        UserDetails userDetails = userServiceImp.loadUserByUsername(requestDto.getUsername());
       String jwt = jwtUtil.generateToken(userDetails);
       return ResponseEntity.ok(new AuthenticationResponseDto(jwt));
    }
}
