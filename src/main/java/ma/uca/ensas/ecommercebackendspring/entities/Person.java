package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("P")
@AllArgsConstructor
@NoArgsConstructor
public class Person extends Merchant{

    private String firstName;
    private String LastName;
}
