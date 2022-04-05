package ma.uca.ensas.ecommercebackendspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

@SpringBootApplication
@EnableAsync
public class ECommerceBackendSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceBackendSpringApplication.class, args);
    }

}
