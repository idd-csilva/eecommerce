package br.com.eecommerce.backend.service;

import br.com.eecommerce.backend.domain.mapper.ProductMapper;
import br.com.eecommerce.backend.domain.model.Product;
import br.com.eecommerce.backend.domain.repository.ProductRepository;
import br.com.eecommerce.backend.domain.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductVO create(final ProductVO productVO) {
        final Product entity = productRepository.save(
                ProductMapper.INSTANCE.productVOToProduct(productVO)
        );

        return ProductMapper.INSTANCE.productToProductVO(entity);
    }

    public ProductVO findById(final Long productId) {
        final Product entity = productRepository.findById(productId).orElseThrow();

        return ProductMapper.INSTANCE.productToProductVO(entity);
    }
}
