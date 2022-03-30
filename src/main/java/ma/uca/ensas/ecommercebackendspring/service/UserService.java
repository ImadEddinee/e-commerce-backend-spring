package ma.uca.ensas.ecommercebackendspring.service;


import ma.uca.ensas.ecommercebackendspring.dto.RoleDto;
import ma.uca.ensas.ecommercebackendspring.dto.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    List<UserDto> getAllUsers(); // TODO : change list with a page
    UserDto getUserById(Long id);
    void deleteUserById(Long id);
    void updateUser(UserDto userDto);
    UserDto saveUser(UserDto userDto);
    Set<RoleDto> getUserRolesById(Long id);
    void addRolesToUser(Long id,Set<RoleDto> roles);
    Optional<UserDto> findUserByUsername(String username);
}
