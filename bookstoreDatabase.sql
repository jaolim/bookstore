DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS appuser;

CREATE TABLE category
(   categoryid BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NULL
);

INSERT INTO category (name) VALUES ('Scifi'), ('Fantasy'), ('Fiction');

CREATE TABLE book
(   id BIGSERIAL PRIMARY KEY,
    title VARCHAR(100) NULL,
    author VARCHAR(100) NULL,
    publicationyear INTEGER,
    isbn VARCHAR(20) NULL,
    price VARCHAR(20) NULL,
    categoryid BIGINT
);

CREATE TABLE appuser
(   id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    passwordhash VARCHAR(300) NOT NULL,
    userrole VARCHAR(300)
);

INSERT INTO appuser (username, passwordhash, userrole) VALUES ('user', '$2a$10$lmL29TlV8wHsF1O1BqrOdef0dIMNx/pHm8j0uCSRXlSD0qIWQjXe.', 'USER');

INSERT INTO appuser (username, passwordhash, userrole) VALUES ('admin', '$2a$10$nuwMhQSsMVCs9WpP4izM3eix57qb2wSI0xW1DAbdt8GVuP7Uxs6.2', 'ADMIN');

INSERT INTO book (title, author, publicationyear, isbn, price, categoryid) VALUES ('testi', 'testaaja', '1999', '7788996655442', '29.99', '1');