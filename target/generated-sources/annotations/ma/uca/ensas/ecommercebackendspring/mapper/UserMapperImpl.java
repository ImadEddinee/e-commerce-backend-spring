package ma.uca.ensas.ecommercebackendspring.mapper;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import ma.uca.ensas.ecommercebackendspring.dto.RoleDto;
import ma.uca.ensas.ecommercebackendspring.dto.UserDto;
import ma.uca.ensas.ecommercebackendspring.dto.UserDto.UserDtoBuilder;
import ma.uca.ensas.ecommercebackendspring.entities.Role;
import ma.uca.ensas.ecommercebackendspring.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-05T18:58:53+0000",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setUsername( userDto.getUsername() );
        user.setPassword( userDto.getPassword() );
        user.setFirstname( userDto.getFirstname() );
        user.setLastname( userDto.getLastname() );
        user.setEmail( userDto.getEmail() );
        user.setPhone( userDto.getPhone() );
        user.setAddress( userDto.getAddress() );
        user.setRoles( roleDtoSetToRoleSet( userDto.getRoles() ) );
        user.setEnabled( userDto.isEnabled() );

        return user;
    }

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDtoBuilder userDto = UserDto.builder();

        userDto.id( user.getId() );
        userDto.username( user.getUsername() );
        userDto.password( user.getPassword() );
        userDto.firstname( user.getFirstname() );
        userDto.lastname( user.getLastname() );
        userDto.email( user.getEmail() );
        userDto.phone( user.getPhone() );
        userDto.address( user.getAddress() );
        userDto.enabled( user.isEnabled() );
        userDto.roles( roleSetToRoleDtoSet( user.getRoles() ) );

        return userDto.build();
    }

    protected Set<Role> roleDtoSetToRoleSet(Set<RoleDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Role> set1 = new HashSet<Role>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleDto roleDto : set ) {
            set1.add( roleMapper.roleDtoToRole( roleDto ) );
        }

        return set1;
    }

    protected Set<RoleDto> roleSetToRoleDtoSet(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleDto> set1 = new HashSet<RoleDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role role : set ) {
            set1.add( roleMapper.roleToRoleDto( role ) );
        }

        return set1;
    }
}
