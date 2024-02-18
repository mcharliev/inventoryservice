--liquibase formatted sql
--changeset Merdan_Charliev:GOR-0001.1
INSERT INTO inventoryservice.inventory_items (product_name, quantity) VALUES ('Laptop', 50);
INSERT INTO inventoryservice.inventory_items (product_name, quantity) VALUES ('Smartphone', 100);
INSERT INTO inventoryservice.inventory_items (product_name, quantity) VALUES ('Tablet', 75);
INSERT INTO inventoryservice.inventory_items (product_name, quantity) VALUES ('Smartwatch', 120);
INSERT INTO inventoryservice.inventory_items (product_name, quantity) VALUES ('E-Reader', 80);
INSERT INTO inventoryservice.inventory_items (product_name, quantity) VALUES ('Wireless Earbuds', 150);
INSERT INTO inventoryservice.inventory_items (product_name, quantity) VALUES ('Bluetooth Speaker', 90);
INSERT INTO inventoryservice.inventory_items (product_name, quantity) VALUES ('External Hard Drive', 60);
INSERT INTO inventoryservice.inventory_items (product_name, quantity) VALUES ('USB Flash Drive', 200);
INSERT INTO inventoryservice.inventory_items (product_name, quantity) VALUES ('Wireless Charger', 110);
--rollback
DELETE FROM inventoryservice.inventory_items  WHERE product_name IN ('Laptop', 'Smartphone', 'Tablet', 'Smartwatch', 'E-Reader', 'Wireless Earbuds', 'Bluetooth Speaker', 'External Hard Drive', 'USB Flash Drive', 'Wireless Charger');