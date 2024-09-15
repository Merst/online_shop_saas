
DROP TYPE IF EXISTS customer_locale CASCADE;
CREATE TYPE customer_locale AS ENUM ('EN', 'FR');

DROP TYPE IF EXISTS payment_method CASCADE;
CREATE TYPE payment_method AS ENUM ('Credit', 'Venmo', 'Paypal', 'Other'); --Find more methods

DROP TYPE IF EXISTS payment_status CASCADE;
CREATE TYPE payment_status AS ENUM ('Complete', 'Pending', 'Incomplete', 'Refunded'); 

CREATE TABLE IF NOT EXISTS "customer" (
    "id" uuid NOT NULL ,
    "first_name" text NOT NULL,
    "middle_name" text,
    "last_name" text NOT NULL,
    "email" text NOT NULL,
    "locale" customer_locale NOT NULL,
    "created_at" timestamp NOT NULL,
    "last_login" timestamp NOT NULL,
    "email_validated" boolean DEFAULT FALSE,
    PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "supplier" (
    "id" uuid NOT NULL,
    "name" text NOT NULL,
    PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "category" (
    "id" uuid NOT NULL,
    "parent_category_id" uuid,
    "description" text,
    PRIMARY KEY ("id"),
    FOREIGN KEY (parent_category_id) REFERENCES category(id)
);

CREATE TABLE IF NOT EXISTS "product" (
    "id" uuid NOT NULL,
    "supplier_id" uuid NOT NULL,
    "category_id" uuid NOT NULL,
    "name" text NOT NULL,
    "price" numeric(9,2) NOT NULL,
    "is_available" boolean NOT NULL,
    "sale_multiplier" numeric(3,2) DEFAULT 1.00,
    "description" text,
    PRIMARY KEY ("id"),
    FOREIGN KEY (supplier_id) REFERENCES supplier(id),
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE IF NOT EXISTS "address" (
    "id" uuid NOT NULL,
    "customer_id" uuid NOT NULL,
    "digits" integer NOT NULL,
    "street" text NOT NULL,
    -- TODO: City enum
    "city" text NOT NULL,
    -- TODO: Country enum
    "country" text NOT NULL,
    -- TODO: more enums
    "state_province" text NOT NULL,
    "zipcode" text NOT NULL,
    "nickname" text,
    PRIMARY KEY ("id"),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE IF NOT EXISTS "cart" (
    "id" uuid NOT NULL,
    "customer_id" uuid NOT NULL,
    "total" numeric(9,2) NOT NULL,
    PRIMARY KEY ("id"),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE IF NOT EXISTS "cart_item" (
    "id" uuid NOT NULL,
    "product_id" uuid NOT NULL, 
    "quantity" integer NOT NULL,
    PRIMARY KEY ("id"),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE IF NOT EXISTS "invoice" (
    "id" uuid NOT NULL,
    "customer_id" uuid NOT NULL,
    PRIMARY KEY ("id"),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE IF NOT EXISTS "invoice_item" (
    "id" uuid NOT NULL,
    "product_id" uuid NOT NULL,
    "invoice_id" uuid NOT NULL,
    "quantity" integer DEFAULT 1,
    "subtotal" numeric(9,2) NOT NULL,
    PRIMARY KEY ("id"),
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (invoice_id) REFERENCES invoice(id)
);

CREATE TABLE IF NOT EXISTS "review" (
    "id" uuid NOT NULL,
    "customer_id" uuid NOT NULL,
    "product_id" uuid NOT NULL,
    "rating" integer NOT NULL,
    PRIMARY KEY ("id"),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE IF NOT EXISTS "payment" (
    "id" uuid NOT NULL,
    "invoice_id" uuid NOT NULL,
    "method" payment_method NOT NULL,
    "status" payment_status NOT NULL,
    "created_at" timestamp NOT NULL,
    "completed_at" timestamp NOT NULL,
    PRIMARY KEY ("id"),
    FOREIGN KEY (invoice_id) REFERENCES invoice(id)
);