package br.com.eecommerce.backend.domain.vo;

import br.com.eecommerce.backend.domain.model.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartItemVO {

    private Long id;
    private ProductVO product;
    private Integer quantity;
}
