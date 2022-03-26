package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SHIPPING_INFO")
public class ShippingInfo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ShippingType shippingType;
    @Lob
    private String description;
    private BigDecimal shippingCost;
    @OneToMany(mappedBy = "shippingInfo")
    private List<Order> orders;
}
