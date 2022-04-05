package ma.uca.ensas.ecommercebackendspring.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uca.ensas.ecommercebackendspring.dto.CustomerDto;
import ma.uca.ensas.ecommercebackendspring.dto.ProductExperienceDto;
import ma.uca.ensas.ecommercebackendspring.entities.*;

import ma.uca.ensas.ecommercebackendspring.mapper.CustomerMapper;
import ma.uca.ensas.ecommercebackendspring.mapper.ProductExpMapper;
import ma.uca.ensas.ecommercebackendspring.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Set;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final AuthorityRepository authorityRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdminRepository adminRepository;
    private final MerchantRepository merchantRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ProductExperienceRepository productExperienceRepository;
    private final ProductExpMapper productExpMapper;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        this.loadData();
    }
    @Transactional
    void loadData(){
        log.info("Creating Country ...");
        Country country = Country.builder().name("Maroc").build();
        countryRepository.save(country);

        log.info("Creating Cities in {}",country);
        City essaouira = cityRepository.save(City.builder()
                .name("Essaouira").country(country).build());
        cityRepository.save(City.builder()
                .name("Tanger").country(country).build());

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
                new Role("ADMIN")
        );
        Role merchantRole = roleRepository.save(
                new Role("MERCHANT")
        );
        adminRole.setAuthorities(Set.of(createMerchant, createCategorie, createReference, createProduct, getReference, getProduct, getCategory, getMerchant, getOrders));
        merchantRole.setAuthorities(Set.of(createCategorie, getCategory, getOrders, createProduct, getProduct, getReference, getMerchant));

        roleRepository.saveAll(Arrays.asList(adminRole,merchantRole));

        log.info("Creating Users");

        Admin admin = new Admin();
        admin.setFirstname("Imad Eddine");
        admin.setLastname("El Hajali");
        admin.setEmail("email@gmail.com");
        admin.setUsername("imadeddine");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.getRoles().add(adminRole);
        adminRepository.save(admin);


        Customer customer = new Customer();
        customer.setFirstname("Imad");
        customer.setLastname("eddine");
        customer.setUsername("user112");
        customer.setPassword(passwordEncoder.encode("customer"));
        customer.setEmail("emailff@gmail.com");
        customer.setCity(essaouira);
        customerRepository.save(customer);


        Merchant merchant = new Merchant();
        merchant.setFirstname("Youssef");
        merchant.setLastname("Attar");
        merchant.setEmail("myemail@gmail.com");
        merchant.setUsername("atryoussef");
        merchant.setPassword(passwordEncoder.encode("merchant"));
        merchant.getRoles().add(merchantRole);
        merchant.setMerchantType(MerchantType.PERSON);
        merchant.setDescription("description");
        merchant.setCity(essaouira);
        merchantRepository.save(merchant);

        Category category = new Category();
        category.setName("Bread");
        category.setDescription("description");
        categoryRepository.save(category);

        Product product = new Product();
        product.setName("produit");
        product.setDescription("description");
        product.setProductStatus(ProductStatus.AVAILABLE);
        productRepository.save(product);


    }
}
