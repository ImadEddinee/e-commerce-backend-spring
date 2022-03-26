package ma.uca.ensas.ecommercebackendspring.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uca.ensas.ecommercebackendspring.entities.City;
import ma.uca.ensas.ecommercebackendspring.entities.Country;
import ma.uca.ensas.ecommercebackendspring.repositories.CityRepository;
import ma.uca.ensas.ecommercebackendspring.repositories.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    @Override
    public void run(String... args) throws Exception {
        this.loadData();
    }
    @Transactional
    void loadData(){
        Country country = new Country("Maroc");
        log.info("Creating Country ...");
        countryRepository.save(country);
        log.info("Creating Cities in {}",country);
        cityRepository.save(new City("Essaouira",country));
        cityRepository.save(new City("Safi",country));
        cityRepository.save(new City("Rabat",country));
        cityRepository.save(new City("Casablanca",country));
        cityRepository.save(new City("Tanger",country));
    }
}
