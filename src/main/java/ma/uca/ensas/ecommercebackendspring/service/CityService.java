package ma.uca.ensas.ecommercebackendspring.service;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.entities.City;
import ma.uca.ensas.ecommercebackendspring.exceptions.ApiRequestException;
import ma.uca.ensas.ecommercebackendspring.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public City saveCity(City city){
        if (cityRepository.findByName(city.getName()).isPresent()){
            throw new ApiRequestException("City with name : " + city.getName() + " already exists !");
        }
        return cityRepository.save(city);
    }

    public void deleteCityById(Long id){
        if (cityRepository.findById(id).isEmpty()){
            throw new ApiRequestException("City with id : " + id + " doesn't exists");
        }
        cityRepository.deleteById(id);
    }
}
