-- liquibase formatted sql

-- changeset Nikita:1
CREATE TABLE users
(
    id         INTEGER,
    username   VARCHAR,
    first_name VARCHAR,
    last_name  VARCHAR,
    email      VARCHAR,
    password   VARCHAR,
    phone      VARCHAR,
    user_role  VARCHAR,
    image_user VARCHAR
)