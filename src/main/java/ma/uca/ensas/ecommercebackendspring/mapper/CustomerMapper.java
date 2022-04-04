package ma.uca.ensas.ecommercebackendspring.mapper;

import ma.uca.ensas.ecommercebackendspring.dto.CustomerDto;
import ma.uca.ensas.ecommercebackendspring.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(source = "city.id",target = "cityId")
    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);

    @Mapping(source = "city.id",target = "cityId")
    List<CustomerDto> customersToCustomersDto(List<Customer> customers);
}
