package ma.uca.ensas.ecommercebackendspring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uca.ensas.ecommercebackendspring.dto.AuthorityDto;
import ma.uca.ensas.ecommercebackendspring.dto.RoleDto;
import ma.uca.ensas.ecommercebackendspring.entities.security.Authority;
import ma.uca.ensas.ecommercebackendspring.entities.security.Role;
import ma.uca.ensas.ecommercebackendspring.exceptions.RoleAlreadyExistsException;
import ma.uca.ensas.ecommercebackendspring.mapper.AuthorityMapper;
import ma.uca.ensas.ecommercebackendspring.mapper.RoleMapper;
import ma.uca.ensas.ecommercebackendspring.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    private final AuthorityMapper authorityMapper;

    public List<RoleDto> getAllRoles(){
        return roleRepository.findAll().stream()
                .map(roleMapper::roleToRoleDto)
                .collect(Collectors.toList());
    }

    public RoleDto saveRole(RoleDto roleDto){
        if (roleRepository.findByName(roleDto.getName()).isPresent()){
            throw new RoleAlreadyExistsException("Role name already exists");
        }
        return roleMapper.roleToRoleDto(roleRepository.save(roleMapper.roleDtoToRole(roleDto)));
    }

    public void addAuthoritiesToRole(Long id, List<AuthorityDto> authorityDtos){
        List<Authority> authorities = authorityMapper.authorityDtosToAuthorities(authorityDtos);
        Role role = roleRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Role doesn't exists"));
        Set<String> existedAuthoritiesNames = role.getAuthorities().stream()
                .map(Authority::getPermission)
                .collect(Collectors.toSet());
        Set<Authority> authoritiesToAdd = authorities.stream()
                .filter(authority -> !existedAuthoritiesNames
                        .contains(authority.getPermission()))
                .collect(Collectors.toSet());
        role.getAuthorities().addAll(authoritiesToAdd);
        roleRepository.save(role);
    }
}
