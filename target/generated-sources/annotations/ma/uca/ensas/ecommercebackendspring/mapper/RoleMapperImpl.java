package ma.uca.ensas.ecommercebackendspring.mapper;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import ma.uca.ensas.ecommercebackendspring.dto.AuthorityDto;
import ma.uca.ensas.ecommercebackendspring.dto.AuthorityDto.AuthorityDtoBuilder;
import ma.uca.ensas.ecommercebackendspring.dto.RoleDto;
import ma.uca.ensas.ecommercebackendspring.dto.RoleDto.RoleDtoBuilder;
import ma.uca.ensas.ecommercebackendspring.entities.Authority;
import ma.uca.ensas.ecommercebackendspring.entities.Authority.AuthorityBuilder;
import ma.uca.ensas.ecommercebackendspring.entities.Role;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-03T18:19:05+0000",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDto roleToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDtoBuilder roleDto = RoleDto.builder();

        roleDto.id( role.getId() );
        roleDto.name( role.getName() );
        roleDto.authorities( authoritySetToAuthorityDtoSet( role.getAuthorities() ) );

        return roleDto.build();
    }

    @Override
    public Role roleDtoToRole(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.getId() );
        role.setName( roleDto.getName() );
        role.setAuthorities( authorityDtoSetToAuthoritySet( roleDto.getAuthorities() ) );

        return role;
    }

    protected AuthorityDto authorityToAuthorityDto(Authority authority) {
        if ( authority == null ) {
            return null;
        }

        AuthorityDtoBuilder authorityDto = AuthorityDto.builder();

        authorityDto.id( authority.getId() );
        authorityDto.permission( authority.getPermission() );

        return authorityDto.build();
    }

    protected Set<AuthorityDto> authoritySetToAuthorityDtoSet(Set<Authority> set) {
        if ( set == null ) {
            return null;
        }

        Set<AuthorityDto> set1 = new HashSet<AuthorityDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Authority authority : set ) {
            set1.add( authorityToAuthorityDto( authority ) );
        }

        return set1;
    }

    protected Authority authorityDtoToAuthority(AuthorityDto authorityDto) {
        if ( authorityDto == null ) {
            return null;
        }

        AuthorityBuilder authority = Authority.builder();

        authority.id( authorityDto.getId() );
        authority.permission( authorityDto.getPermission() );

        return authority.build();
    }

    protected Set<Authority> authorityDtoSetToAuthoritySet(Set<AuthorityDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Authority> set1 = new HashSet<Authority>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AuthorityDto authorityDto : set ) {
            set1.add( authorityDtoToAuthority( authorityDto ) );
        }

        return set1;
    }
}
