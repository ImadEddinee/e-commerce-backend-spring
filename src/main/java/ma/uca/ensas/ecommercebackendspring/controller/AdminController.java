package ma.uca.ensas.ecommercebackendspring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uca.ensas.ecommercebackendspring.dto.AdminDto;
import ma.uca.ensas.ecommercebackendspring.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    @GetMapping
    public List<AdminDto> getAdminList(){
        return adminService.getAll();
    }

    @PostMapping
    public AdminDto saveAdmin(@RequestBody @Valid AdminDto adminDto){
        log.info(adminDto.getUsername());
        return adminService.saveAdmin(adminDto);
    }
}
