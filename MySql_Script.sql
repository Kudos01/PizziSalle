USE pizzisalle;

drop table if exists pizzas;
create table pizzas(
    pizza_id serial,
    PRIMARY KEY (pizza_id),
    pizza_name varchar(255),
    ingredients_list varchar(255),
    crust varchar(255)
);

drop table if exists customers;
create table customers(
    customer_id serial,
    PRIMARY KEY (customer_id),
    name varchar(255),
    phone varchar(255),
    dob varchar(255),
    delegation varchar(255),
    delivery_address varchar(255)
);

drop table if exists orders;
create table orders(
  order_id serial,
  pizza_id BIGINT UNSIGNED NOT NULL,
  customer_id BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (order_id, pizza_id, customer_id),
  FOREIGN KEY (pizza_id) references pizzas(pizza_id),
  FOREIGN KEY (customer_id) references customers(customer_id),
  drink varchar(255)
);