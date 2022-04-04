package ma.uca.ensas.ecommercebackendspring.service;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.dto.MerchantDto;
import ma.uca.ensas.ecommercebackendspring.entities.Merchant;
import ma.uca.ensas.ecommercebackendspring.exceptions.ApiRequestException;
import ma.uca.ensas.ecommercebackendspring.mapper.MerchantMapper;
import ma.uca.ensas.ecommercebackendspring.repositories.CityRepository;
import ma.uca.ensas.ecommercebackendspring.repositories.MerchantRepository;
import ma.uca.ensas.ecommercebackendspring.util.UserUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepository merchantRepository;
    private final MerchantMapper merchantMapper;
    private final CityRepository cityRepository;
    private final UserUtil userUtil;

    public List<MerchantDto> getAllMerchant(){
        return merchantMapper.merchantsToMerchantsDto(merchantRepository.findAll());
    }

    public MerchantDto saveMerchant(MerchantDto merchantDto){
        userUtil.verifyRedundantCredentials(merchantDto.getEmail(), merchantDto.getUsername());
        Merchant merchant = merchantMapper.merchantDtoToMerchant(merchantDto);
        merchant.setCity(cityRepository.findById(merchantDto.getCityId())
                .orElseThrow(() -> new ApiRequestException("City with id : " + merchantDto.getCityId() + " doesn't exists")));
       return merchantMapper.merchantToMerchantDto(merchantRepository.save(merchant));
    }
}
