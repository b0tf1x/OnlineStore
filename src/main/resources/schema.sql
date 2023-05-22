create table if not exists aims
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(255) not null,
    description varchar(512) not null
);
create table if not exists categories
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(255) not null,
    description varchar(512) not null
);
create table if not exists pickupPoint
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    city varchar(255) not null,
    address varchar(512) not null
);
create table if not exists producer
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name varchar(255) not null,
    country varchar(512) not null
);
create table if not exists product
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    price BIGINT not null,
    name varchar(255) not null,
    description varchar(512) not null,
    application varchar(512) not null,
    amount BIGINT not null,
    category_id BIGINT not null references categories (id),
    producer_id BIGINT not null references producer (id),
    onSale BOOLEAN,
    salePrice BIGINT,
    img varchar(255)
);
create table if not exists users(
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    EMAIL VARCHAR(255) not null,
    phoneNumber VARCHAR(255) not null,
    first_name VARCHAR(255) not null,
    second_name VARCHAR(255) not null,
    dateOfBirth TIMESTAMP WITHOUT TIME ZONE not null,
    constraint uq_user_email unique (EMAIL)
);
create table if not exists review(
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    product_id BIGINT not null references products (id),
    user_id BIGINT not null references users(id),
    description VARCHAR(255) not null,
    date TIMESTAMP WITHOUT TIME ZONE not null
)

