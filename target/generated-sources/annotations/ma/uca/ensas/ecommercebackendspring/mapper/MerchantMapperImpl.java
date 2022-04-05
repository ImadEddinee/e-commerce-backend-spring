package ma.uca.ensas.ecommercebackendspring.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ma.uca.ensas.ecommercebackendspring.dto.MerchantDto;
import ma.uca.ensas.ecommercebackendspring.dto.MerchantDto.MerchantDtoBuilder;
import ma.uca.ensas.ecommercebackendspring.entities.City;
import ma.uca.ensas.ecommercebackendspring.entities.Merchant;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-05T18:58:53+0000",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class MerchantMapperImpl implements MerchantMapper {

    @Override
    public MerchantDto merchantToMerchantDto(Merchant merchant) {
        if ( merchant == null ) {
            return null;
        }

        MerchantDtoBuilder merchantDto = MerchantDto.builder();

        merchantDto.cityId( merchantCityId( merchant ) );
        merchantDto.id( merchant.getId() );
        merchantDto.firstname( merchant.getFirstname() );
        merchantDto.lastname( merchant.getLastname() );
        merchantDto.username( merchant.getUsername() );
        merchantDto.password( merchant.getPassword() );
        merchantDto.email( merchant.getEmail() );
        merchantDto.merchantType( merchant.getMerchantType() );
        merchantDto.description( merchant.getDescription() );
        merchantDto.webSite( merchant.getWebSite() );
        merchantDto.phone( merchant.getPhone() );
        merchantDto.address( merchant.getAddress() );
        merchantDto.enabled( merchant.isEnabled() );

        return merchantDto.build();
    }

    @Override
    public Merchant merchantDtoToMerchant(MerchantDto merchantDto) {
        if ( merchantDto == null ) {
            return null;
        }

        Merchant merchant = new Merchant();

        merchant.setId( merchantDto.getId() );
        merchant.setUsername( merchantDto.getUsername() );
        merchant.setPassword( merchantDto.getPassword() );
        merchant.setFirstname( merchantDto.getFirstname() );
        merchant.setLastname( merchantDto.getLastname() );
        merchant.setEmail( merchantDto.getEmail() );
        merchant.setPhone( merchantDto.getPhone() );
        merchant.setAddress( merchantDto.getAddress() );
        merchant.setEnabled( merchantDto.isEnabled() );
        merchant.setMerchantType( merchantDto.getMerchantType() );
        merchant.setDescription( merchantDto.getDescription() );
        merchant.setWebSite( merchantDto.getWebSite() );

        return merchant;
    }

    @Override
    public List<MerchantDto> merchantsToMerchantsDto(List<Merchant> merchants) {
        if ( merchants == null ) {
            return null;
        }

        List<MerchantDto> list = new ArrayList<MerchantDto>( merchants.size() );
        for ( Merchant merchant : merchants ) {
            list.add( merchantToMerchantDto( merchant ) );
        }

        return list;
    }

    private Long merchantCityId(Merchant merchant) {
        if ( merchant == null ) {
            return null;
        }
        City city = merchant.getCity();
        if ( city == null ) {
            return null;
        }
        Long id = city.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
