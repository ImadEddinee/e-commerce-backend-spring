package ma.uca.ensas.ecommercebackendspring.service;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.entities.Country;
import ma.uca.ensas.ecommercebackendspring.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    public Country saveCountry(Country country){
        return countryRepository.save(country);
    }

    public void deleteCountryById(Long id){
        countryRepository.deleteById(id);
    }
}
