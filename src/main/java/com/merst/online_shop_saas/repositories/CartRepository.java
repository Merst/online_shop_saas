package com.merst.online_shop_saas.repositories;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.merst.online_shop_saas.domain.entities.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, UUID> {}