package ma.uca.ensas.ecommercebackendspring.service;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.dto.AuthorityDto;
import ma.uca.ensas.ecommercebackendspring.exceptions.ApiRequestException;
import ma.uca.ensas.ecommercebackendspring.mapper.AuthorityMapper;
import ma.uca.ensas.ecommercebackendspring.repositories.AuthorityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorityService {

    private final AuthorityRepository authorityRepository;
    private final AuthorityMapper authorityMapper;

    public List<AuthorityDto> getAllAuthorities(){
        return authorityRepository.findAll().stream()
                .map(authorityMapper::authorityToAuthorityDto)
                .collect(Collectors.toList());
    }

    public AuthorityDto saveAuthority(AuthorityDto authorityDto){
        if (authorityRepository.findByPermission(authorityDto.getPermission()).isPresent()){
            throw new ApiRequestException("Permission name : " + authorityDto.getPermission() + " already exists");
        }
        return authorityMapper.authorityToAuthorityDto(authorityRepository.save(authorityMapper.authorityDtoToAuthority(authorityDto)));
    }
}
