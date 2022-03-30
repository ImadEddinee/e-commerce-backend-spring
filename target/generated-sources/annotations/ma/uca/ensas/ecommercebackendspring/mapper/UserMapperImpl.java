package ma.uca.ensas.ecommercebackendspring.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import ma.uca.ensas.ecommercebackendspring.dto.RoleDto;
import ma.uca.ensas.ecommercebackendspring.dto.UserDto;
import ma.uca.ensas.ecommercebackendspring.dto.UserDto.UserDtoBuilder;
import ma.uca.ensas.ecommercebackendspring.entities.security.Role;
import ma.uca.ensas.ecommercebackendspring.entities.security.User;
import ma.uca.ensas.ecommercebackendspring.entities.security.User.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-29T17:08:02+0000",
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

        UserBuilder user = User.builder();

        user.firstname( userDto.getFirstname() );
        user.lastname( userDto.getLastname() );
        user.username( userDto.getUsername() );
        user.password( userDto.getPassword() );
        user.email( userDto.getEmail() );
        user.phone( userDto.getPhone() );
        user.address( userDto.getAddress() );
        user.roles( roleDtoSetToRoleCollection( userDto.getRoles() ) );

        return user.build();
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
        userDto.roles( roleSetToRoleDtoSet( user.getRoles() ) );

        return userDto.build();
    }

    protected Collection<Role> roleDtoSetToRoleCollection(Set<RoleDto> set) {
        if ( set == null ) {
            return null;
        }

        Collection<Role> collection = new ArrayList<Role>( set.size() );
        for ( RoleDto roleDto : set ) {
            collection.add( roleMapper.roleDtoToRole( roleDto ) );
        }

        return collection;
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
