-- liquibase formatted sql

-- changeset Nikita:1
CREATE TABLE ads
(
    ad_id           BIGSERIAL PRIMARY KEY,
    author_id       BIGINT REFERENCES users(id),
    ad_price        INT,
    ad_title        VARCHAR,
    ads_description VARCHAR,
    image_path      VARCHAR
);