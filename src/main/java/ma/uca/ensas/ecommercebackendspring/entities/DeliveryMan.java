package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "DELIVERY_MAN")
public class DeliveryMan {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "First name is required")
    @Size(min = 4,max = 20,message = "First name should be between 4 and 20 characters")
    private String firstName;
    @NotEmpty(message = "Last name is required")
    @Size(min = 4,max = 20,message = "Last name should be between 4 and 20 characters")
    private String lastName;
    @Nullable
    private String address;
    private String phoneNumber;
    @OneToMany(mappedBy = "deliveryMan")
    private List<Order> orders;
}
