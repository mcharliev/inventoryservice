--liquibase formatted sql
--changeset Merdan_Charliev:GOR-0001
CREATE TABLE inventory_items
(
    id           BIGSERIAL PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL UNIQUE,
    quantity     INTEGER NOT NULL
);

INSERT INTO inventory_items (product_name, quantity) VALUES ('Laptop', 50);
INSERT INTO inventory_items (product_name, quantity) VALUES ('Smartphone', 100);
INSERT INTO inventory_items (product_name, quantity) VALUES ('Tablet', 75);
INSERT INTO inventory_items (product_name, quantity) VALUES ('Smartwatch', 120);
INSERT INTO inventory_items (product_name, quantity) VALUES ('E-Reader', 80);
INSERT INTO inventory_items (product_name, quantity) VALUES ('Wireless Earbuds', 150);
INSERT INTO inventory_items (product_name, quantity) VALUES ('Bluetooth Speaker', 90);
INSERT INTO inventory_items (product_name, quantity) VALUES ('External Hard Drive', 60);
INSERT INTO inventory_items (product_name, quantity) VALUES ('USB Flash Drive', 200);
INSERT INTO inventory_items (product_name, quantity) VALUES ('Wireless Charger', 110);
--rollback drop table inventory_item;