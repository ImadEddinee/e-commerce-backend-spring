package ma.uca.ensas.ecommercebackendspring.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uca.ensas.ecommercebackendspring.entities.City;
import ma.uca.ensas.ecommercebackendspring.entities.Country;
import ma.uca.ensas.ecommercebackendspring.entities.security.Authority;
import ma.uca.ensas.ecommercebackendspring.entities.security.Role;
import ma.uca.ensas.ecommercebackendspring.entities.security.User;
import ma.uca.ensas.ecommercebackendspring.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Set;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final AuthorityRepository authorityRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        this.loadData();
    }
    @Transactional
    void loadData(){
        log.info("Creating Country ...");
        Country country = new Country("Maroc");
        countryRepository.save(country);

        log.info("Creating Cities in {}",country);
        cityRepository.save(new City("Essaouira",country));
        cityRepository.save(new City("Safi",country));
        cityRepository.save(new City("Rabat",country));
        cityRepository.save(new City("Casablanca",country));
        cityRepository.save(new City("Tanger",country));

        log.info("Creating Authorities ...");
        // TODO : Create Enums to represent different Authorities and roles
        Authority createMerchant = authorityRepository.save(
                Authority.builder().permission("create_merchant").build());
        Authority createCategorie = authorityRepository.save(
                Authority.builder().permission("create_category").build()
        );
        Authority createProduct = authorityRepository.save(
                Authority.builder().permission("create_product").build()
        );
        Authority createReference = authorityRepository.save(
                Authority.builder().permission("create_reference").build()
        );
        Authority getMerchant = authorityRepository.save(
                Authority.builder().permission("get_merchant").build()
        );
        Authority getCategory = authorityRepository.save(
                Authority.builder().permission("get_category").build()
        );
        Authority getProduct = authorityRepository.save(
                Authority.builder().permission("get_product").build()
        );
        Authority getReference = authorityRepository.save(
                Authority.builder().permission("get_reference").build()
        );
        Authority getOrders = authorityRepository.save(
                Authority.builder().permission("get_orders").build()
        );

        log.info("Creating Roles ...");
        Role adminRole = roleRepository.save(
                Role.builder().name("ADMIN").build()
        );
        Role merchantRole = roleRepository.save(
                Role.builder().name("MERCHANT").build()
        );
        adminRole.setAuthorities(Set.of(createMerchant, createCategorie, createReference, createProduct, getReference, getProduct, getCategory, getMerchant, getOrders));
        merchantRole.setAuthorities(Set.of(createCategorie, getCategory, getOrders, createProduct, getProduct, getReference, getMerchant));

        log.info("Creating Users");
        userRepository.save(User.builder()
                .firstname("Imad Eddine")
                .lastname("El Hajali")
                .username("imadeddine")
                .password(passwordEncoder.encode("admin"))
                .email("imadhajali66@gmail.com")
                .address("Essaouira")
                .phone("0664523185")
                .role(adminRole)
                .build()
        );
        userRepository.save(User.builder()
                .firstname("Youssef")
                .lastname("Attar")
                .username("youssef")
                .password(passwordEncoder.encode("merchant"))
                .email("email@gmail.com")
                .role(merchantRole)
                .build()
        );

    }
}
