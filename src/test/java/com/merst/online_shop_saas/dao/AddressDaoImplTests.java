package com.merst.online_shop_saas.dao;

import com.merst.online_shop_saas.dao.impl.AddressDaoImpl;
import com.merst.online_shop_saas.domain.Address;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

@ExtendWith(MockitoExtension.class)
public class AddressDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AddressDaoImpl underTest;

    @Test
    public void createsAddressCorrectly() {
        Address address = Address.builder()
            .id(UUID.fromString("3b536aa2-6147-467c-94b1-4e62204b1eb7"))
            .customerId(UUID.fromString("3b536aa2-6147-467c-94b1-4e62884b1eb7"))
            .digits(1010)
            .city("Montreal")
            .country("Canada")
            .stateProvince("Quebec")
            .zipcode("90210")
            .nickname("Home")
            .build();

        underTest.create(address);

        verify(jdbcTemplate).update(
            eq("INSERT INTO address (id, customerId, digits, city, country, stateProvince, zipcode, nickname) VALUES (?,?,?,?,?,?,?,?)"),
            eq(UUID.fromString("3b536aa2-6147-467c-94b1-4e62204b1eb7")),
            eq(UUID.fromString("3b536aa2-6147-467c-94b1-4e62884b1eb7")),
            eq(1010),
            eq("Montreal"),
            eq("Canada"),
            eq("Quebec"),
            eq("90210"),
            eq("Home")
        );
    }
}
