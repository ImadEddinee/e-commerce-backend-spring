package ma.uca.ensas.ecommercebackendspring.dto;

import lombok.Builder;
import lombok.Data;
import ma.uca.ensas.ecommercebackendspring.entities.OrderStatus;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

@Data
@Builder
public class OrderDto {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime shippedAt;
    private OrderStatus orderStatus;
    private Long customerId;

}
