package com.dennys.ecommerce.Products;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.dennys.ecommerce.dao.ProductRepository;
import com.dennys.ecommerce.entity.Product;
import com.dennys.ecommerce.entity.ProductCategory;



@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
   public ProductRepository underTest;

   BigDecimal unitPrice;
   Set<Product> product;

    @Test
    void itShouldFindByCategoryId(){
     // Assuming you have products in the database with category id 1
        Long categoryId = 2L;
        PageRequest pageable = PageRequest.of(1, 4);
                ProductCategory d = new ProductCategory("book",product);

        Product p = new Product( d, "T-SHIRT-1000", "T-SHIRT SUNNY STYLE", "A black T-shirt with a big logo", unitPrice, null, false, 20
        , null, null);

        underTest.save(p);


        Page<Product> products = underTest.findByCategoryId(categoryId, pageable);

        // Add assertions to verify the results
        assertThat(products);

    }

    public void itShouldFindByName() {

    }

}
