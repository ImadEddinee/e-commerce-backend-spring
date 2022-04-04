package ma.uca.ensas.ecommercebackendspring.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import ma.uca.ensas.ecommercebackendspring.dto.AdminDto;
import ma.uca.ensas.ecommercebackendspring.dto.AdminDto.AdminDtoBuilder;
import ma.uca.ensas.ecommercebackendspring.dto.AuthorityDto;
import ma.uca.ensas.ecommercebackendspring.dto.AuthorityDto.AuthorityDtoBuilder;
import ma.uca.ensas.ecommercebackendspring.dto.RoleDto;
import ma.uca.ensas.ecommercebackendspring.dto.RoleDto.RoleDtoBuilder;
import ma.uca.ensas.ecommercebackendspring.entities.Admin;
import ma.uca.ensas.ecommercebackendspring.entities.Authority;
import ma.uca.ensas.ecommercebackendspring.entities.Authority.AuthorityBuilder;
import ma.uca.ensas.ecommercebackendspring.entities.Role;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-04T17:40:13+0000",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class AdminMapperImpl implements AdminMapper {

    @Override
    public AdminDto adminToAdminDto(Admin admin) {
        if ( admin == null ) {
            return null;
        }

        AdminDtoBuilder adminDto = AdminDto.builder();

        adminDto.id( admin.getId() );
        adminDto.username( admin.getUsername() );
        adminDto.password( admin.getPassword() );
        adminDto.firstname( admin.getFirstname() );
        adminDto.lastname( admin.getLastname() );
        adminDto.email( admin.getEmail() );
        adminDto.phone( admin.getPhone() );
        adminDto.address( admin.getAddress() );
        adminDto.enabled( admin.isEnabled() );
        adminDto.roles( roleSetToRoleDtoSet( admin.getRoles() ) );

        return adminDto.build();
    }

    @Override
    public Admin adminDtoToAdmin(AdminDto adminDto) {
        if ( adminDto == null ) {
            return null;
        }

        Admin admin = new Admin();

        admin.setId( adminDto.getId() );
        admin.setUsername( adminDto.getUsername() );
        admin.setPassword( adminDto.getPassword() );
        admin.setFirstname( adminDto.getFirstname() );
        admin.setLastname( adminDto.getLastname() );
        admin.setEmail( adminDto.getEmail() );
        admin.setPhone( adminDto.getPhone() );
        admin.setAddress( adminDto.getAddress() );
        admin.setRoles( roleDtoSetToRoleSet( adminDto.getRoles() ) );
        admin.setEnabled( adminDto.isEnabled() );

        return admin;
    }

    @Override
    public List<AdminDto> adminsToAdminsDtos(List<Admin> admins) {
        if ( admins == null ) {
            return null;
        }

        List<AdminDto> list = new ArrayList<AdminDto>( admins.size() );
        for ( Admin admin : admins ) {
            list.add( adminToAdminDto( admin ) );
        }

        return list;
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

    protected RoleDto roleToRoleDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDtoBuilder roleDto = RoleDto.builder();

        roleDto.id( role.getId() );
        roleDto.name( role.getName() );
        roleDto.authorities( authoritySetToAuthorityDtoSet( role.getAuthorities() ) );

        return roleDto.build();
    }

    protected Set<RoleDto> roleSetToRoleDtoSet(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleDto> set1 = new HashSet<RoleDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role role : set ) {
            set1.add( roleToRoleDto( role ) );
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

    protected Role roleDtoToRole(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.getId() );
        role.setName( roleDto.getName() );
        role.setAuthorities( authorityDtoSetToAuthoritySet( roleDto.getAuthorities() ) );

        return role;
    }

    protected Set<Role> roleDtoSetToRoleSet(Set<RoleDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Role> set1 = new HashSet<Role>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleDto roleDto : set ) {
            set1.add( roleDtoToRole( roleDto ) );
        }

        return set1;
    }
}
