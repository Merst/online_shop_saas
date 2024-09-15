package com.merst.online_shop_saas.repositories;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

import com.merst.online_shop_saas.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, UUID>{
}
