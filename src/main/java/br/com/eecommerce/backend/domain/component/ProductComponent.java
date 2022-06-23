package br.com.eecommerce.backend.domain.component;

import br.com.eecommerce.backend.domain.mapper.ProductMapper;
import br.com.eecommerce.backend.domain.model.Product;
import br.com.eecommerce.backend.domain.patterns.bo.ProductBO;
import br.com.eecommerce.backend.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductComponent {

    @Autowired
    private ProductRepository productRepository;

    public ProductBO create(final ProductBO productBO) {
        final Product entity = productRepository.save(ProductMapper.INSTANCE.productBOToProduct(productBO));

        return productToProductVO(entity);
    }

    private ProductBO productToProductVO(final Product entity) {
        return ProductMapper.INSTANCE.productToProductBO(entity);
    }

    public ProductBO findById(final Long productId) {
        final Product entity = productRepository.findById(productId).orElseThrow();

        return productToProductVO(entity);
    }
}
