package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("P")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person extends Merchant{

    private String firstName;
    private String LastName;
}
