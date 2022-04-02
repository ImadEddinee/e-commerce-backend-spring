package ma.uca.ensas.ecommercebackendspring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uca.ensas.ecommercebackendspring.dto.RoleDto;
import ma.uca.ensas.ecommercebackendspring.dto.UserDto;
import ma.uca.ensas.ecommercebackendspring.entities.VerificationToken;
import ma.uca.ensas.ecommercebackendspring.entities.security.User;
import ma.uca.ensas.ecommercebackendspring.mapper.UserMapper;
import ma.uca.ensas.ecommercebackendspring.repositories.UserRepository;
import ma.uca.ensas.ecommercebackendspring.repositories.VerificationTokenRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository verificationTokenRepository;

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
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword()); // TODO : Hash Password
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setAddress(userDto.getAddress());
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

    public void enableAccount(String token){
        VerificationToken verificationToken = verificationTokenRepository
                .findByToken(token)
                .orElseThrow(()->new IllegalStateException("Invalid token"));
        User user = userRepository.findByUsername(verificationToken.getUser().getUsername())
                .orElseThrow(()->new IllegalStateException("user doenst exists"));
        user.setEnabled(true);
        userRepository.save(user);
    }
}
