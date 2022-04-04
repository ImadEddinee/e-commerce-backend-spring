package ma.uca.ensas.ecommercebackendspring.mapper;

import ma.uca.ensas.ecommercebackendspring.dto.ProductExperienceDto;
import ma.uca.ensas.ecommercebackendspring.entities.ProductExperience;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductExpMapper {
    // TODO: fix productId null
    @Mapping(source = "product.id",target = "productId")
    ProductExperienceDto productExpToProductExpDto(ProductExperience productExperience);

    ProductExperience productExpDtoToProductExp(ProductExperienceDto productExperienceDto);

    List<ProductExperienceDto> productsExpToProductsExpDtos(List<ProductExperience> productExperiences);
}
