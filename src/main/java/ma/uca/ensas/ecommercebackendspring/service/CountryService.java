package ma.uca.ensas.ecommercebackendspring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uca.ensas.ecommercebackendspring.entities.Country;
import ma.uca.ensas.ecommercebackendspring.exceptions.ApiRequestException;
import ma.uca.ensas.ecommercebackendspring.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    public Country saveCountry(Country country){
        if (countryRepository.findByName(country.getName()).isPresent()){
            throw new ApiRequestException("Country name already in use !" + country.getName());
        }
        return countryRepository.save(country);
    }

    public void deleteCountryById(Long id){
        if (countryRepository.findById(id).isEmpty()){
            throw new ApiRequestException("Country with id = " + id + " doesn't exists");
        }
        countryRepository.deleteById(id);
    }
}
