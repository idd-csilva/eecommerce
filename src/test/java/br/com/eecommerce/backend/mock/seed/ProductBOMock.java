package br.com.eecommerce.backend.mock.seed;

import br.com.eecommerce.backend.domain.patterns.bo.ProductBO;

public class ProductBOMock extends MockSeeder<ProductBO> {

    @Override
    public ProductBO getMock() {
        return super.inflate(ProductBO.builder().build());
    }
}
