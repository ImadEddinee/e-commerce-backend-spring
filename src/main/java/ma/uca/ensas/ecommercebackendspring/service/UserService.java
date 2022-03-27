package ma.uca.ensas.ecommercebackendspring.service;

import ma.uca.ensas.ecommercebackendspring.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers(); // TODO : change list with a page

}
