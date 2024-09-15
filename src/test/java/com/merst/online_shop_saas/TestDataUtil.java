package com.merst.online_shop_saas;

import java.sql.Timestamp;
import java.util.UUID;

import com.merst.online_shop_saas.domain.Address;
import com.merst.online_shop_saas.domain.Category;
import com.merst.online_shop_saas.domain.Customer;
import com.merst.online_shop_saas.domain.Product;
import com.merst.online_shop_saas.domain.Supplier;

public final class TestDataUtil {
    
    private TestDataUtil() {}
    
    public static Address createDummyAddressA() {
        return Address.builder()
            .id(UUID.fromString("3b536aa2-6147-467c-94b1-4e62204b1eb7"))
            .customerId(UUID.fromString("3b536aa2-6147-467c-94b1-4e62884b1eb7"))
            .digits(1010)
            .city("Montreal")
            .country("Canada")
            .stateProvince("Quebec")
            .zipcode("90210")
            .nickname("Home")
            .build();
    }
    
    public static Supplier createDummySupplierA() {
        return Supplier.builder()
            .id(UUID.fromString("c1a74217-e144-46e0-8bc5-90993cd51f7c"))
            .name("Foo's tasty bars")
            .build();
    }

    public static Category createDummyCategoryA() {
        return Category.builder()
            .id(UUID.fromString("c1a74217-e144-46e0-8bc5-90993cd51f7c"))
            .parentCategory(null)
            .name("Plants")
            .description("Usually green, usually living, usually outside.")
            .build();
    }
    public static Product createDummyProductA() {
        return Product.builder()
            .id(UUID.fromString("1f5cc70d-92b6-4ef0-adde-fbb64e875aab"))
            .supplier(createDummySupplierA())
            .category(createDummyCategoryA())
            .name("Wobbly womper")
            .price(3.33f)
            .isAvailable(true)
            .saleMultiplier(1)
            .description("It's fun.")
            .build();
    }

    public static Customer createDummyCustomerA() {
        return Customer.builder()
            .id(UUID.fromString("10e999cd-8308-4772-a0a7-88ddcd40ea18"))
            .firstName("John")
            .middleName(null)
            .lastName("Doe")
            .email("johndoe@gmail.com")
            .locale("EN")
            .createdAt(new Timestamp(424242))
            .lastLogin(new Timestamp (424243))
            .emailValidated(true)
            .build();
    }
}
