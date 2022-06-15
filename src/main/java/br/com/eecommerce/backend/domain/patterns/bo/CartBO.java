package br.com.eecommerce.backend.domain.patterns.bo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartBO {
    private Long id;
    private CustomerBO customer;

    @JsonProperty("total_amount")
    private BigDecimal totalAmount;

    @JsonProperty("cart_items")
    private List<CartItemBO> cartItems;

    public void addItem(final CartItemBO cartItem) {
        cartItems = Optional.ofNullable(getCartItems()).orElse(new ArrayList<>());
        cartItems.add(cartItem);
    }

    public void calculateAmount(final CartItemBO cartItemBO) {
        final BigDecimal productPrice = cartItemBO.getProduct().getPrice();
        final BigDecimal productQuantity = BigDecimal.valueOf(cartItemBO.getQuantity());

        totalAmount = totalAmount.add(productPrice.multiply(productQuantity));
    }
}
