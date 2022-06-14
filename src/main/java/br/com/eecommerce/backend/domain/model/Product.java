package br.com.eecommerce.backend.domain.model;

import java.math.BigDecimal;
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

@Entity
@Table(name = "product", schema = "public")
@SequenceGenerator(
        name = "product_idt_product_seq",
        schema = "public",
        allocationSize = 1,
        sequenceName = "product_idt_product_seq"
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_idt_product_seq")
    @Column(name = "idt_product")
    private Long id;

    @Column(name = "des_name")
    private String name;

    @Column(name = "num_price")
    private BigDecimal price;

    @Column(name = "num_stock_counter")
    private Integer stockCounter;
}
