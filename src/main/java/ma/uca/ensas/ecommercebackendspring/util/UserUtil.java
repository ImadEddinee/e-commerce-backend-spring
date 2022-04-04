package ma.uca.ensas.ecommercebackendspring.util;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.exceptions.ApiRequestException;
import ma.uca.ensas.ecommercebackendspring.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUtil {

    private final UserRepository userRepository;

    public void verifyRedundantCredentials(String email, String username){
        long usernameCount = userRepository.findAll().stream()
                .map(user -> user.getUsername().toLowerCase())
                .filter(usrname -> usrname.equals(username.toLowerCase()))
                .count();
        if (usernameCount > 0){
            throw new ApiRequestException("username : " + username + " already in use");
        }
        long emailCount = userRepository.findAll().stream()
                .map(user -> user.getEmail().toLowerCase())
                .filter(e -> e.equals(email.toLowerCase()))
                .count();
        if (emailCount > 0){
            throw new ApiRequestException("email : " + email + "already in use");
        }
    }

}
