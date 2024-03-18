-- liquibase formatted sql

-- changeset Nikita:1
CREATE TABLE comments
(
    comment_id   SERIAL,
    ad_id        INT,
    author_id    INT,
    comment_text VARCHAR,
    created_at   TIMESTAMP
);