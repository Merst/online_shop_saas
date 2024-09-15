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
import com.merst.online_shop_saas.domain.Customer;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CustomerRepositoryIntegrationTests {
    private CustomerRepository underTest;

    @Autowired
    public CustomerRepositoryIntegrationTests(CustomerRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void customerProperlyCreatedAndRecalled(){
        Customer customer = TestDataUtil.createDummyCustomerA();
        underTest.save(customer);
        Optional<Customer> result = underTest.findById(customer.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(customer);
    }
}
