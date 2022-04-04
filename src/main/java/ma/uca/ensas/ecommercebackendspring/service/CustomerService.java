package ma.uca.ensas.ecommercebackendspring.service;

import lombok.RequiredArgsConstructor;
import ma.uca.ensas.ecommercebackendspring.dto.CustomerDto;
import ma.uca.ensas.ecommercebackendspring.entities.Customer;
import ma.uca.ensas.ecommercebackendspring.exceptions.ApiRequestException;
import ma.uca.ensas.ecommercebackendspring.mapper.CustomerMapper;
import ma.uca.ensas.ecommercebackendspring.repositories.CityRepository;
import ma.uca.ensas.ecommercebackendspring.repositories.CustomerRepository;
import ma.uca.ensas.ecommercebackendspring.util.UserUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final UserUtil userUtil;
    private final CustomerMapper customerMapper;
    private final CityRepository cityRepository;

    public List<CustomerDto> getAllCustomers(){
        return customerMapper.customersToCustomersDto(customerRepository.findAll());
    }

    public CustomerDto saveCustomer(CustomerDto customerDto){
        userUtil.verifyRedundantCredentials(customerDto.getEmail(), customerDto.getUsername());
        Customer customer = customerMapper.customerDtoToCustomer(customerDto);
        customer.setCity(cityRepository.findById(customerDto.getCityId())
                .orElseThrow(() -> new ApiRequestException("City with id : " + customerDto.getCityId() + " doesn't exists") ));
        return customerMapper
                .customerToCustomerDto(customerRepository
                        .save(customer));
    }

    public void deleteCustomerById(Long id){
        if (customerRepository.findById(id).isEmpty()){
            throw new ApiRequestException("Customer with id : " + id + " doesn't exists");
        }
        customerRepository.deleteById(id);
    }
}
