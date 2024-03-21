-- liquibase formatted sql

-- changeset Nikita:1
CREATE TABLE comments
(
    id   BIGSERIAL PRIMARY KEY ,
    ad_id        BIGINT  REFERENCES ads(ad_id),
    author_id    BIGINT  REFERENCES users(id),
    comment_text VARCHAR,
    created_at   TIMESTAMP
);