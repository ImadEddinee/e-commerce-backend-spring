package ma.uca.ensas.ecommercebackendspring.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ma.uca.ensas.ecommercebackendspring.dto.ProductExperienceDto;
import ma.uca.ensas.ecommercebackendspring.dto.ProductExperienceDto.ProductExperienceDtoBuilder;
import ma.uca.ensas.ecommercebackendspring.entities.Product;
import ma.uca.ensas.ecommercebackendspring.entities.ProductExperience;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-04T17:40:13+0000",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class ProductExpMapperImpl implements ProductExpMapper {

    @Override
    public ProductExperienceDto productExpToProductExpDto(ProductExperience productExperience) {
        if ( productExperience == null ) {
            return null;
        }

        ProductExperienceDtoBuilder productExperienceDto = ProductExperienceDto.builder();

        productExperienceDto.productId( productExperienceProductId( productExperience ) );
        productExperienceDto.id( productExperience.getId() );
        productExperienceDto.reviewTitle( productExperience.getReviewTitle() );
        productExperienceDto.reviewBody( productExperience.getReviewBody() );

        return productExperienceDto.build();
    }

    @Override
    public ProductExperience productExpDtoToProductExp(ProductExperienceDto productExperienceDto) {
        if ( productExperienceDto == null ) {
            return null;
        }

        ProductExperience productExperience = new ProductExperience();

        productExperience.setId( productExperienceDto.getId() );
        productExperience.setReviewTitle( productExperienceDto.getReviewTitle() );
        productExperience.setReviewBody( productExperienceDto.getReviewBody() );

        return productExperience;
    }

    @Override
    public List<ProductExperienceDto> productsExpToProductsExpDtos(List<ProductExperience> productExperiences) {
        if ( productExperiences == null ) {
            return null;
        }

        List<ProductExperienceDto> list = new ArrayList<ProductExperienceDto>( productExperiences.size() );
        for ( ProductExperience productExperience : productExperiences ) {
            list.add( productExpToProductExpDto( productExperience ) );
        }

        return list;
    }

    private Long productExperienceProductId(ProductExperience productExperience) {
        if ( productExperience == null ) {
            return null;
        }
        Product product = productExperience.getProduct();
        if ( product == null ) {
            return null;
        }
        Long id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
