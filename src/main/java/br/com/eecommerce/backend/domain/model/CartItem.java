package br.com.eecommerce.backend.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_items", schema = "public")
@SequenceGenerator(
        name = "cart_items_idt_cart_items_seq",
        schema = "public",
        allocationSize = 1,
        sequenceName = "cart_items_idt_cart_items_seq"
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_items_idt_cart_items_seq")
    @Column(name = "idt_cart_items")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idt_product")
    private Product product;

    @Column(name = "num_quantity")
    private Integer quantity;
}
