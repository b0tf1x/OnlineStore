create table if not exists aims
(
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name varchar(255) not null,
    description varchar(512) not null
);
create table if not exists categories
(
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name varchar(255) not null,
    description varchar(512) not null
);
create table if not exists pickupPoint
(
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    city varchar(255) not null,
    address varchar(512) not null
);
create table if not exists producer
(
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name varchar(255) not null,
    country varchar(512) not null
);
create table if not exists products
(
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
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
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    EMAIL VARCHAR(255) not null,
    phoneNumber VARCHAR(255) not null,
    first_name VARCHAR(255) not null,
    second_name VARCHAR(255) not null,
    deteOfBirth TIMESTAMP WITHOUT TIME ZONE not null,
    constraint uq_user_email unique (EMAIL)
);

