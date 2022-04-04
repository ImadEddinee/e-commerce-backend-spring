package ma.uca.ensas.ecommercebackendspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DELIVERY_MAN")
public class DeliveryMan {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String address;
    @NotBlank
    private String phoneNumber;
    @JsonIgnore
    @OneToMany(mappedBy = "deliveryMan")
    private List<Order> orders;
}
