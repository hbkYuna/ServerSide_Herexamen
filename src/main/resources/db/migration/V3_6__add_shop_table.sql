create table shop
(
    id        integer not null GENERATED ALWAYS AS IDENTITY,
    shop_name varchar(255),
    primary key (id)
);