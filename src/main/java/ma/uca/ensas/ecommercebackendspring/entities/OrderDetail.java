package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ORDER_DETAIL")
public class OrderDetail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal discount;
    private BigDecimal total;
    @OneToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private Order order;
    @ManyToMany(mappedBy = "orderDetailList")
    private List<Product> products;
    @OneToOne(mappedBy = "orderDetail")
    private Payment payment;
}
