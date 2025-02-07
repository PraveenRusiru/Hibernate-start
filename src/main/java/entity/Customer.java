package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="customer_table")
public class Customer {
    @Id
    private String customerId;
    private String customerName;
    private String email;

}
