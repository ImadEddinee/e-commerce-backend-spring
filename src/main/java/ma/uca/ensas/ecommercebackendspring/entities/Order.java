package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime shippedAt;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "shipping_id", referencedColumnName = "id")
    private ShippingInfo shippingInfo;

    @OneToOne(mappedBy = "order")
    private OrderDetail orderDetail;

    @ManyToOne
    @JoinColumn(name = "deliveryman_id",referencedColumnName = "id")
    private DeliveryMan deliveryMan;
}
