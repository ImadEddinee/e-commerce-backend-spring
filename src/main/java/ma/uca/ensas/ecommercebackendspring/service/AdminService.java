package ma.uca.ensas.ecommercebackendspring.service;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.dto.AdminDto;
import ma.uca.ensas.ecommercebackendspring.mapper.AdminMapper;
import ma.uca.ensas.ecommercebackendspring.repositories.AdminRepository;
import ma.uca.ensas.ecommercebackendspring.util.UserUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;
    private final UserUtil userUtil;

    public List<AdminDto> getAll(){
        return adminMapper.adminsToAdminsDtos(adminRepository.findAll());
    }

    public AdminDto saveAdmin(AdminDto adminDto){
        userUtil.verifyRedundantCredentials(adminDto.getEmail(), adminDto.getUsername());
        return adminMapper.
                adminToAdminDto(adminRepository.save(adminMapper.adminDtoToAdmin(adminDto)));
    }
}
