CREATE DATABASE IF NOT EXISTS product_db;
USE product_db;

CREATE TABLE IF NOT EXISTS product (
    prod_id    INT PRIMARY KEY,
    prod_name  VARCHAR(100) NOT NULL,
    prod_price DECIMAL(10,2) NOT NULL
);
