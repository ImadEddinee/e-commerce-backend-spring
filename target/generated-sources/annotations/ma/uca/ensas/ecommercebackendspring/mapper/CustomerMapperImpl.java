package ma.uca.ensas.ecommercebackendspring.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ma.uca.ensas.ecommercebackendspring.dto.CustomerDto;
import ma.uca.ensas.ecommercebackendspring.dto.CustomerDto.CustomerDtoBuilder;
import ma.uca.ensas.ecommercebackendspring.entities.City;
import ma.uca.ensas.ecommercebackendspring.entities.Customer;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-05T18:22:47+0000",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDtoBuilder customerDto = CustomerDto.builder();

        customerDto.cityId( customerCityId( customer ) );
        customerDto.id( customer.getId() );
        customerDto.firstname( customer.getFirstname() );
        customerDto.lastname( customer.getLastname() );
        customerDto.username( customer.getUsername() );
        customerDto.password( customer.getPassword() );
        customerDto.email( customer.getEmail() );
        customerDto.phone( customer.getPhone() );
        customerDto.address( customer.getAddress() );
        customerDto.enabled( customer.isEnabled() );

        return customerDto.build();
    }

    @Override
    public Customer customerDtoToCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDto.getId() );
        customer.setUsername( customerDto.getUsername() );
        customer.setPassword( customerDto.getPassword() );
        customer.setFirstname( customerDto.getFirstname() );
        customer.setLastname( customerDto.getLastname() );
        customer.setEmail( customerDto.getEmail() );
        customer.setPhone( customerDto.getPhone() );
        customer.setAddress( customerDto.getAddress() );
        customer.setEnabled( customerDto.isEnabled() );

        return customer;
    }

    @Override
    public List<CustomerDto> customersToCustomersDto(List<Customer> customers) {
        if ( customers == null ) {
            return null;
        }

        List<CustomerDto> list = new ArrayList<CustomerDto>( customers.size() );
        for ( Customer customer : customers ) {
            list.add( customerToCustomerDto( customer ) );
        }

        return list;
    }

    private Long customerCityId(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        City city = customer.getCity();
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
