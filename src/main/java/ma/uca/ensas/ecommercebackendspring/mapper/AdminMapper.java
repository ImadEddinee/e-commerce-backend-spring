package ma.uca.ensas.ecommercebackendspring.mapper;

import ma.uca.ensas.ecommercebackendspring.dto.AdminDto;
import ma.uca.ensas.ecommercebackendspring.entities.Admin;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    AdminDto adminToAdminDto(Admin admin);

    Admin adminDtoToAdmin(AdminDto adminDto);

    List<AdminDto> adminsToAdminsDtos(List<Admin> admins);
}
