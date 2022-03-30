package ma.uca.ensas.ecommercebackendspring.mapper;

import ma.uca.ensas.ecommercebackendspring.dto.UserDto;
import ma.uca.ensas.ecommercebackendspring.entities.security.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper( componentModel = "spring",uses = {RoleMapper.class, AuthorityMapper.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userDtoToUser(UserDto userDto);
    UserDto userToUserDto(User user);
}
