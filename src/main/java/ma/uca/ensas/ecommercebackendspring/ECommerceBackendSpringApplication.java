package ma.uca.ensas.ecommercebackendspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ECommerceBackendSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceBackendSpringApplication.class, args);
    }

}
