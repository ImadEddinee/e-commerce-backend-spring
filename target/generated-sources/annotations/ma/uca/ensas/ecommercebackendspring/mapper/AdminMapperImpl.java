package ma.uca.ensas.ecommercebackendspring.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ma.uca.ensas.ecommercebackendspring.dto.AdminDto;
import ma.uca.ensas.ecommercebackendspring.dto.AdminDto.AdminDtoBuilder;
import ma.uca.ensas.ecommercebackendspring.entities.Admin;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-05T18:58:53+0000",
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
}
