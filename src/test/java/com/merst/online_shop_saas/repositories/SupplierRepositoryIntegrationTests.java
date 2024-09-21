package com.merst.online_shop_saas.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import com.merst.online_shop_saas.TestDataUtil;
import com.merst.online_shop_saas.domain.entities.Supplier;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SupplierRepositoryIntegrationTests {
    private SupplierRepository underTest;

    @Autowired
    public SupplierRepositoryIntegrationTests(SupplierRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void supplierProperlyCreatedAndRecalled() {
        Supplier supplier = TestDataUtil.createDummySupplierA();
        underTest.save(supplier);
        Optional<Supplier> result = underTest.findById(supplier.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(supplier);
    }
}
