package ma.uca.ensas.ecommercebackendspring.mapper;

import javax.annotation.processing.Generated;
import ma.uca.ensas.ecommercebackendspring.dto.AuthorityDto;
import ma.uca.ensas.ecommercebackendspring.dto.AuthorityDto.AuthorityDtoBuilder;
import ma.uca.ensas.ecommercebackendspring.entities.security.Authority;
import ma.uca.ensas.ecommercebackendspring.entities.security.Authority.AuthorityBuilder;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-29T17:09:12+0000",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class AuthorityMapperImpl implements AuthorityMapper {

    @Override
    public AuthorityDto authorityToAuthorityDto(Authority authority) {
        if ( authority == null ) {
            return null;
        }

        AuthorityDtoBuilder authorityDto = AuthorityDto.builder();

        authorityDto.id( authority.getId() );
        authorityDto.permission( authority.getPermission() );

        return authorityDto.build();
    }

    @Override
    public Authority authorityDtoToAuthority(AuthorityDto authorityDto) {
        if ( authorityDto == null ) {
            return null;
        }

        AuthorityBuilder authority = Authority.builder();

        authority.id( authorityDto.getId() );
        authority.permission( authorityDto.getPermission() );

        return authority.build();
    }
}