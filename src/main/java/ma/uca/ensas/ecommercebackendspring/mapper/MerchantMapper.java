package ma.uca.ensas.ecommercebackendspring.mapper;

import ma.uca.ensas.ecommercebackendspring.dto.MerchantDto;
import ma.uca.ensas.ecommercebackendspring.entities.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MerchantMapper {

    @Mapping(source = "city.id",target = "cityId")
    MerchantDto merchantToMerchantDto(Merchant merchant);

    Merchant merchantDtoToMerchant(MerchantDto merchantDto);

    @Mapping(source = "city.id",target = "cityId")
    List<MerchantDto> merchantsToMerchantsDto(List<Merchant> merchants);
}
