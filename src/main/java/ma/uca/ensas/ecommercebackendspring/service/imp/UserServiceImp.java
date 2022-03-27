package ma.uca.ensas.ecommercebackendspring.service.imp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uca.ensas.ecommercebackendspring.dto.UserDto;
import ma.uca.ensas.ecommercebackendspring.entities.security.User;
import ma.uca.ensas.ecommercebackendspring.repositories.UserRepository;
import ma.uca.ensas.ecommercebackendspring.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserServiceImp implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username) // TODO : Add Custom Exceptions
                .orElseThrow(() -> new IllegalStateException("user doesn't exists"));
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(),user.getPassword(),user.getAuthorities());
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }
}
