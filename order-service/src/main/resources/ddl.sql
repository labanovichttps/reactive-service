CREATE TABLE orders
(
    id            BIGSERIAL PRIMARY KEY,
    accepted_time timestamptz NOT NULL,
    status        VARCHAR(32) NOT NULL,
    user_id       BIGINT,
    product_id    VARCHAR(64)
);