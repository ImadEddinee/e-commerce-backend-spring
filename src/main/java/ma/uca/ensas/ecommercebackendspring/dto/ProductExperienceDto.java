package ma.uca.ensas.ecommercebackendspring.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class ProductExperienceDto {

    private Long id;
    @NotBlank
    private String reviewTitle;
    @NotBlank
    private String reviewBody;
    private Long productId;
}
