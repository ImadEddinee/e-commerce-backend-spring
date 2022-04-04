package ma.uca.ensas.ecommercebackendspring.dto;

import lombok.Builder;
import lombok.Data;
import ma.uca.ensas.ecommercebackendspring.entities.MerchantType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
public class MerchantDto {

    private Long id;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @NotBlank
    @Size(min = 4, max = 25)
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    @Email
    private String email;
    private MerchantType merchantType;
    @NotBlank
    private String description;
    private String webSite;
    private String phone;
    private String address;
    private Long cityId;
    private boolean enabled;
}
