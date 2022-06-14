package br.com.eecommerce.backend.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartVO {
    private Long id;
    private CustomerVO customer;

    @JsonProperty("total_amount")
    private BigDecimal totalAmount;

    @JsonProperty("cart_items")
    private List<CartItemVO> cartItems;
}
