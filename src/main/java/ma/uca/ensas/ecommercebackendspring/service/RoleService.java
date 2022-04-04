package ma.uca.ensas.ecommercebackendspring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uca.ensas.ecommercebackendspring.dto.AuthorityDto;
import ma.uca.ensas.ecommercebackendspring.dto.RoleDto;
import ma.uca.ensas.ecommercebackendspring.entities.Authority;
import ma.uca.ensas.ecommercebackendspring.entities.Role;
import ma.uca.ensas.ecommercebackendspring.exceptions.ApiRequestException;
import ma.uca.ensas.ecommercebackendspring.mapper.AuthorityMapper;
import ma.uca.ensas.ecommercebackendspring.mapper.RoleMapper;
import ma.uca.ensas.ecommercebackendspring.repositories.AuthorityRepository;
import ma.uca.ensas.ecommercebackendspring.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;
    private final RoleMapper roleMapper;

    public List<RoleDto> getAllRoles(){
        return roleRepository.findAll().stream()
                .map(roleMapper::roleToRoleDto)
                .collect(Collectors.toList());
    }

    public RoleDto saveRole(RoleDto roleDto){
        if (roleRepository.findByName(roleDto.getName()).isPresent()){
            throw new ApiRequestException("Role with name : " + roleDto.getName() + " already exists");
        }
        Set<Authority> authorities = roleDto.getAuthoritiesId().stream()
                .map(id -> authorityRepository.findById(id)
                        .orElseThrow(() -> new ApiRequestException("Authority with id : " + id + " doesn't exist")))
                .collect(Collectors.toSet());
        Role role = roleMapper.roleDtoToRole(roleDto);
        role.setAuthorities(authorities);
        return roleMapper.roleToRoleDto(roleRepository.save(role));
    }

}
