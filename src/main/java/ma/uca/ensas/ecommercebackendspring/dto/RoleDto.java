package ma.uca.ensas.ecommercebackendspring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto {

    private Long id;
    @NotBlank
    private String name;
    private List<Long> AuthoritiesId;
    private Set<AuthorityDto> authorities;
}
