package ma.uca.ensas.ecommercebackendspring.service;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.dto.AuthorityDto;
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

    public AuthorityDto getAuthority(Long id){
        return authorityRepository.findById(id)
                .map(authorityMapper::authorityToAuthorityDto)
                .orElseThrow(() -> new IllegalStateException("Authority doesn't exist"));
    }

    public AuthorityDto saveAuthority(AuthorityDto authorityDto){
        return authorityMapper.authorityToAuthorityDto(authorityRepository.save(authorityMapper.authorityDtoToAuthority(authorityDto)));
    }

    public void deleteAuthorityById(Long id){
        authorityRepository.deleteById(id);
    }
}
