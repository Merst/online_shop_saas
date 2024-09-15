package com.merst.online_shop_saas;

import java.sql.Timestamp;
import java.util.UUID;

import com.merst.online_shop_saas.domain.Address;
import com.merst.online_shop_saas.domain.Cart;
import com.merst.online_shop_saas.domain.CartItem;
import com.merst.online_shop_saas.domain.Category;
import com.merst.online_shop_saas.domain.Customer;
import com.merst.online_shop_saas.domain.Invoice;
import com.merst.online_shop_saas.domain.InvoiceItem;
import com.merst.online_shop_saas.domain.Payment;
import com.merst.online_shop_saas.domain.Product;
import com.merst.online_shop_saas.domain.Review;
import com.merst.online_shop_saas.domain.Supplier;

public final class TestDataUtil {
    
    private TestDataUtil() {}
    
    public static Address createDummyAddressA() {
        Customer customer = createDummyCustomerA();

        return Address.builder()
            .id(UUID.fromString("3b536aa2-6147-467c-94b1-4e62204b1eb7"))
            .customer(customer)
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

    public static Review createDummyReviewA() {
        Customer customer = createDummyCustomerA();
        Product product = createDummyProductA();

        return Review.builder()
            .id(UUID.fromString("b653a927-1c7c-437a-a681-fe55f41838d7"))
            .customer(customer)
            .product(product)
            .rating(5)
            .comment("It's okay!")
            .build();
    }

    public static Payment createDummyPaymentA() {
        Invoice invoice = createDummyInvoiceA();

        return Payment.builder()
            .id(UUID.fromString("6db45d81-25f9-4a2d-9e3e-03cbf51e57d1"))
            .invoice(invoice)
            .method("Credit")
            .status("Complete")
            .createdAt(new Timestamp(666666))
            .completedAt(new Timestamp(666667))
            .build();
    }

    public static InvoiceItem createDummyInvoiceItemA() {
        Product product = createDummyProductA();

        return InvoiceItem.builder()
            .id(UUID.fromString("c35aac84-d906-4f3f-9a41-e9484b02e0ea"))
            .product(product)
            .quantity(5)
            .subtotal(15f)
            .build();
    }

    public static Invoice createDummyInvoiceA() {
        Customer customer = createDummyCustomerA();
        return Invoice.builder()
            .id(UUID.fromString("cf928da7-5af0-46bb-bd89-b19f575c1bc7"))
            .customer(customer)
            .total(10f)
            .build();
    }

    public static CartItem createDummyCartItemA() {
        Cart cart = createDummyCartA();
        Product product = createDummyProductA();
        return CartItem.builder()
            .id(UUID.fromString("744ace92-bcda-4922-8839-4e5c2bc12d77"))
            .cart(cart)
            .product(product)
            .quantity(5)
            .build();
    }

    public static Cart createDummyCartA() {
        Customer customer = createDummyCustomerA();
        return Cart.builder()
            .id(UUID.fromString("bcfceade-28e3-49eb-96b1-a7e1f1f832d2"))
            .customer(customer)
            .total(10f)
            .build();
    }
}
