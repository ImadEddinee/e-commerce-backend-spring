package ma.uca.ensas.ecommercebackendspring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uca.ensas.ecommercebackendspring.dto.UserDto;
import ma.uca.ensas.ecommercebackendspring.entities.User;

import ma.uca.ensas.ecommercebackendspring.mapper.UserMapper;
import ma.uca.ensas.ecommercebackendspring.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Loading user : {}",username);
        User user = userRepository.findByUsername(username) // TODO : Add Custom Exceptions
                .orElseThrow(() -> new IllegalStateException("user doesn't exists"));
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(),user.getPassword(),user.getAuthorities());
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }


    public UserDto getUserById(Long id) {
        return userMapper.userToUserDto(userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User id not found")));
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new IllegalStateException("User not found"));
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword()); // TODO : Hash Password
        user.setEmail(userDto.getEmail());
        userRepository.save(user);
    }

    public UserDto saveUser(UserDto userDto) {
        if (checkUsernameAlreadyExist(userDto.getUsername()) ||
                checkEmailAlreadyExist(userDto.getEmail())){
            throw new IllegalStateException("redendante data");
        }
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(userDto)));
    }

    private boolean checkUsernameAlreadyExist(String username){
        return userRepository.findByUsername(username).isPresent();
    }

    private boolean checkEmailAlreadyExist(String email){
        return userRepository.findByEmail(email).isPresent();
    }

}
