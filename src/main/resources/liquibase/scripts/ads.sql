-- liquibase formatted sql

-- changeset Nikita:1
CREATE TABLE ads
(
    ad_id          SERIAL,
    author_id      INT,
    ad_price       INT,
    ad_title       VARCHAR,
    ad_description VARCHAR,
    image_path     VARCHAR
);