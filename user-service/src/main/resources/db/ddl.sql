CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    username VARCHAR(256) NOT NULL UNIQUE,
    balance  DECIMAL      NOT NULL
);
