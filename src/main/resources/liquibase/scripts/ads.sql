-- liquibase formatted sql

-- changeset Nikita:1
CREATE TABLE ads
(
    ad_id           BIGINT,
    author_id       VARCHAR,
    ad_price        VARCHAR,
    ad_title        VARCHAR,
    ads_description INT,
    image_path      VARCHAR
);