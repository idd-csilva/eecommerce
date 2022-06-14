CREATE TABLE customer(
    idt_customer SERIAL PRIMARY KEY,
    des_first_name VARCHAR(100) NOT NULL,
    des_last_name VARCHAR(100) NOT NULL,
    des_email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE product(
    idt_product SERIAL PRIMARY KEY,
    des_name VARCHAR(100) NOT NULL,
    num_price DECIMAL(8,2) NOT NULL,
    num_stock_counter INT NOT NULL
);

CREATE TABLE cart(
    idt_cart SERIAL PRIMARY KEY,
    idt_customer INT REFERENCES customer (idt_customer),
    num_total_amount DECIMAL(8,2) NOT NULL
);

CREATE TABLE cart_items(
    idt_cart_items SERIAL PRIMARY KEY,
    idt_cart INT REFERENCES cart (idt_cart),
    idt_product INT REFERENCES product (idt_product),
    num_quantity INT NOT NULL
);

CREATE TABLE purchase(
    idt_purchase SERIAL PRIMARY KEY,
    idt_cart INT REFERENCES cart (idt_cart),
    ind_status VARCHAR(100) NOT null,
    dat_payed_at TIMESTAMP,
    ind_delivery_status VARCHAR(100) NOT NULL
);