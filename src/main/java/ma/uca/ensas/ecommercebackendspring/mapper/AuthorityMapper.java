package ma.uca.ensas.ecommercebackendspring.mapper;

import ma.uca.ensas.ecommercebackendspring.dto.AuthorityDto;
import ma.uca.ensas.ecommercebackendspring.entities.security.Authority;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorityMapper {

    AuthorityDto authorityToAuthorityDto(Authority authority);
    Authority authorityDtoToAuthority(AuthorityDto authorityDto);
    List<Authority> authorityDtosToAuthorities(List<AuthorityDto> authorityDtos);
}
