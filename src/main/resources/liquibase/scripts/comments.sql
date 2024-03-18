-- liquibase formatted sql

-- changeset Ian:1
CREATE TABLE comments
(
    comment_id   SERIAL PRIMARY KEY,
    ad_id        INT         NOT NULL,
    author_id    INT         NOT NULL,
    comment_text VARCHAR     NOT NULL,
    created_at   TIMESTAMP   NOT NULL
);