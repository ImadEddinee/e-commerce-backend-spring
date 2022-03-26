package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@DiscriminatorValue("C")
@AllArgsConstructor()
@NoArgsConstructor
public class Company extends Merchant{

    private String name;
    private String activity;
}
