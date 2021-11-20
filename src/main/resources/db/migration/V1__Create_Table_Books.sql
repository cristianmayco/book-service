CREATE SEQUENCE book_seq;

CREATE TABLE book
(
    id          INT DEFAULT NEXTVAL('book_seq') PRIMARY KEY,
    author      text,
    lauch_date timestamp(6)   NOT NULL,
    price       decimal(65, 2) NOT NULL,
    title       text
);
