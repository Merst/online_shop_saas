package com.merst.online_shop_saas.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import com.merst.online_shop_saas.dao.AddressDao;
import com.merst.online_shop_saas.domain.Address;

public class AddressDaoImpl implements AddressDao{
    private final JdbcTemplate jdbcTemplate;

    public AddressDaoImpl(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

   @Override
    public void create(Address address){
        jdbcTemplate.update(
        "INSERT INTO address (id, customerId, digits, city, country, stateProvince, zipcode, nickname) VALUES (?,?,?,?,?,?,?,?)",
            address.getId(),
            address.getCustomerId(),
            address.getDigits(),
            address.getCity(),
            address.getCountry(),
            address.getStateProvince(),
            address.getZipcode(),
            address.getNickname()
        ); 
    }
    
}
