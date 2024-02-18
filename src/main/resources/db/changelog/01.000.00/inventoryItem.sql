--liquibase formatted sql
--changeset Merdan_Charliev:GOR-0001
CREATE TABLE inventory_items
(
    id           BIGSERIAL PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL UNIQUE,
    quantity     INTEGER NOT NULL
);
--rollback drop table inventory_item;