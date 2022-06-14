package br.com.eecommerce.backend.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer", schema = "public")
@SequenceGenerator(
        name = "customer_idt_customer_seq",
        schema = "public",
        allocationSize = 1,
        sequenceName = "customer_idt_customer_seq"
)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_idt_customer_seq")
    @Column(name = "idt_customer")
    private Long id;

    @Column(name = "des_first_name")
    private String firstName;

    @Column(name = "des_last_name")
    private String lastName;

    @Column(name = "des_email")
    private String email;
}
