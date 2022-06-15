package br.com.eecommerce.backend.domain.patterns.dto;

import br.com.eecommerce.backend.domain.patterns.bo.ProductBO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartAddItemDto {

    private Long id;

    @JsonProperty("product_id")
    private Long productId;
    private Integer quantity;
}