DROP TABLE IF EXISTS "Customer";
DROP TABLE IF EXISTS "Product";
DROP TABLE IF EXISTS "Address";
DROP TABLE IF EXISTS "Category";
DROP TABLE IF EXISTS "Supplier";
DROP TABLE IF EXISTS "Cart";
DROP TABLE IF EXISTS "Cart_item";
DROP TABLE IF EXISTS "Order";
DROP TABLE IF EXISTS "Order_item";
DROP TABLE IF EXISTS "Payment";
DROP TABLE IF EXISTS "Review";

CREATE TYPE customer_locale AS ENUM ('EN', 'FR');
CREATE TYPE payment_method AS ENUM ('Credit', 'Venmo', 'Paypal', 'Other'); --Find more methods
CREATE TYPE payment_status AS ENUM ('Complete', 'Pending', 'Incomplete', 'Refunded'); 

CREATE TABLE "Customer" (
    "id" uuid DEFAULT gen_random_uuid(),
    "first_name" text NOT NULL,
    "middle_name" text NOT NULL,
    "last_name" text NOT NULL,
    "email" text NOT NULL,
    "locale" customer_locale NOT NULL,
    "created_at" timestamp NOT NULL,
    "last_login" timestamp NOT NULL,
    "email_validated" boolean DEFAULT FALSE,
    CONSTRAINT "customer.pkey" PRIMARY KEY ("id")
);

CREATE TABLE "Product" (
    "id" uuid DEFAULT gen_random_uuid(),
    "supplier_id" uuid NOT NULL,
    "category_id" uuid NOT NULL,
    "name" text NOT NULL,
    "price" numeric(9,2) NOT NULL,
    "is_available" boolean NOT NULL,
    "sale_multiplier" numeric(3,2) DEFAULT 1.00,
    "description" text,
    CONSTRAINT "product.pkey" PRIMARY KEY ("id"),
    CONSTRAINT "fk_supplier" FOREIGN KEY (supplier_id) REFERENCES supplier(id),
    CONSTRAINT "fk_category" FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE "Address" (
    "id" uuid DEFAULT gen_random_uuid(),
    "customer_id" uuid NOT NULL,
    "digits" integer NOT NULL,
    "street", text NOT NULL,
    -- TODO: City enum
    "city" text NOT NULL,
    -- TODO: Country enum
    "country" text NOT NULL,
    -- TODO: more enums
    "state_province" text NOT NULL,
    "zipcode" text NOT NULL,
    "nickname" text,
    CONSTRAINT "address.pkey" PRIMARY KEY ("id"),
    CONSTRAINT "fk_customer" FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE "Category" (
    "id" uuid DEFAULT gen_random_uuid(),
    "parent_category_id" uuid,
    "description" text,
    CONSTRAINT "category.pkey" PRIMARY KEY ("id"),
    CONSTRAINT "fk_parent_category" FOREIGN KEY (parent_category_id) REFERENCES category(id)
);

CREATE TABLE "Supplier" (
    "id" uuid DEFAULT gen_random_uuid(),
    "name" text NOT NULL,
    CONSTRAINT "supplier.pkey" PRIMARY KEY ("id")
);

CREATE TABLE "Cart" (
    "id" uuid DEFAULT gen_random_uuid(),
    "customer_id" uuid NOT NULL,
    "total" numeric(9,2) NOT NULL,
    CONSTRAINT "cart.pkey" PRIMARY KEY ("id"),
    CONSTRAINT "fk_customer" FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE "Cart_item" (
    "id" uuid DEFAULT gen_random_uuid(),
    "product_id" uuid NOT NULL, 
    "quantity" integer NOT NULL,
    CONSTRAINT "cart_item.pkey" PRIMARY KEY ("id"),
    CONSTRAINT "fk_product" FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE "Order" (
    "id" uuid DEFAULT gen_random_uuid(),
    "customer_id" uuid NOT NULL,
    CONSTRAINT "order.pkey" PRIMARY KEY ("id"),
    CONSTRAINT "fk_customer" FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE "Order_item" (
    "id" uuid DEFAULT gen_random_uuid(),
    "product_id" uuid NOT NULL,
    "quantity" NOT NULL DEFAULT 1,
    "subtotal" numeric(9,2) NOT NULL,
    CONSTRAINT "order_item.pkey" PRIMARY KEY ("id"),
    CONSTRAINT "fk_product" FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE "Payment" (
    "id" uuid DEFAULT gen_random_uuid(),
    "order_id" uuid NOT NULL,
    "method" payment_method NOT NULL,
    "status" payment_status NOT NULL,
    "created_at" timestamp NOT NULL,
    "completed_at" timestamp NOT NULL,
    CONSTRAINT "payment.pkey" PRIMARY KEY ("id"),
    CONSTRAINT "fk_order" FOREIGN KEY (order_id) REFERENCES order(id)
);

CREATE TABLE "Review" (
    "id" uuid DEFAULT gen_random_uuid(),
    "customer_id" uuid NOT NULL,
    "product_id" uuid NOT NULL,
    "rating" integer NOT NULL,
    CONSTRAINT "review.pkey" PRIMARY KEY ("id"),
    CONSTRAINT "fk_customer" FOREIGN KEY (customer_id) REFERENCES customer(id),
    CONSTRAINT "fk_product" FOREIGN KEY (product_id) REFERENCES product(id)
);
